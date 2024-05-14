#include <iostream>

using namespace std;

class MyVector {
	int* p;
	int size;
public:
	MyVector(int n = 100) {
		p = new int[n];
		size = n;
		cout << size << " 사이즈 생성\n";
	}
	~MyVector() { 
		cout << size << " 사이즈 메모리 반환\n";
		delete[] p; 
	}
};

int main() {

	MyVector* v1, * v2;
	v1 = new MyVector(); // 디폴트로 정수 100개의 배열 동적 할당
	v2 = new MyVector(1024); // 정수 1024개의 배열 동적 할당

	delete v1;
	delete v2;

}