#include <iostream>
#include <cstring> // c++ 표준방식

using namespace std;

int main()
{
    
    char name1[6] = { 'G', 'r', 'a', 'c', 'e', '\n' }; // 문자열
    char name2[5] = { 'G', 'r', 'a', 'c', 'e'}; // name2 문자열이 아니고 단순 문자 배열

    int n = strlen("hello");

    cout << "이름을 입력하세요 : ";

    char name[11]; // 한글은 5개 글자, 영문은 10까지 저장할 수 있다.
    cin >> name; // 키보드로부터 문자열을 읽는다. 빈 칸 없이 입력.

    cout << "이름은 " << name << "입니다\n"; // 이름을 출력한다.

	char password[11];
	cout << "프로그램을 종료하려면 암호를 입력하세요 : ";
	while (true) {
		cout << "암호 : ";
		cin >> password;
		if (strcmp(password, "C++") == 0) { // str1 < str2 면 음수 반환. str1 == str2 는 0 반환.
			cout << "프로그램을 정상 종료합니다.\n";
			break;
		}
		else cout << "암호가 틀립니다.\n";
	}
    return 0;
}
