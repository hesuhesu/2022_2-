#include <iostream>
#include <string>

using namespace std;

class Stack { // stack ����
public:
	string arr[10000];
	string sub = ""; // 1�� �ڸ��� �ƴ� ���ɼ��� ����. N�ڸ� �� ���� ��� ����
	int arr_last = -1;
	void push(string data) { arr[++arr_last] = data; }
	bool empty() { return (arr_last < 0); }
	string pop() {
		if (empty()) return "nothing";
		return arr[arr_last--];
	}
	int size() { return arr_last + 1; }
};

inline void setup(Stack* stack) { // �ݺ��� ���̱��
	stack->push(stack->sub);
	stack->sub = "";
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
	int startIndex = 0; // ���ڿ� ���� �˻��� ���� �ε���
	double result = 0; // ���� ���
	string look = "";
	Stack stack;

	s.erase(remove(s.begin(), s.end(), ' '), s.end()); // ���� ���� ����
	while (true) { // �ƿ� �� ���� ������ ���� ��츦 ����
		if ((s[s.length() - 1] == '+') || (s[s.length() - 1] == '-') || (s[s.length() - 1] == '*') || (s[s.length() - 1] == '/')) s.erase(prev(s.end()));
		else break;
	}
	while (true) { // 1�� ���ڿ� ���� ��� => *, / �� ���� �������� �� stack �� +, - �� ���� �� ����ϴ� ���

		// ���ϱ�
		if (s[startIndex] == '*') {

			string test = "";
			while (true) { // ���� ���ڸ� �Ϻ��� ã�� �� ���� ����
				startIndex++;

				// ��Ģ������ ���� ��
				if ((s[startIndex] == '+') || (s[startIndex] == '-') || (s[startIndex] == '*') || (s[startIndex] == '/')) { // ��Ģ������ ���� �� ����
					if (test == "") error(); // �������� ��Ģ���� �߻��� �߸��� ������ �ν�
					stack.sub = to_string(stod(stack.sub) * stod(test));
					startIndex--; // ��Ģ������ �߰������Ƿ� �߰� ���� ��ĭ ������ �̵�
					break;
				}
				// �ִ� index ���̸鼭 ������ ��
				else if (startIndex == s.length() - 1) {
					test += s[startIndex];
					stack.push(to_string(stod(stack.sub) * stod(test)));
					look += (stack.sub + " * " + test);
					break;
				}
				test += s[startIndex];
			}
			if (startIndex == s.length() - 1) break; // ���� ������ ��� break
		}
		// ������
		else if (s[startIndex] == '/') {

			string test = "";
			while (true) { // ���� ���ڸ� �Ϻ��� ã�� �� ���� ����
				startIndex++;

				// ��Ģ������ ���� ��
				if ((s[startIndex] == '+') || (s[startIndex] == '-') || (s[startIndex] == '*') || (s[startIndex] == '/')) { // ��Ģ������ ���� �� ����
					if (test == "") error(); // �������� ��Ģ���� �߻��� �߸��� ������ �ν�
					stack.sub = to_string(stod(stack.sub) / stod(test));
					startIndex--; // ��Ģ������ �߰������Ƿ� �߰� ���� ��ĭ ������ �̵�
					break;
				}
				// �ִ� index ���̸鼭 ������ ��
				else if (startIndex == s.length() - 1) {
					test += s[startIndex];
					stack.push(to_string(stod(stack.sub) / stod(test)));
					look += (stack.sub + " / " + test);
					break;
				}
				test += s[startIndex];
			}
			if (startIndex == s.length() - 1) break; // ���� ������ ��� break
		}
		// ���ϱ�
		else if (s[startIndex] == '+') {
			look += (stack.sub + " + ");
			setup(&stack);
			stack.push("+");
		}
		// ����
		else if (s[startIndex] == '-') {
			look += (stack.sub + " - ");
			setup(&stack);
			stack.push("-");
		}
		// ���ڳ� �Ҽ����� ���
		else {
			stack.sub += s[startIndex]; // string ���Ŀ� char �� �����ϴ� ������ ���� ���
			if (startIndex == s.length() - 1) { // ���� ������ ���ڿ��� ���ڶ�� �ش� ���� ����
				look += stack.sub;
				setup(&stack);
				break;
			}
		}
		startIndex++; // �������� �߰�
	}
	cout << "\n���� : " << look << "\n\n";
	if (stack.size() == 1) { // ���� ��Ģ������ �ϳ��� ���� ����/�Ǽ� ���� ���� ���
		cout << "result : " << stod(stack.pop());
		return 0;
	}
	stack.sub = "";
	// �տ����� �����ϰ� �ڿ����� ��� ����������, stack �� Ȱ���ϴ� ����̹Ƿ� �ڿ������� ���
	while (true) {
		string show = stack.pop();
		// + �� ���
		if (show == "+") result += stod(stack.sub);
		// - �� ���
		else if (show == "-") {
			result -= stod(stack.sub);
			if (stack.arr_last == -1) break;
		}
		// ������ ���
		else {
			if (stack.arr_last == -1) {
				result += stod(show);
				break;
			}
			stack.sub = show;
		}
	}

	cout << "result : " << result << "\n";
	return 0;
}