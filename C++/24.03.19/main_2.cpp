#include <iostream>

using namespace std;

class Circle {
    double radius;
public:
    Circle(double line) {
        radius = line;
        cout << "길이가 " << line << " 인 원이 생성되었습니다.\n";
    };
    double getArea() {
        return 3.14 * radius * radius;
    }
};

class Car {
    double speed = -1;
    string model = "null";
    string name;
public:
    Car(string nickname);
    void setSpeed(double speeds);
    void setModel(string models);
    double getSpeed();
    string getModel();
    void getTotal() {
        cout << "이름은 : " << name << ", 스피드는 : " << speed << ", 모델은 : " << model << " 이다.\n";
    }
};
Car::Car(string nickname) {
    name = nickname;
    cout << nickname << " 이름의 차가 생성되었습니다!\n";
}
void Car::setSpeed(double speeds) {
    speed = speeds;
}
void Car::setModel(string models) {
    model = models;
}
double Car::getSpeed() {
    return speed;
}
string Car::getModel() {
    return model;
}

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
