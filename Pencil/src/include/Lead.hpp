#ifndef LEAD_HPP
#define LEAD_HPP

#include <string>
class Lead
{
    private:
        double thickness;
        std::string hardness;
        int size;

    public:
        Lead(double thickness, std::string hardness, int size);

        double getThickness() const;
        std::string getHardness() const;
        int getSize() const;
        void setSize(int size); 

        void usagePerSheet();
};

#endif
