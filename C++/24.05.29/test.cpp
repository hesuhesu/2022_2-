#include <iostream>

using namespace std;

class Circle {
	int radius;
public:
	Circle(int radius = 0) { this->radius = radius; }
	void show() { cout << "radius = " << radius << "인 원\n"; }
	friend Circle& operator++(Circle& op); // 전위 ++ 연산자 함수 프렌드 선언
	friend Circle operator++(Circle& op, int x); // 후위 ++ 연산자 함수 프렌드 선언
	friend Circle operator+(int op1, Circle op2); // 프렌드 선언

};

Circle& operator++(Circle& op) { // 전위 ++ 연산자 함수 구현
	op.radius++;
	return op; // 연산 결과 리턴
}

Circle operator++(Circle& op, int x) { // 후위 ++ 연산자 함수 구현
	Circle tmp = op; // 변경하기 전의 op 상태 저장
	op.radius++;
	return tmp; // 변경 이전의 op 리턴
}

Circle operator+(int op1, Circle op2) {
	Circle tmp; // 임시 객체 생성
	tmp.radius = op1 + op2.radius;
	return tmp; // 임시 객체 리턴
}

int main() {

	Circle a(5), b(4);
	++a;
	b = a++;
	a.show();
	b.show();

	Circle c(5), d(4);
	d = 1 + c;
	c.show();
	d.show();

	return 0;
}
