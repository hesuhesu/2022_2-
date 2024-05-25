#include <iostream>
#include <string>

using namespace std;

int main() {


	// ** 1. string append **
	cout << "--------------- 1. string append ---------------\n";

	string str = "I love "; // str�� 'I', ' ', 'l', 'o', 'v', 'e', ' '�� 7�� ���ڷ� ����
	str.append("C++."); // str�� "I love C++."�� �ȴ�. 11���� ����

	cout << str << "\n";
	

	// ** 2. copy string **
	cout << "--------------- 2. copy string ---------------\n";

	string str2; // �� ���ڿ��� ���� ��Ʈ�� ��ü
	string address("����� ���ϱ� �Ｑ�� 382"); // ���ڿ� ���ͷ��� �ʱ�ȭ
	string copyAddress(address); // address�� ������ copyAddress ����

	char text[] = { 'L', 'o', 'v', 'e', ' ', 'C', '+', '+', '\0' }; // C-��Ʈ��(char [] �迭)���κ��� ��Ʈ�� ��ü ����
	string title(text); // ��Love C++" ���ڿ��� ���� title ����

	cout << address << endl; // "����� ���ϱ� �Ｑ�� 389" ���
	cout << title << endl; // ��Love C++" ���


	// ** 3. stoi() ** 
	cout << "--------------- 3. stoi() ---------------\n";

	string s = "123";
	cout << "string s : " << s << "\n";
	int n = stoi(s); // n�� ���� 123. ���־� C++ 2010 �̻� ����
	cout << "string s -> int n : " << n << "\n";


	// ** 4. string object **
	cout << "--------------- 4. string object ---------------\n";

	string* p = new string("C++"); // ��Ʈ�� ��ü ���� ����

	cout << *p; // "C++" ���
	p->append(" Great!!"); // p�� ����Ű�� ��Ʈ���� "C++ Great!!"�� ��
	cout << *p; // "C++ Great!!" ���

	delete p; // ��Ʈ�� ��ü ��ȯ

	return 0;
}