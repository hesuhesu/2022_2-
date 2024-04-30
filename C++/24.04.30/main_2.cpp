#include <iostream>
#include <string>

using namespace std;

int main() {

    string str; // 빈 문자열을 가진 스트링 객체
    string address("서울시 성북구 삼선동 389"); // 문자열 리터럴로 초기화
    string copyAddress(address); // address를 복사한 copyAddress 생성

    char text[] = { 'L', 'o', 'v', 'e', ' ', 'C', '+', '+', '\0' };
    string title(text); // “Love C++" 문자열을 가진 title 생성

    cout << address << endl; // "서울시 성북구 삼선동 389" 출력
    cout << title << endl; // “Love C++" 출력

    string name;
    cin >> name; // 공백이 입력되면 하나의 문자열로 입력

    string s1 = "123";
    int n1 = stoi(s1); // n은 정수 123. 비주얼 C++ 2010 이상 버전

    string s2 = "123";
    int n2 = atoi(s2.c_str()); // n은 정수 123. 비주얼 C++ 2008 이하

    cout << "n1 + n2 = " << n1 + n2;

    return 0;
}
