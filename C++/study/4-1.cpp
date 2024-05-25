#include <iostream>
#include <string>

using namespace std;

int main() {


	// ** 1. string append **
	cout << "--------------- 1. string append ---------------\n";

	string str = "I love "; // str은 'I', ' ', 'l', 'o', 'v', 'e', ' '의 7개 문자로 구성
	str.append("C++."); // str은 "I love C++."이 된다. 11개의 문자

	cout << str << "\n";
	

	// ** 2. copy string **
	cout << "--------------- 2. copy string ---------------\n";

	string str2; // 빈 문자열을 가진 스트링 객체
	string address("서울시 성북구 삼선동 382"); // 문자열 리터럴로 초기화
	string copyAddress(address); // address를 복사한 copyAddress 생성

	char text[] = { 'L', 'o', 'v', 'e', ' ', 'C', '+', '+', '\0' }; // C-스트링(char [] 배열)으로부터 스트링 객체 생성
	string title(text); // “Love C++" 문자열을 가진 title 생성

	cout << address << endl; // "서울시 성북구 삼선동 389" 출력
	cout << title << endl; // “Love C++" 출력


	// ** 3. stoi() ** 
	cout << "--------------- 3. stoi() ---------------\n";

	string s = "123";
	cout << "string s : " << s << "\n";
	int n = stoi(s); // n은 정수 123. 비주얼 C++ 2010 이상 버전
	cout << "string s -> int n : " << n << "\n";


	// ** 4. string object **
	cout << "--------------- 4. string object ---------------\n";

	string* p = new string("C++"); // 스트링 객체 동적 생성

	cout << *p; // "C++" 출력
	p->append(" Great!!"); // p가 가리키는 스트링이 "C++ Great!!"이 됨
	cout << *p; // "C++ Great!!" 출력

	delete p; // 스트링 객체 반환

	return 0;
}