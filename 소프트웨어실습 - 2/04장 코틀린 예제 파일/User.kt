package com.cookandroid.ch04_2023_kotlin_class_basic

class User {
    var name = "yang"
    constructor(name: String) { //생성자는 construct 키워드 필요, 이 예제의 생성자는 보조 생성자임
        this.name = name
    }
    fun someFun() {
        println("name : $name")
    }
    class SomeClass {} // 중첩 클래스 선언 가능
}

fun main() {
    val user = User("Lee")
    user.someFun()
}