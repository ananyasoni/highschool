// This program reads the values from a photoresistor and a potentiometer and controls an RGB LED based on those values. 
// Each color is associated with a range of values from the potentiometer. 

int photoresistor, potentiometer;
int threshold = 700;
int redPin = 9;
int greenPin = 10;
int bluePin = 11;

// Function to set LED to red color
void red() {
  analogWrite(redPin, 100);
  analogWrite(greenPin, 0);
  analogWrite(bluePin, 0);
}

// Function to set LED to green color
void green() {
  analogWrite(redPin, 0);
  analogWrite(greenPin, 100);
  analogWrite(bluePin, 0);
}

// Function to set LED to blue color
void blue() {
  analogWrite(redPin, 0);
  analogWrite(greenPin, 0);
  analogWrite(bluePin, 100);
}

// Function to set LED to magenta color
void magenta() {
  analogWrite(redPin, 255);
  analogWrite(greenPin, 0);
  analogWrite(bluePin, 0);
}

// Function to set LED to cyan color
void cyan() {
  analogWrite(redPin, 0);
  analogWrite(greenPin, 0);
  analogWrite(bluePin, 255);
}

// Function to set LED to grass color
void grass() {
  analogWrite(redPin, 0);
  analogWrite(greenPin, 255);
  analogWrite(bluePin, 0);
}

void setup() {
  // Setup code to run once
  Serial.begin(9600);
  pinMode(A0, INPUT);
  pinMode(A1, INPUT);
  pinMode(redPin, OUTPUT);
  pinMode(greenPin, OUTPUT);
  pinMode(bluePin, OUTPUT);
}

void loop() {
  // Main code to run repeatedly
  photoresistor = analogRead(A0);
  potentiometer = analogRead(A1);
  Serial.println(potentiometer);
  Serial.println(photoresistor);

  if (photoresistor < 865) {
    // If photoresistor value is below the threshold, turn off the LEDs
    analogWrite(redPin, 0);
    analogWrite(greenPin, 0);
    analogWrite(bluePin, 0);
  } else {
    // If photoresistor value is above the threshold, control LED colors based on potentiometer value
    analogWrite(redPin, 255);
    analogWrite(greenPin, 255);
    analogWrite(bluePin, 255);

    if (potentiometer <= 171 && potentiometer >= 0) {
      red();  // Set LED color to red
    } else if (potentiometer <= 342 && potentiometer >= 171) {
      analogWrite(redPin, 0);
      analogWrite(greenPin, 20);
      analogWrite(bluePin, 40);
    } else if (potentiometer <= 513 && potentiometer >= 342) {
      analogWrite(redPin, 55);
      analogWrite(greenPin, 255);
      analogWrite(bluePin, 0);
    } else if (potentiometer <= 1000 && potentiometer >= 513) {
      analogWrite(redPin, 0);
      analogWrite(greenPin, 255);
      analogWrite(bluePin, 255);
    } else if (potentiometer <= 684 && potentiometer >= 855) {
      analogWrite(redPin, 0);
      analogWrite(greenPin, 25);
      analogWrite(bluePin, 255);
    } else if (potentiometer <= 855 && potentiometer >= 684) {
      analogWrite(redPin, 40);
      analogWrite(greenPin, 0);
      analogWrite(bluePin, 55);
    }
  }
}
