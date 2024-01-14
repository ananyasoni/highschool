// Pin assignments
int firstKeyPin = 2;      // Pin for the first button
int secondKeyPin = 3;     // Pin for the second button
int thirdKeyPin = 4;      // Pin for the third button

int buzzerPin = 10;       // Pin for the buzzer

void setup() {
  // Set the button pins as inputs with pull-up resistors
  pinMode(firstKeyPin, INPUT_PULLUP);
  pinMode(secondKeyPin, INPUT_PULLUP);
  pinMode(thirdKeyPin, INPUT_PULLUP);

  // Set the buzzer pin as an output
  pinMode(buzzerPin, OUTPUT);
}

void loop() {
  // Check if the first button is pressed
  if (digitalRead(firstKeyPin) == LOW) {
    tone(buzzerPin, 262);  // Play a tone (262 Hz) on the buzzer
  }
  // Check if the second button is pressed
  else if (digitalRead(secondKeyPin) == LOW) {
    tone(buzzerPin, 330);  // Play a tone (330 Hz) on the buzzer
  }
  // Check if the third button is pressed
  else if (digitalRead(thirdKeyPin) == LOW) {
    tone(buzzerPin, 392);  // Play a tone (392 Hz) on the buzzer
  }
  else {
    noTone(buzzerPin);     // Turn off the buzzer if no button is pressed
  }
}
