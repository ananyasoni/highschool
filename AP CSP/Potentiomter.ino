int potPosition;  // Variable to store the position of the potentiometer

void setup() {
  // Setup code to run once
  Serial.begin(9600);  // Initialize serial communication 
}

void loop() {
  // Main code to run repeatedly

  potPosition = analogRead(A0);   // Read the analog value from the potentiometer
  Serial.println(potPosition);    

  if (potPosition < 500) {
    // If the potentiometer value is below 500, blink the LED with a short delay
    digitalWrite(13, HIGH);       // Turn on the LED
    delay(500);                    // Wait for 500 milliseconds
    digitalWrite(13, LOW);        // Turn off the LED
    delay(500);                    // Wait for another 500 milliseconds
  } else {
    // If the potentiometer value is 500 or above, blink the LED with a longer delay
    digitalWrite(13, HIGH);       // Turn on the LED
    delay(1000);                   // Wait for 1000 milliseconds
    digitalWrite(13, LOW);        // Turn off the LED
    delay(500);                    // Wait for another 500 milliseconds
  }
}
