#include <iostream>

// ios_base::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);

using namespace std;

void even(int a);
void odd(int a);

int main()
{
    ios_base::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);

    int n;
    cout << "정수를 입력하시오 : ";
    cin >> n;

    even(n);
    odd(n);

    return 0;
}

void even(int a) {
    int sum = 0;
    for (int i = 0; i <= a; i++) {
        if (i % 2 == 0) {
            sum += i;
        }
    }
    cout << "짝수의 합 : " << sum << "\n";
}
void odd(int a) {
    int sum = 0;
    for (int i = 0; i <= a; i++) {
        if (i % 2 == 1) {
            sum += i;
        }
    }
    cout << "홀수의 합 : " << sum << "\n";
}