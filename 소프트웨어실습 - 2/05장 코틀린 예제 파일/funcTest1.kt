package com.cookandroid.ch05_2023_kotlin_lambda_highorder_function


fun sum(no1: Int, no2: Int): Int {
    println("normal Func")
    return no1 + no2
}

val sum = {no1: Int, no2:Int ->
    println("Lambda: ")
    no1 + no2
}

val some: (Int, Int) -> Int = {no1:Int, no2: Int -> no1 + no2} //함수 타입과 본체를 모두 작성한 예시

fun main(){
    sum(5, 6)
    println(some(4, 3))
}

