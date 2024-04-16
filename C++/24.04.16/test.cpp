#include <iostream>

using namespace std;

class Circle {
	int radius;
public:
	void setRadius(int r) { radius = r; }
	double getArea();
};

double Circle::getArea() { return 3.14 * radius * radius; }

int main() {

	Circle circleArray[3];

	int n;
	int count = 0;
	for (int i = 0; i < 3; i++) {
		cin >> n;
		circleArray[i].setRadius(n);
		if (circleArray[i].getArea() > 100) {
			count++;
		}
	}

	for (int i = 0; i < 3; i++) {
		cout << "원 " << n << "의 반지름 >> " << circleArray[i].getArea() << "\n";
	}

	cout << "면적이 100보다 큰 원은 " << count <<"개 입니다.";

	return 0;

};
