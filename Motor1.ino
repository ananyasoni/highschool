int AIN1 = 13;  // Control pin 1 → pin 13
int AIN2 = 12;  // Control pin 2 → pin 12
int PWMA = 11;  // Speed control pin → pin 11
int motorSpeed = 0;

void setup() {
  // Setup code to run once
  pinMode(AIN1, OUTPUT);
  pinMode(AIN2, OUTPUT);
  pinMode(PWMA, OUTPUT);
}

void loop() {
  // Main code to run repeatedly

  // To drive the motor forward (positive speed), do the following:
  digitalWrite(AIN1, HIGH);
  digitalWrite(AIN2, LOW);
  analogWrite(PWMA, 255);
  delay(3000);

  // To drive the motor backward (negative speed), do the following:
  digitalWrite(AIN1, LOW);
  digitalWrite(AIN2, HIGH);
  analogWrite(PWMA, 255);
  delay(3000);

  // To stop the motor, do the following:
  digitalWrite(AIN1, LOW);
  digitalWrite(AIN2, LOW);
  analogWrite(PWMA, 0);  // This line is needed to ensure the motor stops
  delay(3000);
}
