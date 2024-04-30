#include <iostream>
#include <string>

using namespace std;

int main() {

    string* p = new string("C++"); // 스트링 객체 동적 생성

    cout << *p << "\n"; // "C++" 출력
    p->append(" Great!!"); // p가 가리키는 스트링이 "C++ Great!!"이 됨
    cout << *p; // "C++ Great!!" 출력

    delete p; // 스트링 객체 반환

    return 0;
}
