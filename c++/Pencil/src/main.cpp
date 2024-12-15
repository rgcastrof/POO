#include "../src/include/Pencil.hpp"
#include <iostream>
#include <sstream>

int main()
{
    std::string buffer;
    Pencil pencil(0);

    while (1)
    {


        std::getline(std::cin, buffer);
        std::cout << "$" << buffer << '\n';
        std::istringstream iss (buffer);

        std::string command;
        iss >> command;
        if (command == "end") { break; }
        else if (command == "init")
        {
            double thickness;
            iss >> thickness;
            pencil.setThickness(thickness);
            
        } else if (command == "show")
        {
            std::cout << pencil.toString();
        }
    }
    return 0;
}
