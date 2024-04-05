#include <iostream>

using namespace std;

class Circle {
private :
	int radius;
public :
	Circle() { radius = 1; }
	Circle(int radius) { this->radius = radius; }
	double getArea() { return 3.14 * radius * radius; }
};

void swap(Circle* a, Circle* b) {
	Circle temp = *a;
	*a = *b;
	*b = temp;
}

int main() {
	
	Circle c1;
	Circle c2(2);

	swap(&c1, &c2);

	cout << c1.getArea() << " " << c2.getArea();

	return 0;
}
