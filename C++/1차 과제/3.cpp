#include <iostream>

// ios_base::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);

using namespace std;

void timesTable(int n1, int n2);

int main()
{
    ios_base::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);

    int a, b;
    cout << "구구단으로 사용할 숫자를 각각 입력해주세요 : ";
    cin >> a >> b;

    if (a > b) { // b < a 경우 a < b 순으로 변경함.
        int temp = a;
        a = b;
        b = temp;
    }
    timesTable(a, b);

    return 0;
}

void timesTable(int n1, int n2) {
    for (int i = n1; i <= n2; i++) {
        for (int j = 1; j <= 9; j++) {
            cout << i << " x " << j << " = " << i * j << "\n";
        }
        cout << "-------------------------------------------\n";
    }
}