package com.cookandroid.ch05_2023_kotlin_lambda_highorder_function

fun main(){
    var data: String? = null
    val length = if (data == null) {
        0
    } else {
        data.length  // null check 없이 사용하면 nullpointException 발생
    }
    println("data length: $length")
}