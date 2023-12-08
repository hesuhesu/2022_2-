#include <ESP8266WiFi.h>
#include <ESP8266WebServer.h>
#include <pgmspace.h>
#include <Aims_oled_shield.h>
Aims_oled  oled;

#define DHT22_PIN D4
#include <AimTimer.h>
AimTimer timerTemp(10);
AimTimer timerHum(10);

#include <Aims_dht22.h>

Aims_dht22 dht(DHT22_PIN);

void setup() {
  Serial.begin(115200);
  // pinMode(LED_PIN,OUTPUT);
}

void loop() {
  
  if (timerTemp.isOn() || timerHum.isOn()){
    float cnt1 = dht.getTemp();
    float cnt2 = dht.getHum();
    oled.keyVal(String(cnt1),String(cnt2));
  }
}
