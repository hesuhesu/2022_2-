#include <iostream>

using namespace std;

__int64 factorial(int num);

int main()
{
    ios_base::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);

    int n;
    cout << "정수 n 을 입력하시오(26부터 범위 초과) : ";
    cin >> n;

    cout << n << " factorial result : " << factorial(n); // 26 부터는 범위 초과
    return 0;

}
__int64 factorial(int num) {
    if (num <= 1) return 1;
    return num * factorial(num - 1);
}