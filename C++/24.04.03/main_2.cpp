#include <iostream>

using namespace std;

class PP {
	string color;
public :
	PP();
	PP(string color);
	string getColor();
};

PP::PP() { color = "black"; }
PP::PP(string color) { this->color = color; }
string PP::getColor() { return color; }

int main() {
	
	PP p1, p2("yellow");

	cout << "p1 color : " << p1.getColor() << ", p2 color : " << p2.getColor() << "\n";

	return 0;
}
