#include <cstdlib>
#include <iostream>
#include <random>
#include <vector>
#include "Player.hpp"
#include "Board.hpp"

// Implementação dos métodos da classe player

Player::Player(std::string player_name, int position) : player_name(player_name), position(position),
can_play(true), winner(false) {}

// Implementação dos getters e setters
std::string Player::GET_player_name() const { return player_name; }
void Player::SET_player_name(std::string player_name) { this->player_name = player_name; }

int Player::GET_position() const { return position; }
void Player::SET_position(int position) { this->position = position; }

bool Player::GET_can_play() const { return can_play; }
void Player::SET_can_play(bool can_play) { this->can_play = can_play; }

void Player::SET_winner(bool winner) { this->winner = winner; }

void Player::init(std::istringstream& iss, std::vector<Player>& playersList)
{
    std::string player_name; 
    iss >> player_name;

    playersList.emplace_back(player_name, 0);
    std::cout << "Player " << player_name << " criado.\n";
}

void Player::show_position(std::istringstream &iss, std::vector<Player>& playersList)
{
    std::string player_name;
    iss >> player_name;

    Player *ptr = nullptr;

    for (int i = 0; i < playersList.size(); i++) {
        ptr = &playersList.at(i);
        if (player_name == ptr->GET_player_name()) {
            std::cout << "Posição do jogador " << ptr->GET_player_name() << ": "
                << ptr->GET_position() << '\n';
        }
    }
}


    /* Implementação do método para rolar os dados
     * Utiliza biblioteca <random> para gerar numeros
     * e atribui-os ao dados da classe board com os métodos getter e setters
     * desta classe
    */
void Player::roll_dices(std::istringstream& iss, Board& board, std::vector<Player>& playersList)
{
    std::string player_name;
    iss >> player_name;

    Player* ptr;
    std::vector<int>* traps_location = &board.GET_traps_location();
    
    for (int i = 0; i < playersList.size(); i++) {

        ptr = &playersList.at(i);
        if (player_name == ptr->GET_player_name()) {


            if (!ptr->GET_can_play()) {
                std::cout << "jogador " << ptr->GET_player_name() << " caiu em uma armadilha e não pode jogar\n";
                ptr->SET_can_play(true);
                return;
            } 

            std::random_device rd;
            std::mt19937 gen(rd());

            std::uniform_int_distribution<int> dist(1, 6);
            board.SET_dice_one(dist(gen));
            board.SET_dice_two(dist(gen));
            std::cout << "Dados lançados:\n";
            std::cout << "Dado número um: " << board.GET_dice_one() << ". ";
            std::cout << "Dado número dois: " << board.GET_dice_two() << '\n';

            ptr->SET_position(ptr->GET_position() + (board.GET_dice_one() + board.GET_dice_two()));
            std::cout << "jogador " << ptr->GET_player_name() << " moveu para a casa " <<
            ptr->GET_position() << '\n';

            for (int i = 0; i < traps_location->size(); i++) {
                if (ptr->GET_position() == traps_location->at(i)) {
                    std::cout << "Jogador " << ptr->GET_player_name() << " caiu em uma armadilha e nao podera jogar no proximo turno\n";
                    ptr->SET_can_play(false);
                    break;
                }
            }

            if (ptr->GET_position() >= board.GET_num_spaces()) {
                std::cout << "Jogador " << ptr->GET_player_name() << " venceu.\n";
                std::cout << "Fim de jogo.\n";
                exit(EXIT_SUCCESS);
            }
        }
        return;
    }
}

