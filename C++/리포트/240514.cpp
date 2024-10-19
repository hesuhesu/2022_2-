#include <iostream>

using namespace std;

class Person {
	int id;
	double weigth;
	string name;
public:
	/*Person(int id = 1, string name = "Grace", double weigth = 20.5) {
		this->id = id;
		this->name = name;
		this->weigth = weigth;
	}*/
	Person() {
		id = 1;
		name = "Grace";
		weigth = 20.5;
	}
	Person(int id, string name) {
		this->id = id;
		this->name = name;
		weigth = 20.5;
	}
	Person(int id, string name, double weigth) {
		this->id = id;
		this->name = name;
		this->weigth = weigth;
	}
	void show() { cout << id << " " << weigth << " " << name << "\n"; }
};

int main() {

	Person grace, ashley(2, "Ashley"), hellen(3, "Hellen", 32.5);
	grace.show();
	ashley.show();
	hellen.show();
	return 0;

}
