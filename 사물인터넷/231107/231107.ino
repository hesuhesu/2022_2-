#include <AimTimer.h>
#include <Ticker.h>
#define LED_PIN LED_BUILTIN
#define LED_OFF 0
#define LED_ON 1
#define LED_BLINK 2
#define BTN_PIN D3 // GPI00
#define BTN_ON LOW
#define BTN_OFF HIGH

// AimTimer timerOled(5);
#include <Aims_oled_shield.h>
Aims_oled  oled;

Ticker tickerLed;

bool onVal=LOW;
bool offVal=HIGH;

int ledVal = LED_OFF;
int btnVal = BTN_OFF;
int SVbtnVal = BTN_OFF;

int mode;
int onMil=3000;
int offMil=500;

volatile int cnt = 0;

void ICACHE_RAM_ATTR btnCntISR(){
  cnt++;
}

void setup() {
  Serial.begin(115200);
  pinMode(LED_PIN,OUTPUT);
  digitalWrite(LED_PIN,OUTPUT);
  pinMode(BTN_PIN, INPUT_PULLUP);
  attachInterrupt(digitalPinToInterrupt(BTN_PIN), btnCntISR, FALLING);
}

void loop() {
  btnVal = digitalRead(BTN_PIN);
  
  if(SVbtnVal == BTN_OFF && btnVal == BTN_ON){
    displayOled();
  }
  SVbtnVal = btnVal;

  /*static unsigned long nextMil = millis() + 5000;
  if (millis() > nextMil){
    nextMil = millis() + 5000;
    noInterrupts();
    int newCnt = cnt;
    cnt = 0;
    interrupts();
    oled.keyVal("5sec val", String(newCnt));
    delay(5000);
    oled.keyVal("reset", "start");
  }*/
}

void displayOled() {
  static int cnt = 0;
  cnt++;
  oled.keyVal("횟수",String(cnt));
}
