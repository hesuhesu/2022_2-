#include <Servo.h> 

// data sheet
// upload는 ctrl + u

// LED pin을 13번으로 지정
const int ledPin = 13;
// 2번 핀을 스위치 입력으로 설정
const int inputPin = 2;

void setup() {
  // 13번 핀에 내장된 led를 출력으로 설정함
  pinMode(ledPin, OUTPUT);
  // 스위치 입력을 위하여 2번핀을 입력으로 설정하고 풀업시킨다.
  pinMode(inputPin, INPUT_PULLUP);
}

void loop() {
  // 스위치 입력을 받는다
  int swInput = digitalRead(inputPin);

  if (swInput == LOW) {
    digitalWrite(ledPin, HIGH);
  }
  else {
    digitalWrite(ledPin, LOW); // led 소등
  }
}
