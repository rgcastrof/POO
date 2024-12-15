#include "../src/include/Kid.hpp"

Kid::Kid(int age, std::string name) : age(age), name(name) {}

int Kid::getAge() const { return age; }
void Kid::setAge(int age) { this->age = age; }

std::string Kid::getName() const { return name; }
void Kid::setName(std::string name) { this->name = name; }
