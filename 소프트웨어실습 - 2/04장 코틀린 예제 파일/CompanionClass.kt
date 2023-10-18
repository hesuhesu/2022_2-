package com.cookandroid.ch04_2023_kotlin_class_basic

class MyClass {
    companion object{
        var data = 10
        fun some() {
            println(data)
        }
    }
}

class MyClass2{
    var data = 10
    fun some(){
        println(data)
    }
}

fun main() {
    MyClass.data = 20
    MyClass.some()

    val obj = MyClass2()
    obj.data = 20 //가능
    //MyClass2.some() //오류
}

