#include <Servo.h>
Servo EduServo;

int trigPin = 13;                           // 디지털 13번 핀에 연결
int echoPin = 12;                           // 디지털 12번 핀에 연결
int Ultra_d = 0;

int val = 0;                                // 좌우 경로 설정 변수
   
int RightMotor_E_pin = 5;                   // 오른쪽 모터의 Enable & PWM
int LeftMotor_E_pin = 6;                    // 왼쪽 모터의 Enable & PWM
int RightMotor_1_pin = 8;                   // 오른쪽 모터 제어선 IN1
int RightMotor_2_pin = 9;                   // 오른쪽 모터 제어선 IN2
int LeftMotor_3_pin = 10;                   // 왼쪽 모터 제어선 IN3
int LeftMotor_4_pin = 11;                   // 왼쪽 모터 제어선 IN4

int L_MotorSpeed = 153;                     // 왼쪽 모터 속도
int R_MotorSpeed = 153;                     // 오른쪽 모터 속도

void setup() {  
  EduServo.attach(2);                       // 서보모터 PWM 디지털입출력 2번핀 연결
  
  pinMode(echoPin, INPUT);                  // echoPin 입력
  pinMode(trigPin, OUTPUT);                 // trigPin 출력
  
  pinMode(RightMotor_E_pin, OUTPUT);        // 출력모드로 설정
  pinMode(RightMotor_1_pin, OUTPUT);
  pinMode(RightMotor_2_pin, OUTPUT);
  pinMode(LeftMotor_3_pin, OUTPUT);
  pinMode(LeftMotor_4_pin, OUTPUT);
  pinMode(LeftMotor_E_pin, OUTPUT);

  Serial.begin(9600);
  Serial.println("Welcome Eduino!");
}

void loop() { 
  Ultra_d = Ultrasonic();
  Serial.println(Ultra_d);   
  motor_role(HIGH, HIGH);         // 직진

  if(Ultra_d < 250) {
    if (Ultra_d < 150) {
      Serial.println("150 이하.");
      motor_role(LOW, LOW);      // 후진
      delay(700);
      analogWrite(RightMotor_E_pin, 0);  
      analogWrite(LeftMotor_E_pin, 0);
      delay(200);
    }
    else {
      analogWrite(RightMotor_E_pin, 0);  
      analogWrite(LeftMotor_E_pin, 0);
      delay(200);
      Serial.println("150 이상.");
      val =  Servo_con();
      if (val == 0) {
        Serial.println("우회전.");
        analogWrite(RightMotor_E_pin, 0);  
        analogWrite(LeftMotor_E_pin, 0);
        delay(300);
        motor_role(LOW, LOW);    // 후진
        delay(300);
        motor_role(LOW, HIGH);   // 우회전
        delay(500);
      }
      else if (val == 1) {
        Serial.println("좌회전.");
        analogWrite(RightMotor_E_pin, 0);  
        analogWrite(LeftMotor_E_pin, 0);
        delay(300);
        motor_role(LOW, LOW);   // 후진
        delay(300);
        motor_role(HIGH, LOW);  // 좌회전
        delay(500);
      }
    }
  }
}

void motor_role(int R_motor, int L_motor){
   digitalWrite(RightMotor_1_pin, R_motor);
   digitalWrite(RightMotor_2_pin, !R_motor);
   digitalWrite(LeftMotor_3_pin, L_motor);
   digitalWrite(LeftMotor_4_pin, !L_motor);
   
   analogWrite(RightMotor_E_pin, R_MotorSpeed);                          // 우측 모터 속도값
   analogWrite(LeftMotor_E_pin, L_MotorSpeed);                           // 좌측 모터 속도값  
}

int Ultrasonic(){
  long duration, distance;
  digitalWrite(trigPin, HIGH);                                            // trigPin에서 초음파 발생(echoPin도 HIGH)        
  delayMicroseconds(10);
  digitalWrite(trigPin, LOW);
  duration = pulseIn(echoPin, HIGH);                                      // echoPin 이 HIGH를 유지한 시간을 저장 한다.
  distance = ((float)(340 * duration) / 1000) / 2; 

  Serial.print("DIstance:");                                              // 물체와 초음파 센서간 거리를 표시.        
  Serial.println(distance);

  return distance;
}

int Servo_con(){
  EduServo.write(90);
  delay(300);
  int Ult_30 = Ultrasonic();
  delay(500);
  EduServo.write(90);
  delay(300);
  int Ult_150 = Ultrasonic();
  delay(500);

  if(Ult_30 > Ult_150){
     val = 1;
  }
  else{
     val = 0;
  }
  EduServo.write(90);
  return val;
}
