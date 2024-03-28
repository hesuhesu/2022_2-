#include <iostream>

using namespace std;

__int64 factorial(int num);

int main()
{
    ios_base::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);

    int n;
    cout << "���� n �� �Է��Ͻÿ�(26���� ���� �ʰ�) : ";
    cin >> n;

    cout << n << " factorial result : " << factorial(n); // 26 ���ʹ� ���� �ʰ�
    return 0;

}
__int64 factorial(int num) {
    if (num <= 1) return 1;
    return num * factorial(num - 1);
}