package com.cookandroid.ch05_2023_kotlin_lambda_highorder_function

// 매개변수 타입 유추가 가능하므로 타입 선언을 생략한 형태
typealias MyFunType = (Int, Int) -> Boolean
val someFun: MyFunType = {no1, no2 -> no1 > no2}


//매개변수 타입까지 모두 기재한 형태
typealias MyFunTypeA = (Int, Int) -> Boolean
val someFunA: MyFunTypeA = {no1:Int, no2:Int -> no1 > no2}


//함수 타입을 생략한 형태: 함수의 본체로부터 타입을 유추할 수 있음
val someFunB = {no1:Int, no2:Int -> no1 > no2 }

fun main(){
    println(someFun(5, 6))
    println(someFunA(5, 6))
    println(someFunB(5, 6))
}