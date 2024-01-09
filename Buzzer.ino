// Pin assignment for the speaker
int speakerPin = 10;

// Variables for the musical notes
int currentFrequency = 0;
int beatLength = 150;

// Setup function
void setup() {
  pinMode(speakerPin, OUTPUT);  // Set the speaker pin as an output
}

// Function to play a musical note
void play(char note, int beats) {
  // Arrays for musical notes and their corresponding frequencies
  int numNotes = 14;
  char notes[] = {'c', 'd', 'e', 'f', 'g', 'a', 'b', 'C', 'D', 'E', 'F', 'G', 'A', 'B', ' '};
  int frequencies[] = {131, 147, 165, 175, 196, 220, 247, 262, 294, 330, 349, 392, 440, 494, 0};

  // Find the frequency of the given note
  for (int i = 0; i < 15; i++) {
    if (notes[i] == note) {
      currentFrequency = frequencies[i];
    }
  }

  // Play the note on the speaker
  tone(speakerPin, currentFrequency, beats * beatLength);
  delay(beats * beatLength);
  delay(50);  // Add a small delay for separation between notes
}

// Loop function
void loop() {
  // Play the "Happy Birthday" song
  play('g', 2);
  play('g', 1);
  play('a', 4);
  play('g', 4);
  play('C', 4);
  play('b', 4);  // you

  play(' ', 2);  // pause for 2 beats

  play('g', 2);  // ha
  play('g', 1);  // ppy
  play('a', 4);  // birth
  play('g', 4);  // day
  play('D', 4);  // to
  play('C', 4);  // you

  play(' ', 2);  // pause for 2 beats

  play('g', 2);  // ha
  play('g', 1);  // ppy
  play('G', 4);  // birth
  play('E', 4);  // day
  play('C', 4);  // dear
  play('b', 4);  // your
  play('a', 6);  // name

  play(' ', 2);  // pause for 2 beats

  play('F', 2);  // ha
  play('F', 1);  // ppy
  play('E', 4);  // birth
  play('C', 4);  // day
  play('D', 4);  // to
  play('C', 6);  // you

  while (true) {
    
  }
}
