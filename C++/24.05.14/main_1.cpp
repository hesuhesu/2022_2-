#include <iostream>

using namespace std;

int sum(int a, int b, int c) {
	return a + b + c;
}

double sum(double a, double b) {
	return a + b;
}

int sum(int a, int b) {
	return a + b;
}


int main() {
	cout << sum(2, 5, 33) << "\n";

	cout << sum(12.5, 33.6) << "\n";

	cout << sum(2, 6) << "\n";

	return 0;
}
