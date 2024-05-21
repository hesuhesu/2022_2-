#include <iostream>
#include <string>

using namespace std;

class Board {
public:
	static string* notices;
	static int index;
	
	Board() {
		notices = new string[100];
		index = 0;
		notices[index] = "********************** 게시판 입니다 **********************";
	}
	static void add(string str) {
		++index;
		notices[index] = (index - 1) + " : " + str;
	}
	static void print() {
		for (int i = 0; i < index; i++) {
			 cout <<notices[i] << "\n";
		}
	}
	~Board() { delete[] notices; }
};

int main() {
	
	Board::add("중간고사는 감독 없는 자율 시험입니다.");
	Board::add("코딩 라운지 많이 이용해 주세요");
	Board::print();
	Board::add("코딩 라운지 많이 이용해 주세요");
	Board::print();
	Board::add("코딩 라운지 많이 이용해 주세요");
	Board::print();
	return 0;
}
