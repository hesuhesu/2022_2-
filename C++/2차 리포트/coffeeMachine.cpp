#include <iostream>

using namespace std;

class coffeeMachine {
	int coffee, water, sugar;
public:
	coffeeMachine(int coffee, int water, int sugar) {
		this->coffee = coffee;
		this->water = water;
		this->sugar = sugar;
	}
	void show() {
		cout << "커피 머신 상태, 커피:" << coffee << " 물: " << water << " 설탕:" << sugar << "\n\n";
	}
	bool drinkEspresso() {
		if ((coffee >= 1) && (water >= 1)) {
			coffee -= 1;
			water -= 1;
			return true;
		}
		else {
			cout << "\n더 이상 생성 불가\n";
			Refill();
			return false;
		}
	};
	bool drinkAmericano() {
		if ((coffee >= 1) && (water >= 2)) {
			coffee -= 1;
			water -= 2;
			return true;
		}
		else {
			cout << "\n더 이상 생성 불가\n";
			Refill();
			return false;
		}
	}
	bool drinkSugerCoffee() {
		if ((coffee >= 1) && (water >= 2) && (sugar >= 1)) {
			coffee -= 1;
			water -= 2;
			sugar -= 1;
			return true;
		}
		else {
			cout << "\n더 이상 생성 불가\n";
			Refill();
			return false;
		}
	}
	bool check() {
		if ((coffee == 0) || (water == 0) || (sugar == 0)) {
			return true;
		}
		else return false;
	}
	void Refill() {
		if (coffee < 10) {
			cout << "coffee 를 " << 100 - coffee << "만큼 추가하였습니다.\n";
			coffee += (100 - coffee);
		}
		if (water < 10) {
			cout << "water 를 " << 100 - water << "만큼 추가하였습니다.\n";
			water += (100 - water);
		}
		if (sugar < 10) {
			cout << "sugar 를 " << 100 - sugar << "만큼 추가하였습니다.\n";
			sugar += (100 - sugar);
		}
	}
};

int main() {

	coffeeMachine java(50, 80, 12);
	int n;
	while (true) {
		cout << "1. 에스프레소 2. 아메리카노 3. 설탕 커피(0을 입력 시 종료) : ";
		cin >> n;
		cout << "\n";
		if (n == 0) {
			if (java.check()) java.Refill();
			break;
		}
		else if (n == 1) {
			if (java.drinkEspresso()) cout << "에스프레소를 만들었습니다.\n";
		}
		else if (n == 2) {
			if (java.drinkAmericano()) cout << "아메리카노를 만들었습니다.\n";
		}
		else if (n == 3) {
			if (java.drinkSugerCoffee()) cout << "설탕커피를 만들었습니다.\n";
		}
		else cout << "**제대로 된 정보를 입력하시오**\n";
		java.show();

	}
	return 0;
}