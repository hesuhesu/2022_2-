#include <iostream>
#define _USE_MATH_DEFINES
#include <math.h>

using namespace std;

double circle(double num);

int main()
{
    ios_base::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);

    double r;
    cout << "반지름 길이 r 을 입력하시오 : ";
    cin >> r;

    cout << "원의 넓이는 : " << circle(r);
    return 0;

}
double circle(double num) {
    num *= (num * M_PI);
    return num;
}