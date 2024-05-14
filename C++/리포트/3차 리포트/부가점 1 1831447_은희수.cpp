#include <iostream>
#include <string>

using namespace std;

double result = 0; // 최종 결과

inline void setup(double num[], char str[], int final_str, int final_num) {
	if (str[final_str] == '*') result *= num[final_num];
	else if (str[final_str] == '/') result /= num[final_num];
	else if (str[final_str] == '+') result += num[final_num];
	else if (str[final_str] == '-') result -= num[final_num];
}

void error() {
	cout << "잘못된 접근입니다.";
	exit(1);
}

int main() {
	string s;
	cout << "--------------------------------------------------------------------------------------\n\n";
	cout << "  '=' 을 제외한 사칙연산 식을 입력하세요(10 *+ 5 같은 이상한 식은 오류처리 됩니다)\n\n";
	cout << "--------------------------------------------------------------------------------------\n\n";
	cout << "입력 : ";
	getline(cin, s, '\n');

	string sub = "";
	int index = 0;

	int num_index = -1;
	int str_index = -1;

	double num[10000];
	char str[10000];

	s.erase(remove(s.begin(), s.end(), ' '), s.end()); // 공백 완전 제거
	while (true) { // 아예 맨 뒤의 연산이 있을 경우를 제거
		if ((s[s.length() - 1] == '+') || (s[s.length() - 1] == '-') || (s[s.length() - 1] == '*') || (s[s.length() - 1] == '/')) s.erase(prev(s.end()));
		else break;
	}

	while (true) { // queue 구조를 사용해도 되지만, class 를 사용하지 않고 구성

		if (index == s.length() - 1) { // 마지막 index 의 경우
			num[++num_index] = stod(sub + s[index]);
			break;
		}

		if ((s[index] == '*') || (s[index] == '/') || (s[index] == '+') || (s[index] == '-')) {
			if (sub == "") error(); // 10 +- 5 같은 경우 연산이 불가능. 이를 제외
			num[++num_index] = stod(sub);
			str[++str_index] = s[index];
			sub = "";
		}
		else sub += s[index]; // string 형식에 char 를 적립하는 식으로 숫자 계산
		index++;
	}

	if (num_index == 0) { // 숫자 하나밖에 없는 경우의 수
		cout << "result : " << num[0] << "\n";
		return 0;
	}

	result += num[0]; // 시작 숫자를 더해줌
	int final_num = 1; // 이후 index 부터 번갈아가며 식을 적용
	int final_str = 0;

	while (true) {
		if (final_num == num_index) {
			setup(num, str, final_str, final_num);
			break;
		}
		else setup(num, str, final_str, final_num);
		final_num++;
		final_str++;
	}
	cout << "result : " << result << "\n";
	return 0;
}