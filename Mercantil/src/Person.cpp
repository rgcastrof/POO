#include "../src/include/Person.h"

// Construtor da classe person
Person::Person(std::string name) : name(name) {}

// Getters e setters da classe Person
std::string Person::getName() const { return name; }
void Person::setName(std::string name) { this->name = name; }
