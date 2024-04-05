#include <iostream>

using namespace std;

void swapArray(int* p, int* q, int size);
void printArray(int* p, int size);

int main()
{
    ios_base::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);

    int a[] = { 1,2,3,4,5 };
    int b[] = { 9,8,7,6,5 };

    cout << "배열 a = ";
    printArray(a, 5);
    cout << "배열 b = ";
    printArray(b, 5);

    swapArray(a, b, 5);

    cout << "배열 a = ";
    printArray(a, 5);
    cout << "배열 b = ";
    printArray(b, 5);

    return 0;

}
void swapArray(int* p, int* q, int size) {
    cout << "\nswapArray() 실행...\n";
    for (int i = 0; i < size; i++) {
        int temp = *(p + i);
        *(p + i) = *(q + i);
        *(q + i) = temp;
    }
}
void printArray(int* p, int size) {
    for (int i = 0; i < size; i++) {
        cout << *(p + i) << " ";
    }
    cout << "\n";
}