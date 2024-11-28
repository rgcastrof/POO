#include <cstdlib>
#include <iostream>
#include <sstream>
#include <string>

#include "Player.hpp"
#include "Board.hpp"


int main()
{
    std::string buffer;
    std::vector<Player> playersList;   // Lista para armazenar os jogadores 
    

    while(1) {
        std::cout << "> ";
        std::getline(std::cin, buffer);     // lê as entradas do usuário e armazena-as
        std::istringstream iss (buffer);    // em um iss para condições posteriores


        /* A partir daqui armazena o primeiro comando da
         * string inicial em 'command' e, de acordo com
         * o que foi lido, chamará cada função correspondente
         */
        std::string command;
        iss >> command;

        if (command == "end") { break; }

        else if (command == "init") {
            std::string command_two;
            iss >> command_two;
            if (command_two == "board") {
                int board_spaces;
                iss >> board_spaces;
                Board board(board_spaces);
                std::cout << "Tabuleiro criado com " << board_spaces << " casas.\n";

                std::string IN_game_commands;
                while (1) {
                    std::cout << "> ";

                    std::getline(std::cin, IN_game_commands);
                    std::istringstream iss (IN_game_commands); 

                    std::string IN_game_command_one;
                    iss >> IN_game_command_one;

                    if (IN_game_command_one == "end") { return EXIT_SUCCESS; }
                    else if (IN_game_command_one == "init") {
                        std::string IN_game_command_two;
                        iss >> IN_game_command_two;

                        if (IN_game_command_two == "player") {
                            Player::init(iss, playersList);
                        }
                        else {
                            std::cerr << "fail: comando invalido.\n";
                        }
                    }
                    else if (IN_game_command_one == "add") {
                        std::string IN_game_command_two;
                        iss >> IN_game_command_two;

                        if (IN_game_command_two == "trap") {
                            board.add_trap(iss, board);
                        }
                    }
                    else if (IN_game_command_one == "show") {
                        Player::show_position(iss, playersList);
                    }
                    else if (IN_game_command_one == "roll") {
                        Player::roll_dices(iss, board, playersList); 
                    }
                }
            }

            else {
                std::cerr << "fail: tabuleiro precisa ser criado para iniciar o jogo.\n";
            }
        }

        else {
            std::cerr << "fail: comando invalido.\n";
        }
    }
    return 0;
}
