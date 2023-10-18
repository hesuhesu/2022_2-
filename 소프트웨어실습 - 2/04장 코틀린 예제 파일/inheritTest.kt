package com.cookandroid.ch04_2023_kotlin_class_basic

import android.telephony.gsm.SmsMessage

open class Super(name: String) {
    init {
        println("Super Class: $name ")
    }
}

class Sub(name: String): Super(name){ // 하위 클래스에 주 생성자가 있으면 여기서 상위 클래스 생성자 호출(위치)
    init{
        println("Sub Class : $name")
    }
}

//-------------------------------------------------------------------------------------------------

open class Super1(name:String){
    init {
        println("Super Class : $name")
    }
}

class Sub1: Super1 { // 보조 생성자만 있는 경우
    constructor(name:String): super(name){  //보조 생성자 위치에서 상위 클래스의 생성자 호출(위치)
                                            // 상위 클래스를 직접 부르는 것이 아니라 super 키워드 이용
        println("Sub Class : $name")
    }
}

//------------------------------------------------------------------------------------------------

open class Super2 {
    init {
        println("Super Class")
    }
}

class Sub2 : Super2{ //두 클래스에 모두 명시적인 생성자가 없는 경우 상위 클래스의 매개 변수 없는 생성자 호출
    constructor(){ } // : super(){} 를 사용해도 됨, 상위 클래스의 매개 변수 없는 주 생성자 호출
    init {
        println("Sub Class")
    }
}


fun main(){
    var a = Sub("Yang")
    var b = Sub1("Yang2")
    var c = Sub2() // 매개 변수 없음
}


