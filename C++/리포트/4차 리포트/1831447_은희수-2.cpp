#define _CRT_SECURE_NO_WARNINGS
#include<iostream>

using namespace std;

class Book {
    char* title;
    int price;
public:
    Book(const char* title, int price); // const �־����.
    Book(const Book& b); // const �־����.
    ~Book();
    void set(const char* title, int price); // const �־����.
    void show() { cout << title << ' ' << price << "��" << endl; }
};

Book::Book(const char* title, int price) {
    this->title = new char[strlen(title) + 1]; // ���� �Ҵ�
    strcpy(this->title, title);
    this->price = price; // �⺻ int
}

Book::Book(const Book& b) {
    this->title = new char[strlen(b.title) + 1]; // ���� �Ҵ�
    strcpy(this->title, b.title);
    this->price = b.price; // �⺻ int
}

Book::~Book() { delete[] title; } // �Ҹ���. �޸� ��ȯ

void Book::set(const char* title, int price) {
    if (this->title) { delete[] this->title; } // if �Ҵ� �޸� ���� �� �޸� ��ȯ
    this->title = new char[strlen(title) + 1];
    strcpy(this->title, title);
    this->price = price; // �⺻ int
}

int main() {
    Book cpp("��ǰC++", 10000);
    Book java = cpp;
    java.set("��ǰ�ڹ�", 12000);
    cpp.show();
    java.show();
    return 0;
}