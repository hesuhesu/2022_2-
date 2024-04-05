#include <iostream>
using namespace std;

void swap(int a, int b) {
	int tmp;

	tmp = a;
	a = b;
	b = tmp;
}
void swap2(int* a, int* b) {
	int tmp;

	tmp = *a;
	*a = *b;
	*b = tmp;
}
int main() {

	int m = 2, n = 9;
	swap(m, n);
	cout << m << ' ' << n << "\n";

	int m2 = 3, n2 = 5;
	swap2(&m2, &n2);
	cout << m2 << ' ' << n2;
	
	return 0;
}
