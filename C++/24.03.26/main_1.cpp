#include <iostream>

using namespace std;

void input_process();

int main() {
	
	input_process();

	return 0;
}

void input_process() {
	string name;
	int std_id;
	while (1) {
		cout << "이름 입력 : ";
		cin >> name;

		cout << "학번 입력 : ";
		cin >> std_id;

		if (std_id == 0) {
			break;
		}

		cout << "------------------------------------------------\nname : " << name << "\n";
		cout << "std_id : " << std_id << "\n------------------------------------------------\n";
	}
}
