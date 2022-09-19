#include <Servo.h> 

// data sheet
// upload는 ctrl + u

const byte number[10] = {
  B00111111 // 0
  B00000110 // 1
  B01011011 // 2
  B01001111 // 3
  B01100110 // 4
  B01101101 // 5
  B01111101 // 6
  B00000111 // 7
  B01111111 // 8
  B01101111 // 9
}

void finDisplay(int displayValue){
  // bitValue 변수를 선언한다.
  boolean bitValue;

  for(int i = 2; i <= 9; ++i){
    digitalWrite(i, LOW);
  };
  for(int i = 0; i<=7; ++i){
    // number 상수의 하나의 비트값을 읽는다
    bitValue = bitRead(number[displayValue], i);
    // 앞서 읽은 비트값을 2~9번핀에 출력시킨다
    digitalWrite(i+2, bitValue);
  }
}

void setup() {
  // 2~9번 핀을 a b c d e f g dot 의 순서로 사용한다.
  // 2~9번 핀을 출력으로 초기화 시킨다.
  for(int i = 2; i <= 9; ++i){
    pinMode(i, OUTPUT);
  };
  digitalWrite(9,LOW);
}

void loop() {
  // k값을 0~9로 변화시킨다.
  for(int k = 0; k <= 9; ++k){
    fndDisplay(k); // k값을 출력한다
    delay(1000);  
  };
}
