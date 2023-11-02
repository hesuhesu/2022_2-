#include <Ticker.h>
#define LED_PIN LED_BUILTIN
#define LED_OFF 0
#define LED_ON 1
#define LED_BLINK 2

Ticker tickerLed;

bool onVal=LOW;
bool offVal=HIGH;

int mode;
int onMil=3000;
int offMil=500;

volatile bool blinkOn;
volatile unsigned long nextMil;

void ICACHE_RAM_ATTR ledISR(){
  if(mode == LED_BLINK){
    if (blinkOn && millis() > nextMil){
      digitalWrite(LED_PIN, offVal);
      blinkOn = false;
      nextMil = millis() + offMil;
    }
    else if (!blinkOn && millis() > nextMil){
      digitalWrite(LED_PIN, onVal);
      blinkOn = true;
      nextMil = millis() + onMil;
    }
  }
}

void setup() {
  // put your setup code here, to run once:
  Serial.begin(115200);
  Serial.println();

  Serial.println("input m0 for led off");
  Serial.println("input m1 for led on");
  Serial.println("input m2 for led blink");
 //등록
  pinMode(LED_PIN,OUTPUT);
}

void loop() {
  // put your main code here, to run repeatedly:
  while(Serial.available()){
    char c=Serial.read();
    if (c=='m'){
      int val=Serial.parseInt();
      switch(val){
        case 0: mode=LED_OFF;
          digitalWrite(LED_PIN,offVal);
          Serial.println("mode=LED_OFF");
          break;
        case 1: mode=LED_ON;
          digitalWrite(LED_PIN,onVal);
          Serial.println("mode=LED_ON");
          break;
        case 2: mode=LED_BLINK;
           digitalWrite(LED_PIN,onVal);
           blinkOn=true;
           nextMil=millis()+onMil;
           Serial.println("mode=LED_BLINK");
           break;
        default:
          Serial.println("mode ERROR!");
          continue;
      }
    }
  }
  ledISR();
}
