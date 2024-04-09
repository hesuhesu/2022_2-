#include <iostream>
using namespace std;

class Person {
	string name;
	int age;
public :
	Person() {
		name = "bear";
		age = 20;
	}
	Person(string name) {
		this->name = name;
		age = 24;
	}
	Person(string name, int age) {
		this->name = name;
		this->age = age;
	}
	~Person() { cout << name <<"님의 기록이 삭제되었습니다.\n"; }
	string getName() { return name; }
	int getAge() { return age; }
};


int main() {
	
	Person ps;
	Person pa("cat", 22);
	Person pt("dog");

	cout << "이름 : " << ps.getName() << ", 나이 : " << ps.getAge() << "\n";
	cout << "이름 : " << pa.getName() << ", 나이 : " << pa.getAge() << "\n";
	cout << "이름 : " << pt.getName() << ", 나이 : " << pt.getAge() << "\n";

	return 0;
}
