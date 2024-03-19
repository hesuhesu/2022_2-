#pragma once
#include <iostream>

using namespace std;

class Circle {
    double radius;
public:
    Circle(double line) {
        radius = line;
        cout << "���̰� " << line << " �� ���� �����Ǿ����ϴ�.\n";
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
        cout << "�̸��� : " << name << ", ���ǵ�� : " << speed << ", ���� : " << model << " �̴�.\n";
    }
};
Car::Car(string nickname) {
    name = nickname;
    cout << nickname << " �̸��� ���� �����Ǿ����ϴ�!\n";
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