// Declaração dos atributos e métodos da classe Person

#ifndef __PERSON_H__
#define __PERSON_H__

#include <string>
class Person {
    private:
        std::string name;

    public:
        Person(std::string name);

        std::string getName() const;
        void setName(std::string name);
};

#endif
