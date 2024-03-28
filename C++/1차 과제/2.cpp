#include <iostream>

// ios_base::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);

using namespace std;

void sumAverage();

int main()
{
    ios_base::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);

    sumAverage();

    return 0;
}

void sumAverage() {
    int sum = 0;
    int count = 0;

    while (1) {
        int a;
        cout << "정수를 입력하시오(100이상이 되면 자동 계산됩니다) : ";
        cin >> a;
        count++;
        sum += a;
        if (a >= 100) {
            break;
        }
    }
    cout << "평균 : " << float(sum) / float(count) << " / 합 : " << sum << "\n";
}