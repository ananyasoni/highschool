int photoresistor = 0;   // Analog pin for the photoresistor (A0)
int threshold = 300;     // Threshold value for turning on the LED

void setup() {
  // Setup code to run once
  Serial.begin(9600);     // Initialize serial communication 
  pinMode(13, OUTPUT);    // Set pin 13 as an output for the LED
}

void loop() {
  // Main code to run repeatedly

  photoresistor = analogRead(A0);    // Read the analog value from the photoresistor
  Serial.println(photoresistor);     // Print the photoresistor value to the serial monitor for debugging

  if (photoresistor < threshold) {
    // If the photoresistor value is below the threshold, turn on the LED
    digitalWrite(13, HIGH);          // Turn on the LED
    delay(500);                       // Wait for 500 milliseconds
    digitalWrite(13, LOW);           // Turn off the LED
    delay(500);                       // Wait for another 500 milliseconds
  } else {
    // If the photoresistor value is above the threshold, turn off the LED
    digitalWrite(13, LOW);            // Turn off the LED
  }
}
