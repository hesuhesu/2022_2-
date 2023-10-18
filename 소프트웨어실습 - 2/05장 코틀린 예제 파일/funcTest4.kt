package com.cookandroid.ch05_2023_kotlin_lambda_highorder_function

fun hofFun(arg: (Int) -> Boolean):()->String {
    val result = if(arg(10)) {
        "valid"
    } else {
        "invalid"
    }
    return {"hofFun result : $result"}
}

fun main(){
    val result = hofFun({no -> no > 0})
    println(result())
    print(result)
}