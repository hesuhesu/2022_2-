#include <Servo.h> 

// data sheet
// upload는 ctrl + u

const int ledA = 3;
const int ledB = 5;
int brightness = 0;
int increment = 1;

void setup() {
  // analogWrite 에는 별도의 설정이 불필요.
}

void loop() {
  // 저항은 +, - 극성이 없다. 저항은 330옴
  // 다이오드는 존재함. 발광 다이오드는 다리가 긴 쪽이 +, 짧은 쪽이 -

  analogWrite(ledA, brightness);       // LED A 밝기 조절
  analogWrite(ledB, 255-brightness);   // LED B 밝기 조절

  brightness = brightness + increment;
  if((brightness>= 255)||(brightness<= 0)) {
    increment = increment; // 밝기 변수 증감 방향 변경
    }
  delay(10); // 0.01 초간 지연
  
}
