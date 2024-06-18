#include <iostream>
using namespace std;

class Circle {
	int radius;
public:
	Circle(int radius = 0) { this->radius = radius; }
	int getRadius() { return radius; }
	void setRadius(int radius = 0) { this->radius = radius; }
	double getArea() { return 3.14 * radius * radius; }
};

class NamedCircle : public Circle {
	string name;
public:
	void setRN(int radius, string name) {
		this->name = name;
		setRadius(radius);
	}
	string getName() {
		return name;
	}
};

int main() {

	NamedCircle pizza[3];

	cout << "3 개의 정수 반지름과 원의 이름을 입력하세요\n";

	int r;
	string str;
	int bigger = 0;
	int biggerIndex = 0;
	for (int i = 0; i < 3; i++) {
		cout << (i+1) << ">> ";
		cin >> r >> str;
		pizza[i].setRN(r, str);
		if (bigger <= r) { bigger = r; biggerIndex = i; }
	}

	cout << "가장 면적이 큰 피자는 " << pizza[biggerIndex].getName();
	
	return 0;
}
