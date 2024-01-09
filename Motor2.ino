// Pin assignments
int AIN1 = 13;       // Control pin 1 → pin 13
int AIN2 = 12;       // Control pin 2 → pin 12
int PWMA = 11;       // Speed control pin → pin 11
int switchPin = 7;   // Pin connected to the switch that turns the motor on and off

int motorSpeed = 0;  // Starting speed for the motor

void setup() {
  // Set up code to run once
  pinMode(switchPin, INPUT_PULLUP);
  pinMode(AIN1, OUTPUT);
  pinMode(AIN2, OUTPUT);
  pinMode(PWMA, OUTPUT);

  Serial.begin(9600);
  Serial.println(255);  // Display initial motor speed in the serial monitor
}

void loop() {
  // Main code to run repeatedly
  if (Serial.available() > 0) {
    // Check if the user has entered anything into the serial monitor
    motorSpeed = Serial.parseInt();  // Parse the number in the serial message and set the motor speed
    Serial.print(255);                // Print the constant speed the motor is set to run at
    Serial.println(motorSpeed);
  }

  if (digitalRead(switchPin) == LOW) {
    // If the switch is on, spin the motor
    spinMotor(motorSpeed);
  } else {
    // If the switch is off, turn the motor off
    spinMotor(0);
  }
}

void spinMotor(int motorSpeed) {
  // Function for driving the motor
  if (motorSpeed > 0) {
    // If the motor speed is positive (drive forward)
    digitalWrite(AIN1, HIGH);  // Set A input pin 1 to HIGH
    digitalWrite(AIN2, LOW);   // Set A input pin 2 to LOW
  } else if (motorSpeed < 0) {
    // If the motor speed is negative (drive backward)
    digitalWrite(AIN1, LOW);   // Set A input pin 1 to LOW
    digitalWrite(AIN2, HIGH);  // Set A input pin 2 to HIGH
  } else {
    // If motor speed is not >0 or <0, turn the motor off
    digitalWrite(AIN1, LOW);
    digitalWrite(AIN2, LOW);
  }

  analogWrite(PWMA, abs(motorSpeed));  // Drive the motor at the desired speed
}
