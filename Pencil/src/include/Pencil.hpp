#ifndef PENCIL_HPP
#define PENCIL_HPP

#include "../include/Lead.hpp"
#include <vector>

class Pencil
{
    private:
        double thickness;
        Lead* tip;
        std::vector<Lead> barrel;

    public:
        Pencil(double thickness);
        
        double getThickness() const;
        void setThickness(double thickness);


        bool insert(Lead lead);
        Lead remove();
        bool pull();
        void writePage();

        std::string toString();

};

#endif
