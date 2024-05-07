#include <iostream>
using namespace std;

class Circle {
	int radius;
public:
	Circle() { 
		radius = 1;
		cout << radius << " -> 생성\n";
	}
	Circle(int radius) {
		this->radius = radius;
		cout << radius << " -> 생성\n";
	}
	void setRadius(int radius) { this->radius = radius; }
	double getArea() { return 3.14 * radius * radius; }
	~Circle() { cout << radius << " -> 소멸\n"; }
};

Circle getCircle() {
	Circle tmp(30);
	return tmp; // 객체 tmp을 리턴한다.
}

int main() {
	Circle c; // 객체가 생성된다. radius=1로 초기화된다.
	cout << c.getArea() << endl;

	c = getCircle();
	cout << c.getArea() << endl;
}
