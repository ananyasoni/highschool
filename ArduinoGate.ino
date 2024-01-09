#include <Servo.h>

int trigPin = 11;    // Trigger
int echoPin = 12;    // Echo
long duration, cm, inches;
int servoPosition;
int distance = inches;

Servo myServo;  // Servo object

void setup() {
  Serial.begin(9600);  // Serial Port begin
  pinMode(trigPin, OUTPUT);
  pinMode(echoPin, INPUT);
  myServo.attach(9);  // Attaches the servo motor to pin 9
}

void loop() {
  myServo.write(0);
  digitalWrite(trigPin, LOW);
  delayMicroseconds(5);
  digitalWrite(trigPin, HIGH);
  delayMicroseconds(10);
  digitalWrite(trigPin, LOW);

  pinMode(echoPin, INPUT);

  cm = (duration / 2) / 29.1;
  inches = (duration / 2) / 74;

  Serial.print(inches);
  Serial.print("in, ");
  Serial.print(cm);
  Serial.print("cm");
  Serial.println();

  delay(250);
  
  // Check if the measured distance is between 0 and 200 inches
  if (inches <= 200 && inches >= 0) {
    servoPosition = map(distance, 0, 1023, 20, 160);  // Map the distance to servo position
    myServo.write(180);  // Move the servo to the mapped position (180 degrees)
    delay(4500);  // Delay for 4500 milliseconds
    myServo.write(0);  // Move the servo back to the initial position (0 degrees)
  }
}
