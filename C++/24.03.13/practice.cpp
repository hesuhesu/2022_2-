#include <iostream>
#include <string>

using namespace std;

int main()
{
    
	char password[100];
	while (true) {
		cout << "입력하시오 : ";
		cin >> password;
		if (strcmp(password, "yes") == 0) { // str1 < str2 면 음수 반환. str1 == str2 는 0 반환.
			cout << "yes 확인 완료!\n";
			break;
		}
		else cout << "xxxxx\n";
	}

	int a, b;
	string str;

	cout << "\n아래에 식을 입력하시오..\n\n";
	cin >> a >> str >> b;

	if (str == "+") cout << "답은 : " << a + b;
	else if (str == "-") cout << "답은 : " << a - b;
	else if (str == "*") cout << "답은 : " << a * b;
	else if (str == "/") cout << "답은 : " << a / b;
	else cout << "답은 : " << a % b;

    return 0;
}
