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
        cout << "������ �Է��Ͻÿ�(100�̻��� �Ǹ� �ڵ� ���˴ϴ�) : ";
        cin >> a;
        count++;
        sum += a;
        if (a >= 100) {
            break;
        }
    }
    cout << "��� : " << float(sum) / float(count) << " / �� : " << sum << "\n";
}