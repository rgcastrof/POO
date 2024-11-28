#ifndef PLAYER_HPP
#define PLAYER_HPP

#include <vector>
#include <string>
#include <sstream>

class Board;

// Declaração da classe player, seus atributos e métodos
class Player
{
    private:
        std::string player_name;
        int position;
        bool can_play;
        bool winner;
    public:
        Player(std::string player_name, int position); // Construtor
        ~Player() = default;

        // Getter e setter para nome do player
        std::string GET_player_name() const;
        void SET_player_name(std::string player_name);

        // Getter e setter para posição do player
        int GET_position() const;
        void SET_position(int position); 

        bool GET_can_play() const;
        void SET_can_play(bool can_play);

        void SET_winner(bool winner);

        static void init(std::istringstream& iss, std::vector<Player>& playersList); // Método para criar um novo player
        static void show_position(std::istringstream& iss, std::vector<Player>& playersList); // Método para mostrar status do player

        static void roll_dices(std::istringstream& iss, Board &board, std::vector<Player>& playersList); // Método para rolar os dados


};

#endif
