
#define INPUTPORT  4

void setup() {
  pinMode(LED_BUILTIN, OUTPUT);
  pinMode(INPUTPORT, INPUT);    // sets the digital pin 13 as input
}

void loop() {
 
  if (digitalRead(INPUTPORT) == HIGH)
  {
  digitalWrite(LED_BUILTIN, HIGH);  
  }
  else
  {
  digitalWrite(LED_BUILTIN, LOW);  
  }
  delay(100);
}
