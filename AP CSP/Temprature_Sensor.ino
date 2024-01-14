const int tempPin = 0;  // Define the analog pin for the temperature sensor

int tempVal;  // Variable to store the raw analog value from the temperature sensor

float volts;  // Variable to store the voltage value from the temperature sensor

float tempC;  // Variable to store the temperature in degrees Celsius
float tempF;  // Variable to store the temperature in degrees Fahrenheit

void setup()
{
  Serial.begin(9600);  // Initialize serial communication for debugging
}

void loop()
{
  tempVal = analogRead(tempPin);  // Read the raw analog value from the temperature sensor

  Serial.print("TempVal = ");
  Serial.print(tempVal);

  Serial.print("    ");

  volts = tempVal * 5.0 / 1023.0;  // Convert the raw analog value to voltage

  Serial.print("volts: ");
  Serial.print(volts, 3);

  Serial.print("    ");

  tempC = (volts - 0.5) * 100.0;  // Convert the voltage to temperature in degrees Celsius

  Serial.print("degrees C: ");
  Serial.print(tempC);

  Serial.print("     ");

  tempF = (tempC * 9.0 / 5.0) + 32.0;  // Convert the temperature to degrees Fahrenheit

  Serial.print("degrees F: ");
  Serial.println(tempF);

  delay(3000);  // Delay for 3 seconds before the next temperature reading
}
