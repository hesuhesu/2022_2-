#include <iostream>

using namespace std;

class CoffeeMachine {
	int a, b, c;
public:
	CoffeeMachine(int a, int b, int c) {
		this->a = a;
		this->b = b;
		this->c = c;
	}
	void show() {
		cout << "커피 머신 상태, 커피:" << a << " 물: " << b << " 설탕:" << c << "\n";
	}
	void drinkEspresso() {
		a -= 1;
		b -= 1;
	};
	void drinkAmericano(){
		a -= 1;
		b -= 2;
	}
	void drinkSugerCoffee(){
		a -= 1;
		b -= 2;
		c -= 1;
	}
	void fill(){
		a, b, c = 10;
	}
};

int main() {
	
	CoffeeMachine java(5, 10, 3);
	java.drinkEspresso();
	java.show();
	java.drinkAmericano();
	java.show();
	java.drinkSugerCoffee();
	java.show();
	java.fill();
	java.show();
	return 0;
}
