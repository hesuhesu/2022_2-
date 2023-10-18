package com.cookandroid.ch04_2023_kotlin_class_basic

import android.icu.text.CaseMap

open class UpperClass {
    open var uData = 10
    open fun someFun(){
        println("i am Upper class Function: $uData")
    }
}

class LowerClass : UpperClass() {
    override var uData = 20
    override fun someFun() {
        println("i am Lower class Function: $uData")
    }

}

fun main(){
    val obj = LowerClass()
    obj.uData = 20
    obj.someFun()

    val obj2 = UpperClass()
    obj2.someFun()
}