#include <Servo.h>  // Include the Servo library

int potPosition;    // Variable to store the position of the potentiometer
int servoPosition;  // Variable to store the position of the servo motor

Servo myservo;      // Create a Servo object named "myservo"

void setup() {
  myservo.attach(9);  // Attach the servo motor to pin 9
}

void loop() {
  potPosition = analogRead(A0);                          // Read the analog value from the potentiometer
  servoPosition = map(potPosition, 0, 1023, 20, 160);    // Map the potentiometer value to the servo motor range (20 to 160)

  myservo.write(servoPosition);                          // Set the servo motor position based on the mapped value
}
