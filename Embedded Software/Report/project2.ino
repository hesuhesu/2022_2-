#include <Servo.h>
#include <IRremote.h>

/*
  근전도 센서를 기용한 이유 :
  근전도 센서는 바늘을 근육에 찔러넣는 방식보다 정확도면에서는 떨어진다.
  다만. 바늘을 꼽은 상태로 큰 움직임 + 행동을 할 경우 신경을 건드리거나, 근육의 손상이 있을 가능성이 존재하기 때문에
  근전도 센서를 기용하였다.

  생활체육에 관심이 많은 사람으로써, 신체의 활동이나 움직임 운동을 독학할 때 유용한 방법이 없을까? 하는 호기심에서 나온 기획안.

  <상황 전개 - 1>
  1. 근전도 센서와 연결된 패드를 측정하고 싶은 부위(서로 다른 부위 둘)에 붙인다.
  2. 주동근을 확인하기 위해 운동을 시도하는데, 측정 시 지인이 있으면 모니터링 하기 좋다.
  3. 원하는 부위의 발달을 위해 자세를 바꿔간다.

  <상황 전개 - 2>
  1. 근전도 센서를 동일 부위 다른 부분에 붙인다(ex. 척추기립근)
  2. 아래의 코드를 사용하여 부저가 울리는지 확인한다.
  3. 울리지 않고 자연스럽게 진행이 된다면 운동을 잘하고 있음을 알 수 있다.

  <상황 전개 - 3>
  1. 가벼운 척추측만증이나, 골반이 살짝 휜 사람 등등의 환자들에게 추천된다
  2. 상황 전개 - 2 와 같이 동일 부위 다른 부분에 붙이고 경과를 측정한다(센서의 차이를 감안해서 날마다 줄여가는 식으로 훈련)

  조건 1 :
  센서 한 쌍(2개)로 값을 측정하여 값이 50(예상값)보다 크게 차이난다면 부저가 울리도록 구현.

  조건 2 :
  적외선 리모컨을 이용한 모드 변경이 가능하게 설계

  조건 3 :


  예상질문 1 :
  센서의 오류에 대응하는 방법
  ->
  센서는 조건문에 따라 시행되므로, 일부의 오류는 제외한다

  예상질문 2 :
  센서가 연결된 패드를 양쪽 부위에 연결했는데, 값이 다를 시
  ->
  이럴 경우 애초에 근육 불균형이 있는 경우이므로 이를 이용해서 날짜별로 밸런스있게 트레이닝 하도록 권장

  예상질문 3 :
  자세의 교정을 도모한다 하였는데, 진행이 좀 되어 측정 시작값이 차이가 날 땐?
  ->
  정형외과나 물리치료 기관을 방문하는게 좋다. 제작 의도는 어디까지나 간단한 측정 & 교정 목적.


  장점 1 :
  운동 시 가지게 되는 잘못된 습관이나 불규칙한 행동을 고칠 수 있다(나만의 퍼스널 트레이너)

  장점 2 :
  프리웨이트 운동은 주동근이 자세에 따라 다름. 이를 데이터를 통해 객관적으로 수용할 수 있는 지표가 생긴다.

  장점 3 :
  자세 교정시 민감성을 부여하여 긴장감을 유지할 수 있다.
*/


/*
  추가 사항
  1. 리모컨 배선 시. 대가리로 보이는 부분 꼽고, 왼쪽부터 11번핀 gnd 5v 순이다.
  2. 피에조 부저는 + 부분이 9번핀 다른 부분이 gnd 연결.
  3.
*/


int buzzerPin = 9;


// 노래의 빠르기를 설정한다.
int tempo = 200;

// 적외선 수신부가 연결될 핀을 설정한다.
int irPin = 11;

// 적외선 수신보가 연결된 핀을 리모컨 수신 핀으로 설정한다.
IRrecv irrecv(irPin);

// 수신된 신호의 결과를 results 변수로 설정한다.
decode_results;


// 1번과 2번 버튼을 통해 모드를 각각 바꾼다. (밑은 예시 코드이며, 제대로 설정 후 재 기입)
long mode1 = 0xFF30CF;
long mode2 = 0xFF18E7;

/**
  16:44:08.129 -> Received Code is FF6897
  16:44:09.269 -> Received Code is FF30CF
  16:44:11.268 -> Received Code is FF18E7

*/

void setup() {
  Serial.begin(9600);
  pinMode(buzzerPin, OUTPUT);

  // 적외선 리모컨 수신을 시작한다.
  irrecv.enableIRIn();

  // 13번 핀에 연결된 LED를 리모컨 수신시 점멸시킨다.
  irrecv.blink13(true);
}

void loop() {

  // 부저 출력 시간에 사용할 변수 설정
  int duration;

  duration = tempo;

  int adcValue; // 포텐셜미터 실제 값
  int duty;

  int val1 = analogRead(A0);
  /*
    // 수신된 코드가 있을 때 실행한다.
    if(irrecv.decode(&results)){
      // 0xFFFFFFFF 값을 제외하고 출력한다.
      if(results.value != 0xFFFFFFFF){
        // 수신된 값을 16진수 형태로 출력한다.
        Serial.print("Received Code is ");
        Serial.println("results.value, HEX);
      }
      // 다음 수신을 위해서 준비한다.
      irrecv.resume();
    }
  */

  // 수신된 코드가 있을 때 실행한다.(위의 코드를 먼저 사용하여 리모컨 번호별 정보를 얻는다 필요한건 2개)
  if (irrecv.decode(&results)){
    // 0xFFFFFFFF 값을 제외하고 출력한다.
    if (results.value != 0xFFFFFFFF) {
      if (results.value == mode1) {
        if (val1 > 500) {
          Serial.print("균형모드 1센서의 값은 : ");
          Serial.println(val1);

          // tone 명령어를 통하여 부저 핀으로 사각파를 출력한다
          tone(buzzerPin, 262, 50); // c
          // delay(100);
        }
        else {

          Serial.print("균형모드 1센서의 값은 : ");
          Serial.println(val1);
        }
        if (results.value == mode2) {

          Serial.print("균형모드 1센서의 값은 : ");
          Serial.println(val1);
        }
      }
    }
  }

}
/*int val1 = analogRead(A0);
  Serial.print("균형모드 1센서의 값은 : ");
  Serial.println(val1);
  int val2 = analogRead(A1);
  Serial.print("균형모드 2센서의 값은 : ");
  Serial.println(val2);

  if (val1 - val2 > 50 || val2 - val1 > 50) { // 50 이상 두 센서의 차이가 날 시 부저음 발생.

  int val1 = analogRead(A0);
  Serial.print("균형모드 1센서의 값은 : ");
  Serial.println(val1);
  int val2 = analogRead(A1);
  Serial.print("균형모드 2센서의 값은 : ");
  Serial.println(val2);

  // tone 명령어를 통하여 부저 핀으로 사각파를 출력한다
  tone(buzzerPin, 349, 50);
  delay(100);
  }*/
