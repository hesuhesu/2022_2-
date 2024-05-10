#define _CRT_SECURE_NO_WARNINGS
#include<iostream>

using namespace std;

class Book {
    char* title;
    int price;
public:
    Book(const char* title, int price); // const 있어야함.
    Book(const Book& b); // const 있어야함.
    ~Book();
    void set(const char* title, int price); // const 있어야함.
    void show() { cout << title << ' ' << price << "원" << endl; }
};

Book::Book(const char* title, int price) {
    this->title = new char[strlen(title) + 1]; // 동적 할당
    strcpy(this->title, title);
    this->price = price; // 기본 int
}

Book::Book(const Book& b) {
    this->title = new char[strlen(b.title) + 1]; // 동적 할당
    strcpy(this->title, b.title);
    this->price = b.price; // 기본 int
}

Book::~Book() { delete[] title; } // 소멸자. 메모리 반환

void Book::set(const char* title, int price) {
    if (this->title) { delete[] this->title; } // if 할당 메모리 존재 시 메모리 반환
    this->title = new char[strlen(title) + 1];
    strcpy(this->title, title);
    this->price = price; // 기본 int
}

int main() {
    Book cpp("명품C++", 10000);
    Book java = cpp;
    java.set("명품자바", 12000);
    cpp.show();
    java.show();
    return 0;
}