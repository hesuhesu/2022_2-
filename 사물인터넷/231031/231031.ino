#define LED_PIN LED_BUILTIN

int cnt;
float temp;
String name;

void setup() {
  pinMode(LED_PIN, OUTPUT);
  Serial.begin(115200);
}

void loop() {

  while (Serial.available()){
    char c = Serial.read();

    if (c == 'm'){
      Serial.println("led on");
      digitalWrite(LED_PIN, LOW);
    }
    else if (c == '0'){
      Serial.println("led off");
      digitalWrite(LED_PIN, HIGH);
    }   
}
}
