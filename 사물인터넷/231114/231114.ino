#include <ESP8266WiFi.h>
#include <ESP8266WebServer.h>
#include <pgmspace.h>

#define LED_PIN LED_BUILTIN
#define LED_OFF 0
#define LED_ON 1

const char* ssid = "ssid";
const char* password = "password";

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
</body>
</html>
)=====";

void handleMain(){
  String html = pageMain;
  server.send(200, "text/html", html);
  digitalWrite(LED_PIN, LED_OFF);
  delay(500);
  digitalWrite(LED_PIN, LED_ON);
}
void handleSecondPage(){
  String html = pageSecond;
  server.send(200, "text/html", html);
  digitalWrite(LED_PIN, LED_OFF);
  delay(500);
  digitalWrite(LED_PIN, LED_ON);
}
void handleThirdPage(){
  String html = pageThird;
  server.send(200, "text/html", html);
  digitalWrite(LED_PIN, LED_OFF);
  delay(500);
  digitalWrite(LED_PIN, LED_ON);
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

  server.begin();
  Serial.println("Server started");
}

void loop() {
  server.handleClient();
}
