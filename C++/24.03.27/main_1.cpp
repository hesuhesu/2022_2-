#include <iostream>

using namespace std;

int main() {

	int a = 5;
	int* p;
	p = &a;

	cout << "a : " << a << ", &a(a의 주소) : " << &a << "\n";
	cout << "*p : " << *p << ", p(p의 주소) : " << p << "\n";

	cout << "-----------------------------------------------------------\n";

	int n[10];
	int* p1 = n;

	n[5] = 8; // n 의 index 5 주소에 8 기록
	cout << "n + 5 = " << n + 5 << "\n";
	cout << "*(n + 5) = " << *(n + 5) << "\n";
	p1 = p1 + 7;
	*p1 = 99;

	cout << "*p = " << *p1 << "\n";
	cout << "n[7] = " << n[7] << "\n";

	return 0;
}
