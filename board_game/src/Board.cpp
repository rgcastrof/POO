#include "Board.hpp"
#include <iostream>

int Board::dice_one = 0;
int Board::dice_two = 0;
Board::Board(int NUM_spaces) : NUM_spaces(NUM_spaces) {}

const int Board::GET_num_spaces() const { return NUM_spaces; }

int Board::GET_dice_one()  const { return dice_one; }
void Board::SET_dice_one(int dice_one) { this->dice_one = dice_one; }

std::vector<int>& Board::GET_traps_location() { return traps_location; }

int Board::GET_dice_two() const { return dice_two; }
void Board::SET_dice_two(int dice_two) { this->dice_two = dice_two; }

void Board::add_trap(std::istringstream& iss, Board& board)
{
    int trap_space;
    iss >> trap_space;
    
    if (trap_space > NUM_spaces || trap_space < 0) {
        std::cerr << "fail: local da armadilha fora do tabuleiro.\n";
    } else {
        board.traps_location.push_back(trap_space);
        std::cout << "Armadilha posta no espaço " << trap_space << '\n';
    }
     
}
