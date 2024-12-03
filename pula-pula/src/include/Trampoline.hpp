#ifndef TRAMPOLINE_HPP
#define TRAMPOLINE_HPP

#include <vector>
#include "Kid.hpp"

class Trampoline
{
    private:
        std::vector<Kid> playing;
        std::vector<Kid> waiting;

    public:
        Trampoline();

        std::vector<Kid> getPlaying() const;
        void setPlaying(std::vector<Kid> playing);

        std::vector<Kid> getWaiting() const;
        void setWaiting(std::vector<Kid> waiting);

        void arrive(int age, std::string name);
        void enter();
        void leave();
        void removeKid(std::string name);

        std::string toString();
};

#endif
