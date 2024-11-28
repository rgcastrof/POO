#include "../src/include/Market.h"
#include <iostream>

int main()
{
    std::string buffer;

    Market market(0);

    while (1) {
        std::getline(std::cin, buffer);

        std::cout << "$" << buffer + '\n';

        std::istringstream iss (buffer); /* Função para manipular o conteúdo da stream e dividí-la
                                           em variáveis separadas conforme a necessidade */
        std::string command;
        iss >> command;

        if (command == "end") {
            break;
        } else if (command == "init") {
            int cashierQtd;
            iss >> cashierQtd;
            market.init(cashierQtd, market);
        } else if (command == "arrive") {
            std::string name;
            iss >> name;
            market.arrive(name);
        } else if (command == "call") {
            int number;
            iss >> number;
            market.call(number);
        } else if (command == "finish") {
            int number;
            iss >> number;
            market.finish(number);
        } else if (command == "show") {
            std::cout << market.toString();
        } else {
            std::cout << "fail: comando invalido.\n";
        }
    }
    return 0;
}
