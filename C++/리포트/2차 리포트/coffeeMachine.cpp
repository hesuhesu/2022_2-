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
		cout << "Ŀ�� �ӽ� ����, Ŀ��:" << coffee << " ��: " << water << " ����:" << sugar << "\n\n";
	}
	bool drinkEspresso() {
		if ((coffee >= 1) && (water >= 1)) {
			coffee -= 1;
			water -= 1;
			return true;
		}
		else {
			cout << "\n�� �̻� ���� �Ұ�\n";
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
			cout << "\n�� �̻� ���� �Ұ�\n";
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
			cout << "\n�� �̻� ���� �Ұ�\n";
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
			cout << "coffee �� " << 100 - coffee << "��ŭ �߰��Ͽ����ϴ�.\n";
			coffee += (100 - coffee);
		}
		if (water < 10) {
			cout << "water �� " << 100 - water << "��ŭ �߰��Ͽ����ϴ�.\n";
			water += (100 - water);
		}
		if (sugar < 10) {
			cout << "sugar �� " << 100 - sugar << "��ŭ �߰��Ͽ����ϴ�.\n";
			sugar += (100 - sugar);
		}
	}
};

int main() {

	coffeeMachine java(50, 80, 12);
	int n;
	while (true) {
		cout << "1. ���������� 2. �Ƹ޸�ī�� 3. ���� Ŀ��(0�� �Է� �� ����) : ";
		cin >> n;
		cout << "\n";
		if (n == 0) {
			if (java.check()) java.Refill();
			break;
		}
		else if (n == 1) {
			if (java.drinkEspresso()) cout << "���������Ҹ� ��������ϴ�.\n";
		}
		else if (n == 2) {
			if (java.drinkAmericano()) cout << "�Ƹ޸�ī�븦 ��������ϴ�.\n";
		}
		else if (n == 3) {
			if (java.drinkSugerCoffee()) cout << "����Ŀ�Ǹ� ��������ϴ�.\n";
		}
		else cout << "**����� �� ������ �Է��Ͻÿ�**\n";
		java.show();

	}
	return 0;
}