#include <iostream>
using namespace std;

class OOP {
	int m;
public :
	OOP() { 
		m = 1;
		cout << "생성 : " << 1 << "\n"; 
	}
	OOP(int m) { 
		this->m = m;
		cout << "생성 : " << m << "\n"; 
	}
	~OOP() { cout << "소멸 : " << m << "\n"; }
};

OOP oops(11), oops2(22);

void OP() {
	OOP op1(2), op2(3);
}

int main() {
	
	OP();
	OOP oop1, oop2(10);
	
	return 0;
}
