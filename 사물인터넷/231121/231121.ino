#include <ESP8266WiFi.h>
#include <ESP8266WebServer.h>
#include <pgmspace.h>
#include <Aims_oled_shield.h>
Aims_oled  oled;

#define LED_PIN LED_BUILTIN

#define DHT22_PIN D4
#include <AimTimer.h>
AimTimer timerTemp(10);
AimTimer timerHum(10);

#include <Aims_dht22.h>

Aims_dht22 dht(DHT22_PIN);

const char* ssid = "AndroidHotspot1072";
const char* password = "zxcbb100";

ESP8266WebServer server(80);

const char pageMain[] PROGMEM = R"=====(
<!doctype html>
<html>
<head>
	<title>Main Page</title>
</head>
<body>
	<h1>This is Main page</h1>
	<p><a href="/">Main Page</a></p>
	<p><a href="/second_page">Second Page</a></p>
	<p><a href="/third_page">Thrid Page</a></p>
  <p><a href="/temp_page">Temp Page</a></p>
  <p><a href="/hum_page">Hum Page</a></p>
</body>
</html>
)=====";
 
const char pageSecond[] PROGMEM = R"=====(
<!doctype html>
<html>
<head>
	<title>Second Page</title>
</head>
<body>
	<h1>This is Second page</h1>
	<p><a href="/">Main Page</a></p>
	<p><a href="/second_page">Second Page</a></p>
	<p><a href="/third_page">Thrid Page</a></p>
  <p><a href="/temp_page">Temp Page</a></p>
  <p><a href="/hum_page">Hum Page</a></p>
</body>
</html>
)=====";
 
const char pageThird[] PROGMEM = R"=====(
<!doctype html>
<html>
<head>
	<title>Thrid Page</title>
</head>
<body>
	<h1>This is Third page</h1>
	<p><a href="/">Main Page</a></p>
	<p><a href="/second_page">Second Page</a></p>
	<p><a href="/third_page">Thrid Page</a></p>
  <p><a href="/temp_page">Temp Page</a></p>
  <p><a href="/hum_page">Hum Page</a></p>
</body>
</html>
)=====";

void handleMain(){
  String html = pageMain;
  server.send(200, "text/html", html);
  digitalWrite(LED_PIN, HIGH);
  delay(500);
  digitalWrite(LED_PIN, LOW);
}
void handleSecondPage(){
  String html = pageSecond;
  server.send(200, "text/html", html);
  digitalWrite(LED_PIN, LOW);
}
void handleThirdPage(){
  String html = pageThird;
  server.send(200, "text/html", html);
  digitalWrite(LED_PIN, HIGH);
}
void handleTempPage(){
  float cnt1 = dht.getTemp();
  // String html = String(cnt1);
  String json = "Temp : " + String(cnt1);
  server.send(200, "text/json", json);
}
void handleHumPage(){
  float cnt2 = dht.getHum();
  // String html = String(cnt2);
  String json = "Hum : " + String(cnt2);
  server.send(200, "text/json", json);
}


void setup() {
  Serial.begin(115200);
  pinMode(LED_PIN,OUTPUT);
  WiFi.mode(WIFI_STA);
  WiFi.begin(ssid, password);

  while (WiFi.status() != WL_CONNECTED){
    delay(500);
    Serial.print(".");
  }
  Serial.println("");
  Serial.println("Connecting to ");
  Serial.println(ssid);
  Serial.println("IP address : ");
  Serial.println(WiFi.localIP());

  server.on("/", handleMain);
  server.on("/second_page", handleSecondPage);
  server.on("/third_page", handleThirdPage);
  server.on("/temp_page", handleTempPage);
  server.on("/hum_page", handleHumPage);

  server.begin();
  Serial.println("Server started");
}

void loop() {

  server.handleClient();
  
  if (timerTemp.isOn() || timerTemp.isOn()){
    // Serial.print("temp = ");
    // Serial.println(dht.getTemp());
    float cnt1 = dht.getTemp();
    float cnt2 = dht.getHum();
    oled.keyVal(String(cnt1),String(cnt2));
  }
}
