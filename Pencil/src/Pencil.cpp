#include "../src/include/Pencil.hpp"
#include <sstream>

Pencil::Pencil(double thickness) : thickness(thickness)
{
    tip = nullptr;
}

double Pencil::getThickness() const { return thickness; }
void Pencil::setThickness(double thickness) { this->thickness = thickness; }

std::string Pencil::toString()
{
    std::ostringstream oss;

    oss << "calibre: " << Pencil::getThickness() << '\n';

    return oss.str();
}
