#include <iostream>

using namespace std;

bool isMultiple(int a, int b);

int main() {
	
	int a, b;
	cout << "a 와 b 를 입력하시오 : ";
	cin >> a >> b;

	if (isMultiple(a, b) == true) {
		cout << "배수관계가 맞습니다.";
	}
	else {
		cout << "배수관계가 맞습니다.";
	}
	return 0;
}

bool isMultiple(int a, int b) {
	if (b < a) {
		int swap = a;
		a = b;
		b = swap;
	}
	if (b % a == 0) return true;
	else return false;
}
