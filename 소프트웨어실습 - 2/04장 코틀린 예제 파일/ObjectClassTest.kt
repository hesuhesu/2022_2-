package com.cookandroid.ch04_2023_kotlin_class_basic

val obj = object {
    var data = 10
    fun some() {
        println("data : $data")
    }
}

open class SuperClass{
    open var data = 20
    open fun some(){
        println("I am super some() : $data")
    }
}

val obj2 = object: SuperClass() { //obj가 SuperClass 타입이 됨
    override var data = 10
    override fun some() {
        println("I am object some() : $data")
    }
}

fun main(){
    //obj.data = 20
    //obj.some()
    obj2.data = 30
    obj2.some()
}