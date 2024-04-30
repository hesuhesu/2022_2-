#include <iostream>

using namespace std;

class Sample {
   int a;
public:
	void setA(Sample* this, int x) {
		this->a = x;
	}
};

int main() {
    return 0;
}
