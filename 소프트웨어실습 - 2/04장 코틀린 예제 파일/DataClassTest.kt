package com.cookandroid.ch04_2023_kotlin_class_basic

class NonDataClass(val name: String, val email: String, val age: Int)

data class DataClass(val name: String, val email: String, val age: Int)

data class DataClass2(val name: String, val email: String, val age: Int){
    lateinit var address: String
    constructor(name: String, email: String, age:Int, address: String):this(name, email, age){
        this.address = address
    }
}

fun main() {
    val non1 = NonDataClass("yang", "manson23@nate.com", 10)
    val non2 = NonDataClass("yang", "manson23@nate.com", 10)

    val data1 = DataClass("yang", "manson23@nate.com", 10)
    val data2 = DataClass("yang", "manson23@nate.com", 10)

    println("non data class equals : ${non1.equals(non2)}")
    println("data class equals : ${data1.equals(data2)}")

    val obj1 = DataClass2("yang", "manson23@nate.com", 10, "Seoul")
    val obj2 = DataClass2("yang", "manson23@nate.com", 10, "Busan")
    println("obj1.equals(obj2) : ${obj1.equals(obj2)}")

    println("non data class toString : ${non1.toString()}")
    println("data class toString : ${data1.toString()}")
}