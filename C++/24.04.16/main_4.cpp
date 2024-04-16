#include <iostream>

using namespace std;

class Circle {
	int radius;
public:
	Circle() { radius = 1; }
	Circle(int r) { radius = r; }
	void setRadius(int r) { radius = r; }
	double getArea();
};

double Circle::getArea() { return 3.14 * radius * radius; }

int main() {

	Circle circleArray[2][3] = { {Circle(1),Circle(2), Circle(3)} ,{Circle(4),Circle(5), Circle(6)}};

	for (int i = 0; i < 2; i++) {
		for (int j = 0; j < 3; j++) {
			cout << "Circle[i, j] 의 면적은 " << circleArray[i][j].getArea() << "\n";
		}
	}

	return 0;

};
