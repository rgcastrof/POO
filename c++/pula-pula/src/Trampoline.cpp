#include "../src/include/Trampoline.hpp"
#include "include/Kid.hpp"
#include <sstream>
#include <iostream>

Trampoline::Trampoline() {}

std::vector<Kid> Trampoline::getPlaying() const { return playing; }
void Trampoline::setPlaying(std::vector<Kid> playing) { this->playing = playing; }

std::vector<Kid> Trampoline::getWaiting() const { return waiting; }
void Trampoline::setWaiting(std::vector<Kid> waiting) { this->waiting = waiting; }

void Trampoline::arrive(int age, std::string name)
{
    waiting.emplace_back(age, name);
}

void Trampoline::enter()
{
    playing.insert(playing.begin(), waiting.front());
    waiting.erase(waiting.begin());
}

void Trampoline::leave()
{

    waiting.push_back(playing.back());
    playing.erase(playing.end());
}

void Trampoline::removeKid(std::string name)
{
    if (waiting.empty() || playing.empty()) {
        return; 
    } else {

        Kid* ptr;
        for (int i = 0; i < waiting.size(); i++) {
            ptr = &waiting.at(i);
            if (name == ptr->getName()) {
                waiting.erase(waiting.begin() + i);
                break;
            }
        } 

        for (int i = 0; i < playing.size(); i++) {
            ptr = &playing.at(i);
            if (name == ptr->getName()) {
                playing.erase(playing.begin() + i);
                break;
            }
        }
    }
}

std::string Trampoline::toString()
{
    std::ostringstream oss;
    Kid* ptr;

    oss << "[";
    for (int i = waiting.size() - 1; i >= 0; i--) {
        ptr = &waiting.at(i);
        if (i > 0) {
            oss << ptr->getName() << ":" << ptr->getAge() << ", ";
        } else {

            oss << ptr->getName() << ":" << ptr->getAge();
        }
    }

    oss << "] => [";
    for (int i = 0; i < playing.size(); i++) {
        if (playing.empty()) {
            std::cout << "]\n"; 
            break;
        } else {
            ptr = &playing.at(i);

            if (i < playing.size() - 1) {
                oss << ptr->getName() << ":" << ptr->getAge() << ", ";
            } else {
                oss << ptr->getName() << ":" << ptr->getAge();
            }
        }
    }
    oss << "]\n";

    return oss.str();
}
