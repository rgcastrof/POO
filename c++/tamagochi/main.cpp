#include "Tamagochi.hpp"
#include <iostream>
#include <string>
#include <sstream>

int main()
{

    Tamagochi tamagochi(0, 0, 0, 0, 0);
    std::string buffer;

    while (1) {
        std::getline(std::cin, buffer);
        std::istringstream iss (buffer);

        std::string command;
        std::vector<int> status;

        iss >> command;

        if (command == "show") {
            tamagochi.show(tamagochi);
        }
        if (command == "init") {
            tamagochi.init(status, iss, tamagochi);
        }
        if (command == "play")
        {
            if (tamagochi.getEnergy() <= 0 || tamagochi.getHungry() <= 0 ||
            tamagochi.getClean() <= 0) {
                std::cout << "fail: pet esta morto" << '\n';
            } else {
                tamagochi.play(tamagochi);
            }
        }
        if (command == "eat")
        {
            if (tamagochi.getEnergy() <= 0 || tamagochi.getHungry() <= 0 ||
            tamagochi.getClean() <= 0) {
                std::cout << "fail: pet esta morto" << '\n';
            } else {
                tamagochi.eat(tamagochi);
            }
        }
        if (command == "sleep")
        {
            if (tamagochi.getEnergy() <= 0 || tamagochi.getHungry() <= 0 ||
            tamagochi.getClean() <= 0) {
                std::cout << "fail: pet esta morto" << '\n';
            } else {
                tamagochi.sleep(tamagochi);
            }
        }
        if (command == "clean")
        {
            if (tamagochi.getEnergy() <= 0 || tamagochi.getHungry() <= 0 ||
            tamagochi.getClean() <= 0) {
                std::cout << "fail: pet esta morto" << '\n';
            } else {
                tamagochi.shower(tamagochi);
            }
        }
        if (command == "end") { break; }
    }

    return 0;
}
