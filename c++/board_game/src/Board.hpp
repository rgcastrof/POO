#ifndef BOARD_HPP
#define BOARD_HPP

#include <sstream>
#include <vector>

class Board
{
    private:
        int NUM_spaces;
        std::vector<int> traps_location;
        static int dice_one;
        static int dice_two;

    public:
        Board(int NUM_spaces);

        const int GET_num_spaces() const;
        int GET_dice_one() const;
        void SET_dice_one(int dice_one);

        std::vector<int>& GET_traps_location(); 

        int GET_dice_two() const;
        void SET_dice_two(int dice_two);

        void add_trap(std::istringstream& iss, Board& board);
};

 #endif
