#ifndef KID_HPP
#define KID_HPP

#include <string>
class Kid
{
    private:
        int age;
        std::string name;

    public:
        Kid(int age, std::string name);

        int getAge() const;
        void setAge(int age);
        std::string getName() const;
        void setName(std::string name);

};

#endif
