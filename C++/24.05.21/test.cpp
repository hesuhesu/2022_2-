#include <iostream>

using namespace std;

class Board {
public:
	static string* notices;
	static int index;
	static void add(string str) {notices[index++] = str;}
	static void print() {
		cout << "************** 게시판입니다 **************" << endl;
		for (int i = 0; i < index; i++) {
			cout << i << " : " << notices[i] << "\n";
		}
	}
};

string* Board::notices = new string[100];
int Board::index = 0;

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
