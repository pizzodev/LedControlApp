int incomingByte = 0; // for incoming serial data

void setup() {
  pinMode(LED_BUILTIN, OUTPUT);  
  Serial.begin(9600); // opens serial port, sets data rate to 9600 bps
}

void loop() {
  // send data only when you receive data:
  if (Serial.available() > 0) {
    // read the incoming byte:
    incomingByte = Serial.read();

  if (incomingByte == 0x61)
  {
    digitalWrite(LED_BUILTIN, HIGH);  
  }
  else
  {
    digitalWrite(LED_BUILTIN, LOW);  
  }
  delay(100);
  // say what you got:
  Serial.print("I received: ");
  Serial.println(incomingByte, DEC);
  }
}
