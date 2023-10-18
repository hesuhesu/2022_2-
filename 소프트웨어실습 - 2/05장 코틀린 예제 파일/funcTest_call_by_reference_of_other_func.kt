package com.cookandroid.ch05_2023_kotlin_lambda_highorder_function

fun summation(x: Int, y: Int) = x + y

val summation2 = {x: Int, y: Int -> x + y}

fun funcParam(a: Int, b: Int, c: (Int, Int) -> Int): Int {
    return c(a, b)
}

fun main(){
    //println(funcParam(3, 2, summation)) //summation이 람다식이 아니라서 오류
    println(funcParam(3, 2, ::summation)) //호출 성공
    println(funcParam(4, 7, summation2)) // summation을 람다로 변형한 summation2를 호출하면 성공
}

