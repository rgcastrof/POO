#include "../src/include/Lead.hpp"

Lead::Lead(double thickness, std::string hardness, int size) :
    thickness(thickness), hardness(hardness), size(size) {}

double Lead::getThickness() const { return thickness; }
std::string Lead::getHardness() const { return hardness; }
int Lead::getSize() const { return size; }
void Lead::setSize(int size) { this->size = size; }

void Lead::usagePerSheet()
{

}
