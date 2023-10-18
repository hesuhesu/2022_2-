package com.cookandroid.ch05_2023_kotlin_lambda_highorder_function

/* call by name
fun main() {
    val result2 = callByName(otherlambda)
    println(result2)
}

fun callByName(b:() -> Boolean): Boolean { //람다시 함수 자료형으로 선언된 매개변수
    println("callByValue function")
    return b() //함수 자체를 리턴함
}

val otherlambda: () -> Boolean = { //람다 표현식이 두 줄
    println("otherlambda function")
    true  // 실제 반환되는 부분, 마지막 표현식 문장의 결과가 반환됨
}
*/
