#include <iostream>
using namespace std;

bool bigger(int a, int b, int& big) {
	if (a == b) true;
	else {
		if (a > b) {
			big = a;
		}
		else {
			big = b;
		}
		return false;
	}
}

int main() {
	int x, y;
	cin >> x >> y;
	int big;
	
	if (bigger(x, y, big)) cout << "값이 같음";
	else cout << "값이 다름 -> " << big;
}
