#include <IRremote.h> 
#include <Servo.h>

// 적외선 수신부가 연결될 핀을 설정한다.
int irPin = 11;

// LED에 연결된 핀을 설정한다.
int led1 = 2;
int led2 = 3;
int led3 = 4;
int led4 = 5;
int led5 = 6;

// LED 제어용 코드 (리모컨에 맞게 수정한다)
long on1 = 0xFF6897;
long off1 = 0xFF30CF;
long on2 = 0xFF18E7;
long off2 = 0xFF7A85;
long on3 = 0xFF10EF;
long off3 = 0xFF38C7;
long on4 = 0xFF5AA5;
long off4 = 0xFF42BD;
long on5 = 0xFF4AB5;
long off5 = 0xFF52AD;

Servo motor1;

// 서보 모터 신호핀 설정
int servoMotorPin = 9;

// 모터 각도 변수 설정
int motorAngle;
int motorAngleOld;

// 적외선 수신부가 연결된 핀을 리모컨 수신 핀으로 설정한다.
IRrecv irrecv(irPin);

// 수신된 신호의 결과를 results 변수로 설정한다
decode_results results;

void setup() {
  // 시리얼 통신 설정
  Serial.begin(9600);

  // 적외선 리모컨 수신을 시작한다.
  irrecv.enableIRIn();

  // 13번 핀에 연결된 LED를 리모컨 수신시 점멸시킨다.
  irrecv.blink13(true);

  pinMode(led1, OUTPUT);
  pinMode(led2, OUTPUT);
  pinMode(led3, OUTPUT);
  pinMode(led4, OUTPUT);
  pinMode(led5, OUTPUT);

  // 서보모터 설정. 0.6ms ~ 2.4ms 범위로 설정.
  motor1.attach(servoMotorPin, 600,2400);
}

void loop() {

  // 수신된 코드가 있을 때 실행한다.
  if (irrecv.decode(&results)){
    // 0xFFFFFFFF 값을 제외하고 출력한다.
    if(results.value != 0xFFFFFFFF){
      // 수신된 코드가 on1과 같을 때
      if (results.value == on1){
        digitalWrite(led1, HIGH);
        Serial.println("LED1 is ON");
        // 모터에 각도값을 전달한다
        motor1.write(0);
      }
      // 수신된 코드가 off1과 같을 때
      if(results.value == off1){
        digitalWrite(led1, LOW);
        Serial.println("LED1 is OFF");
        // 모터에 각도값을 전달한다
        motor1.write(20);
      }
      // 수신된 코드가 on2와 같을 때
      if (results.value == on2){
        digitalWrite(led2, HIGH);
        Serial.println("LED1 is ON");
        // 모터에 각도값을 전달한다
        motor1.write(40);
      }
      // 수신된 코드가 off2과 같을 때
      if(results.value == off2){
        digitalWrite(led2, LOW);
        Serial.println("LED2 is OFF");
        // 모터에 각도값을 전달한다
        motor1.write(60);
      }
      // 수신된 코드가 on3과 같을 때
      if (results.value == on3){
        digitalWrite(led1, HIGH);
        Serial.println("LED3 is ON");
        // 모터에 각도값을 전달한다
        motor1.write(80);
      }
      // 수신된 코드가 off3과 같을 때
      if(results.value == off3){
        digitalWrite(led3, LOW);
        Serial.println("LED3 is OFF");
        // 모터에 각도값을 전달한다
        motor1.write(100);
      }
      // 수신된 코드가 on4와 같을 때
      if (results.value == on4){
        digitalWrite(led4, HIGH);
        Serial.println("LED4 is ON");
        // 모터에 각도값을 전달한다
        motor1.write(120);
      }
      // 수신된 코드가 off4과 같을 때
      if(results.value == off4){
        digitalWrite(led4, LOW);
        Serial.println("LED4 is OFF");
        // 모터에 각도값을 전달한다
        motor1.write(140);
      }
      // 수신된 코드가 on5와 같을 때
      if (results.value == on5){
        digitalWrite(led5, HIGH);
        Serial.println("LED5 is ON");
        // 모터에 각도값을 전달한다
        motor1.write(160);
      }
      // 수신된 코드가 off5과 같을 때
      if(results.value == off5){
        digitalWrite(led5, LOW);
        Serial.println("LED5 is OFF");
        // 모터에 각도값을 전달한다
        motor1.write(180);
      }
    }
    // 다음 수신을 위해서 준비한다.
    irrecv.resume();
  }
  
}
