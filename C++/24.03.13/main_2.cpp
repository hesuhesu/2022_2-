#include <iostream>
#include <cstring> // c++ 표준방식
#include <string>

using namespace std;

int main()
{
	cout << "주소를 입력하세요 : ";

	char address[100];
	cin.getline(address, 100, 't'); // 키보드로부터 주소 읽기 3번째 인자의 문자가 나온다면 입력받기를 종료한다.

	cout << "주소는 " << address << "입니다\n"; // 주소 출력

	string song("Falling in love with you"); // 문자열 song
	string elvis("Elvis Presley"); // 문자열 elvis
	string singer; // 문자열 singer

	cout << song + "를 부른 가수는"; // + 로 문자열 연결
	cout << "(힌트 : 첫글자는 " << elvis[0] << ")?";  // [] 연산자 사용

	getline(cin, singer); // 문자열 입력
	if (singer == elvis) cout << "맞았습니다."; // 문자열 비교
	else cout << "틀렸습니다. " + elvis + "입니다." << endl; // +로 문자열 연결

    return 0;
}
