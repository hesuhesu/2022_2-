#include <iostream>

// ios_base::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);

using namespace std;

int reverseArray(int n[]);

int main()
{
    ios_base::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);

    int n[100];
    for (int i = reverseArray(n) - 1; i >= 0; i--) {
        if (i == 0) {
            cout << n[i] << "\n";
            continue;
        }
        cout << n[i] << ", ";
    }
    return 0;
}

int reverseArray(int n[]) {
    int num;
    int check = 0;
    cout << "�迭 ���� ����Ͻÿ�(0�� �Է��ϸ� �ڵ� ����˴ϴ�)\n";
    for (int i = 0; i < 100; i++) {
        cin >> num;
        if (num == 0) {
            break;
        }
        n[i] = num;
        check++;
    }
    return check;
}