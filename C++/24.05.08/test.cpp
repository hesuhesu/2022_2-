#include <iostream>
#include <cstring>
using namespace std;

char& find(char a[], char c, bool& success) {
	int i = 0;
	while (1) {
		if (a[i] == '\0') {
			break;
		}
		if (a[i] == c) {
			a[i] == c;
			success = true;
			return a[i];
		}
	}
}

int main() {
	
	char s[] = "Mike";
	bool b = false;
	char& loc = find(s, 'M', b);
	if (b == false) {
		cout << "M을 발견할 수 없다" << "\n";
		return 0;
	}
	loc = 'm';
	cout << s << "\n";
	return 0;
}
