#include "Tamagochi.hpp"
#include <vector>
#include <iostream>

Tamagochi::Tamagochi(int energy, int hungry, int clean, int diamonds, int age)
    : energy(energy), hungry(hungry), clean(clean), diamonds(diamonds), age(age) {}

int Tamagochi::getEnergy() const { return energy; }
void Tamagochi::setEnergy(int energy) {this->energy = energy; }

int Tamagochi::getHungry() const { return hungry; }
void Tamagochi::setHungry(int hungry) { this->hungry = hungry; }

int Tamagochi::getClean() const { return clean; }
void Tamagochi::setClean(int clean) { this->clean = clean; }

int Tamagochi::getDiamond() const { return diamonds; }
void Tamagochi::setDiamond(int diamonds) { this->diamonds = diamonds; }

int Tamagochi::getAge() const { return age; }
void Tamagochi::setAge(int age) { this->age = age; }

void Tamagochi::init(std::vector<int>& status, std::istringstream& iss, Tamagochi& tamagochi) {

    for (int i = 0; i < 3; i++) {      
        int stat;
        iss >> stat;
        status.push_back(stat);
    } 

    // Relative stats
    tamagochi.setEnergy(status.at(0));
    tamagochi.setHungry(status.at(1));
    tamagochi.setClean(status.at(2));

    // Max stats
    tamagochi.maxEnergy = status.at(0);
    tamagochi.maxHungry = status.at(1);
    tamagochi.maxClean = status.at(2);
}

void Tamagochi::show(Tamagochi& tamagochi)
{
    int maxE = tamagochi.maxEnergy;
    int maxH = tamagochi.maxHungry;
    int maxC = tamagochi.maxClean;

    std::cout << "E:" << tamagochi.getEnergy() << "/" << maxE << ", ";
    std::cout << "H:" << tamagochi.getHungry() << "/" << maxH << ", ";
    std::cout << "C:" << tamagochi.getClean() << "/" << maxC << ", ";
    std::cout << "D:" << tamagochi.getDiamond() << ", ";
    std::cout << "A:" << tamagochi.getAge() << '\n';

}

void Tamagochi::play(Tamagochi& tamagochi)
{
    tamagochi.setEnergy(tamagochi.getEnergy() - 2); 
    tamagochi.setHungry(tamagochi.getHungry() - 1);
    tamagochi.setClean(tamagochi.getClean() - 3);
    tamagochi.setDiamond(tamagochi.getAge() + 1);
    tamagochi.setAge(tamagochi.getAge() + 1);

    tamagochi.died(tamagochi);
}

void Tamagochi::eat(Tamagochi& tamagochi)
{
    tamagochi.setEnergy(tamagochi.getEnergy() - 1);
    tamagochi.setHungry(tamagochi.getHungry() + 4);
    if (tamagochi.getHungry() > tamagochi.maxHungry) {
        tamagochi.setHungry(tamagochi.maxHungry);
    }
    tamagochi.setClean(tamagochi.getClean() - 2);
    tamagochi.setAge(tamagochi.getAge() + 1);

    tamagochi.died(tamagochi);
}

void Tamagochi::sleep(Tamagochi& tamagochi)
{
    if (tamagochi.maxEnergy - tamagochi.getEnergy() < 5) {
        std::cout << "fail: nao esta com sono" << '\n';
    } else {

        int growWhileSleep = 0;
        while (tamagochi.getEnergy() < tamagochi.maxEnergy) {
            tamagochi.setEnergy(tamagochi.getEnergy() + 1);
            growWhileSleep++;
        }
        tamagochi.setAge(tamagochi.getAge() + growWhileSleep);
        tamagochi.setHungry(tamagochi.getHungry() - 1);
    }
    tamagochi.died(tamagochi);
}

void Tamagochi::shower(Tamagochi& tamagochi)
{
    tamagochi.setEnergy(tamagochi.getEnergy() - 3);
    tamagochi.setHungry(tamagochi.getHungry() -1);
    tamagochi.setClean(tamagochi.maxClean);
    tamagochi.setAge(tamagochi.getAge() + 2);

    tamagochi.died(tamagochi);
}

void Tamagochi::died(Tamagochi& tamagochi)
{
    if (tamagochi.getEnergy() <= 0) {
        std::cout << "fail: pet morreu de fraqueza" << '\n';
    }
    else if (tamagochi.getHungry() <= 0) {
        std::cout << "fail: pet morreu de fome" << '\n';
    }
    else if (tamagochi.getClean() <= 0) {
        std::cout << "fail: pet morreu de sujeira" << '\n';
    }
}
