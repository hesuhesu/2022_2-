#include <iostream>
#include "test_2.cpp"
#include "test.h"
using namespace std;

int main()
{
    Rectangle rect;
    rect.width = 3;
    rect.height = 5;
    cout << "사각형 면적은 : " << rect.getArea() << "\n";

    return 0;
}