#include <iostream>

using namespace std;

class Rectangle {
	float main_width;
	float main_height;
	string main_name;
public :
	Rectangle(float width, float height, string name);
	
	float getArea();
	void getTotal();
};

Rectangle::Rectangle(float width, float height, string name) {
	main_width = width;
	main_height = height;
	main_name = name;
}

float Rectangle::getArea() {
	return main_width * main_height;
}
void Rectangle::getTotal() {
	cout << "너비 : " << main_width << ", 높이 : " << main_height <<", 이름 : " << main_name << "\n";
}

int main() {
	
	float n1, n2;
	string str;
	cout << "너비 : ";
	cin >> n1;
	cout << "높이 : ";
	cin >> n2;
	cout << "이름 : ";
	cin >> str;

	Rectangle rect(n1, n2, str);
	cout << "사각형의 면적은 " << rect.getArea() << "\n";
	rect.getTotal();

	return 0;
}
