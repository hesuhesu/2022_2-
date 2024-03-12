#include <iostream>

using namespace std;

namespace A {
	void function(void) {
		cout << "A function " << "\n";
	}
}
namespace B {
	void function(void) {
		cout << "B function " << "\n";
	}
}

int main() {

	cout << "hello world" << "\n";
	A::function();
	B::function();
	return 0;

}
