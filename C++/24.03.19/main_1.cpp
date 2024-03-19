#include <iostream>

using namespace std;

class Circle {
    double radius;
public :
    Circle(double line) {
        radius = line;
    };
    double getArea() {
        return 3.14 * radius * radius;
    }
};

int main()
{
    double n;
    cout << "생성하려는 원의 반지름을 기입하시오 : ";
    cin >> n;
    Circle circle(n);
    cout << "원의 넓이 : " << circle.getArea();

    return 0;
}
