package com.cookandroid.ch04_2023_kotlin_class_basic

class User6 (name: String, count: Int) { //constructor 키워드 생략, User7과 같은 코드
    init{ // 주 생성자의 본문
        println("i am init.......")
    }
}

class User7 constructor(name: String, count: Int) { //constructor 키워드를 작성
    init{ // 주 생성자의 본문
        println("i am init.......")
    }
}

class User8(name: String, count: Int){
    init{
        println("name: $name, count: $count")
    }
    fun someFun(){ // name과 count가 생성자의 지역 변수이므로 다른 함수에서 사용 불가능
        //println("name: $name, count: $count")
    }
}

class User9(val name: String, val count: Int){ //주 생성자의 매개변수를 val 키워드를 통해 클래스의 멤버 변수로 사용 (var 키워드도 가능)
    fun someFun(){
        println("name: $name, count: $count")
    }
    /*
    fun someFun(val name2: String, var count: Int) { //일반 함수는 안됨, 위의 예제는 주생성자 한정임

    }
    */
}

fun main() {
    val user = User6("YangMin", 10)

    val user2 = User9("DongA", 10)
    user2.someFun()
}