package com.cookandroid.ch05_2023_kotlin_lambda_highorder_function

/*
fun main() {
    val some = { no: Int -> println(no)}
    some(10)
}
*/

fun main() {
    val some: (Int) -> Unit = {println(it)}
    some(10)
}