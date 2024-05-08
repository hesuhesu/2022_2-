#include <iostream>
#include <string>

using namespace std;

double result = 0; // ���� ���

inline void setup(double num[], char str[], int final_str, int final_num) {
	if (str[final_str] == '*') result *= num[final_num];
	else if (str[final_str] == '/') result /= num[final_num];
	else if (str[final_str] == '+') result += num[final_num];
	else if (str[final_str] == '-') result -= num[final_num];
}

void error() {
	cout << "�߸��� �����Դϴ�.";
	exit(1);
}

int main() {
	string s;
	cout << "--------------------------------------------------------------------------------------\n\n";
	cout << "  '=' �� ������ ��Ģ���� ���� �Է��ϼ���(10 *+ 5 ���� �̻��� ���� ����ó�� �˴ϴ�)\n\n";
	cout << "--------------------------------------------------------------------------------------\n\n";
	cout << "�Է� : ";
	getline(cin, s, '\n');

	string sub = "";
	int index = 0;

	int num_index = -1;
	int str_index = -1;

	double num[10000];
	char str[10000];

	s.erase(remove(s.begin(), s.end(), ' '), s.end()); // ���� ���� ����
	while (true) { // �ƿ� �� ���� ������ ���� ��츦 ����
		if ((s[s.length() - 1] == '+') || (s[s.length() - 1] == '-') || (s[s.length() - 1] == '*') || (s[s.length() - 1] == '/')) s.erase(prev(s.end()));
		else break;
	}

	while (true) { // queue ������ ����ص� ������, class �� ������� �ʰ� ����

		if (index == s.length() - 1) { // ������ index �� ���
			num[++num_index] = stod(sub + s[index]);
			break;
		}

		if ((s[index] == '*') || (s[index] == '/') || (s[index] == '+') || (s[index] == '-')) {
			if (sub == "") error(); // 10 +- 5 ���� ��� ������ �Ұ���. �̸� ����
			num[++num_index] = stod(sub);
			str[++str_index] = s[index];
			sub = "";
		}
		else sub += s[index]; // string ���Ŀ� char �� �����ϴ� ������ ���� ���
		index++;
	}

	if (num_index == 0) { // ���� �ϳ��ۿ� ���� ����� ��
		cout << "result : " << num[0] << "\n";
		return 0;
	}

	result += num[0]; // ���� ���ڸ� ������
	int final_num = 1; // ���� index ���� �����ư��� ���� ����
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