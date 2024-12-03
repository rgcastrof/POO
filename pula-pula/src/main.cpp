#include <iostream>
#include <sstream>
#include "../src/include/Trampoline.hpp"

int main()
{

    std::string buffer;
    std::string command;
    Trampoline trampoline;

    while (1) {
        std::getline(std::cin, buffer); 
        std::cout << "$" << buffer << '\n';
        std::istringstream iss (buffer);
        iss >> command;

        if (command == "end") { break; }
        else if (command == "arrive") {
            std::string name;
            int age;
            iss >> name;
            iss >> age;
            trampoline.arrive(age, name);
        } else if (command == "enter") {
            trampoline.enter();
        } else if (command == "leave") {
            trampoline.leave();
        } else if (command == "show") {
            std::cout << trampoline.toString() << "\n";
        } else if (command == "remove") {
            std::string name;
            iss >> name;
            trampoline.removeKid(name);
        } else {
            std::cout << "fail: comando invalido.\n";
        }
    }
    return 0;
}
