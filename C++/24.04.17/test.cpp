#include <iostream>
using namespace std;

class Circle {
	int radius;
public:
	void setRadius(int r) { radius = r; }
	double getArea() { return 3.14 * radius * radius; }
};


int main() {

	int n;

	cout << "원의 개수 >> ";
	cin >> n;
	Circle* pArray = new Circle[n]; 

	int n2;
	int count = 0;
	for (int i = 0; i < n; i++) {
		cout << "원" << i + 1 << "의 반지름 >> ";
		cin >> n2;
		pArray[i].setRadius(n2);
		if (pArray[i].getArea() > 100) {
			count++;
		}
		
	}

	cout << "면적이 100보다 큰 원은 " << count << "개 입니다.";

	delete[] pArray;
}
