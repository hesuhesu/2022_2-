#include <iostream>
#include "main_3.h"

using namespace std;

int main()
{
    double n;
    cout << "�����Ϸ��� ���� �������� �����Ͻÿ� : ";
    cin >> n;
    Circle circle(n);
    cout << "���� ���� : " << circle.getArea() << "\n";

    cout << "___________________________________________________________________\n";

    string str;
    cout << "�����Ϸ��� ���� �̸��� �����Ͻÿ� : ";
    cin >> str;
    Car car(str);
    cout << "�ش� ������ �ӵ��� �����Ͻÿ� : ";
    cin >> n;
    car.setSpeed(n);
    cout << "�ش� ������ ���� �����Ͻÿ� : ";
    cin >> str;
    car.setModel(str);

    car.getTotal();

    return 0;
}