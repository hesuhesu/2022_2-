#include <iostream>
using namespace std;

int maximum(int a[], int size);
int minimum(int a[], int size);

int main() {
	
	int array[10] = { 9,5,11,4,1,3,7,12,2,8 };

	cout << "최대값은? : " << maximum(array, 10) << "\n";
	cout << "최소값은? : " << minimum(array, 10) << "\n";
	
	return 0;
}
int maximum(int a[], int size) {
	int large = a[0];
	for (int i = 0; i < size; i++) {
		if (a[i] > large) large = a[i];
	}
	return large;
}
int minimum(int a[], int size) {
	int small = a[0];
	for (int i = 0; i < size; i++) {
		if (a[i] < small) small = a[i];
	}
	return small;
}
