#include <iostream>
#include "main_3.h"

using namespace std;

int main()
{
    double n;
    cout << "생성하려는 원의 반지름을 기입하시오 : ";
    cin >> n;
    Circle circle(n);
    cout << "원의 넓이 : " << circle.getArea() << "\n";

    cout << "___________________________________________________________________\n";

    string str;
    cout << "생성하려는 차의 이름을 기입하시오 : ";
    cin >> str;
    Car car(str);
    cout << "해당 차종의 속도를 기입하시오 : ";
    cin >> n;
    car.setSpeed(n);
    cout << "해당 차종의 모델을 기입하시오 : ";
    cin >> str;
    car.setModel(str);

    car.getTotal();

    return 0;
}