#ifndef TAMAGOCHI_HPP
#define TAMAGOCHI_HPP
    
#include <vector>
#include <sstream>

class Tamagochi
{
    private:
        int energy;
        int hungry;
        int clean;
        int diamonds;
        int age;

        int maxEnergy;
        int maxHungry;
        int maxClean;

    public:
        Tamagochi(int energy, int hungry, int clean, int diamonds, int age);

        int getEnergy() const;
        void setEnergy(int energy);

        int getHungry() const;
        void setHungry(int hungry);

        int getClean() const;
        void setClean(int clean);

        int getDiamond() const;
        void setDiamond(int diamonds);

        int getAge() const;
        void setAge(int age);

        void init(std::vector<int>& status, std::istringstream& iss, Tamagochi& tamagochi);
        void show(Tamagochi& tamagochi);

        void play(Tamagochi& tamagochi);

        void eat(Tamagochi& tamagochi);

        void sleep(Tamagochi& tamagochi);

        void shower(Tamagochi& tamagochi);

        void died(Tamagochi& tamagochi);
};

#endif
