#include <iostream>
#include <string>

using namespace std;

class Stack { // stack 구현
public:
	string arr[10000];
	string sub = ""; // 1의 자리가 아닐 가능성을 염두. N자리 수 전부 계산 가능
	int arr_last = -1;
	void push(string data) { arr[++arr_last] = data; }
	bool empty() { return (arr_last < 0); }
	string pop() {
		if (empty()) return "nothing";
		return arr[arr_last--];
	}
	int size() { return arr_last + 1; }
};

inline void setup(Stack* stack) { // 반복문 줄이기용
	stack->push(stack->sub);
	stack->sub = "";
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
	int startIndex = 0; // 문자열 내에 검색할 시작 인덱스
	double result = 0; // 최종 결과
	string look = "";
	Stack stack;

	s.erase(remove(s.begin(), s.end(), ' '), s.end()); // 공백 완전 제거
	while (true) { // 아예 맨 뒤의 연산이 있을 경우를 제거
		if ((s[s.length() - 1] == '+') || (s[s.length() - 1] == '-') || (s[s.length() - 1] == '*') || (s[s.length() - 1] == '/')) s.erase(prev(s.end()));
		else break;
	}
	while (true) { // 1차 문자열 내용 계산 => *, / 를 먼저 연산해준 후 stack 에 +, - 를 적립 후 계산하는 방식

		// 곱하기
		if (s[startIndex] == '*') {

			string test = "";
			while (true) { // 다음 숫자를 완벽히 찾을 때 까지 진행
				startIndex++;

				// 사칙연산이 나올 때
				if ((s[startIndex] == '+') || (s[startIndex] == '-') || (s[startIndex] == '*') || (s[startIndex] == '/')) { // 사칙연산이 나올 때 종료
					if (test == "") error(); // 연속으로 사칙연산 발생시 잘못된 식으로 인식
					stack.sub = to_string(stod(stack.sub) * stod(test));
					startIndex--; // 사칙연산을 발견했으므로 발견 전인 한칸 앞으로 이동
					break;
				}
				// 최대 index 값이면서 숫자일 때
				else if (startIndex == s.length() - 1) {
					test += s[startIndex];
					stack.push(to_string(stod(stack.sub) * stod(test)));
					look += (stack.sub + " * " + test);
					break;
				}
				test += s[startIndex];
			}
			if (startIndex == s.length() - 1) break; // 끝에 도달한 경우 break
		}
		// 나누기
		else if (s[startIndex] == '/') {

			string test = "";
			while (true) { // 다음 숫자를 완벽히 찾을 때 까지 진행
				startIndex++;

				// 사칙연산이 나올 때
				if ((s[startIndex] == '+') || (s[startIndex] == '-') || (s[startIndex] == '*') || (s[startIndex] == '/')) { // 사칙연산이 나올 때 종료
					if (test == "") error(); // 연속으로 사칙연산 발생시 잘못된 식으로 인식
					stack.sub = to_string(stod(stack.sub) / stod(test));
					startIndex--; // 사칙연산을 발견했으므로 발견 전인 한칸 앞으로 이동
					break;
				}
				// 최대 index 값이면서 숫자일 때
				else if (startIndex == s.length() - 1) {
					test += s[startIndex];
					stack.push(to_string(stod(stack.sub) / stod(test)));
					look += (stack.sub + " / " + test);
					break;
				}
				test += s[startIndex];
			}
			if (startIndex == s.length() - 1) break; // 끝에 도달한 경우 break
		}
		// 더하기
		else if (s[startIndex] == '+') {
			look += (stack.sub + " + ");
			setup(&stack);
			stack.push("+");
		}
		// 빼기
		else if (s[startIndex] == '-') {
			look += (stack.sub + " - ");
			setup(&stack);
			stack.push("-");
		}
		// 숫자나 소수점일 경우
		else {
			stack.sub += s[startIndex]; // string 형식에 char 를 적립하는 식으로 숫자 계산
			if (startIndex == s.length() - 1) { // 만약 마지막 문자열이 숫자라면 해당 과정 시행
				look += stack.sub;
				setup(&stack);
				break;
			}
		}
		startIndex++; // 지속적인 추가
	}
	cout << "\n계산식 : " << look << "\n\n";
	if (stack.size() == 1) { // 만약 사칙연산이 하나도 없이 정수/실수 형만 있을 경우
		cout << "result : " << stod(stack.pop());
		return 0;
	}
	stack.sub = "";
	// 앞에서도 가능하고 뒤에서도 계산 가능하지만, stack 을 활용하는 방법이므로 뒤에서부터 계산
	while (true) {
		string show = stack.pop();
		// + 의 경우
		if (show == "+") result += stod(stack.sub);
		// - 의 경우
		else if (show == "-") {
			result -= stod(stack.sub);
			if (stack.arr_last == -1) break;
		}
		// 숫자의 경우
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