package com.cookandroid.ch05_2023_kotlin_lambda_highorder_function

fun calculator(a: Int, b: Int, operation: (Int, Int)->Int) = operation(a, b) // 아래 코드를 간략화 한 것
//fun calculator(a: Int, b: Int, operation: (Int, Int)->Int):Int {return operation(a, b)}

// {     val result = operation(a, b) }

fun main() {
    val sum = {x: Int, y:Int -> x+y}
    println(calculator(1, 2, sum))
    println(calculator(4, 3, { a: Int, b: Int -> a-b }))
}


