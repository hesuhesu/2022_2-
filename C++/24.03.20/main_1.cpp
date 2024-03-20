#include <iostream>

using namespace std;

class Rectangle {
	float main_width;
	float main_height;
public :
	Rectangle(float width, float height);
	
	float getArea();
};

Rectangle::Rectangle(float width, float height) {
	main_width = width;
	main_height = height;
}

float Rectangle::getArea() {
	return main_width * main_height;
}

int main() {
	
	float n1, n2;
	cout << "너비 : ";
	cin >> n1;
	cout << "높이 : ";
	cin >> n2;

	Rectangle rect(n1, n2);
	cout << "사각형의 면적은 " << rect.getArea() << endl;

	return 0;
}
