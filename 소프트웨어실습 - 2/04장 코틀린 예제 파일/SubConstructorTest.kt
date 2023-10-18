package com.cookandroid.ch04_2023_kotlin_class_basic

/*
1. 보조 생성자는 클래스 본문에 constructor 키워드로 본문까지 작성하는 것
2. 보조 생성자는 클래스에 여러 개 존재할 수 있음
3. 보조 생성자는 주 생성자를 반드시 상속해야함
4. 보조 생성자는 인자 선언과 동시에 프로퍼티 할당이 안됨 (var, val을 쓸 수 없다는 뜻)
5. 주 생성자가 없는 경우 보조 생성자는 자유롭게 작성 가능 (묵시적 주 생성자가 없음)
*/

class User10 {
    constructor(name: String){ //보조 생성자 형태
        println("constructor(name: String) call...")
    }
    constructor(name: String, count:Int){
        println("constructor(name: String, count: Int) call...")
    }
}

class User11 constructor(name: String) {
    constructor(name: String, count: Int): this(name) { // this는 User 자체를 의미, : 이후 코드가 없으면 에러 발생(PPT 10)
        println("constructor(name: String, count: Int) call...")
    }
}

class User12 constructor(name: String) {
    constructor(name: String, count: Int): this(name) { // this는 User 자체를 의미, : 이후 코드가 없으면 에러 발생(PPT 10)
        println("constructor(name: String, count: Int) call...")
    }
    constructor(name: String, count: Int, email:String): this(name, count) { // 인자 2개인 보조 생성자를 호출하도록 구현
        println("constructor(name: String, count: Int, email:String) call...")
    }
    /* 주 생성자를 부르도록 작성도 가능함, 참고할 것
    constructor(name: String, count: Int, email:String): this(name) { // this는 User 자체를 의미,
        println("constructor(name: String, count: Int) call...")
    }
    */


}


fun main(){
    val user1 = User10("YangMin")
    val user2 = User10("YangMin", 10)

    val user3 = User11("YangMin", 10)

    val user4 = User12("YangMin", 10, "manson23@nate.com")
}