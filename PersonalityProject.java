// Ananya Soni
// 1/25/2022
// Mr.Thompson
// Program Description:

// This program processes an input
// file of data for a personality test known as
// the Keirsey Temperament Sorter. Individuals are categorized as being on
// one side or the other of each of the 4 dimensions.
// The corresponding letters are put together to form a personality type and
// the personality type is printed in the output file.

import java.io.*;
import java.util.*;
public class PersonalityProject {
   
   public static final int DIMENSIONS = 4;
   public static final int GROUP_QUESTIONS = 7;
   public static final int TOTAL_QUESTIONS = 70;
   
   public static void main(String[] args) throws FileNotFoundException {
      Scanner console = new Scanner(System.in);
      printIntro();
      System.out.print("input file name? ");
      Scanner input = new Scanner(new File(console.next()));
      System.out.print("output file name? ");
      PrintStream output = new PrintStream(new File(console.next()));
      
      while (input.hasNextLine()) {
         output.print(input.nextLine() + ": ");
         String rawPersonality = input.next();
         int[][] categoryCount = new int[2][DIMENSIONS]; //categoryCount array stores A and B counts
         countAB(rawPersonality, categoryCount);
         int[] bPercentages = calculateBPercentage(categoryCount);
         output.println(Arrays.toString(bPercentages) + " = " + findPersonalityType(bPercentages)); //prints both the array with the percentage of B
                                                                                                    //answers in all the dimensions as well as the personality type
                                                                                                    //based on the percentage of B answers. 
         if (input.hasNextLine()) {
            input.nextLine();
         }
      }
   }
   
   //This method just prints the introduction so
   //it isn't crowded in main with print statements.
   public static void printIntro() {
      System.out.println("This program processes a file of answers to the");
      System.out.println("Keirsey Temperament Sorter. It converts the");
      System.out.println("various A and B answers for each person into");
      System.out.println("a sequence of B-ercentages and then into a");
      System.out.println("four-letter personality type.");
      System.out.println();
   }
   
   ///////////////////////////////////////////////////////////////////////
   // Purpose: This method takes in the string of personality
   //          answers and counts the number of As and Bs in each string
   //          of answers. It then stores those counts in the 2D array
   //          categoryCount. Row 0 stores the A counts, while Row 1
   //          stores the B counts.
   
   // Input:   rawPersonality answers and empty categoryCount 2D array
   
   private static void countAB(String rawPersonality, int[][] categoryCount) {
      for (int i = 0; i < TOTAL_QUESTIONS; i++) {
         int indexOfCategory = ((i % GROUP_QUESTIONS + 1) /2);
         if (rawPersonality.charAt(i) == 'A' || rawPersonality.charAt(i) == 'a') {
            categoryCount[0][indexOfCategory]++;
         }
         else if (rawPersonality.charAt(i) == 'B' || rawPersonality.charAt(i) == 'b') {
            categoryCount[1][indexOfCategory]++;
         }
      }
      
   }
   
   ///////////////////////////////////////////////////////////////////////
   // Purpose: This method takes in the categoryCount 2D array with the 
   //          A and B counts. It then takes the A and B counts
   //          to calculate the B percentage in each of the 
   //          4 personality dimensions.
   
   // Input:   categoryCount 2D array which contains both the A and B counts
   // Output:  array of length 4 (DIMENSIONS) with bPercentages 
   
   private static int[] calculateBPercentage(int[][] categoryCount) {
      int [] bPercentages= new int [DIMENSIONS];
      for (int i = 0; i < DIMENSIONS; i++) {
         bPercentages[i] = (int)(Math.round((categoryCount[1][i]) / ((double)(categoryCount[0][i] + categoryCount[1][i])) * 100));
      }
      return bPercentages;
      
   }
   
   ///////////////////////////////////////////////////////////////////////
   // Purpose: This method finds the personality type of each person by
   //          taking in the percentage of B answers from the bPercentages
   //          array to find what personality type matches in each of the
   //          4 dimensions. 
   
   // Input:   bPercentages array with the percentage of B answers in each dimension
   // Output:  String with the full personality type
   
   private static String findPersonalityType(int[] bPercentages) {
      String[][] personalityChoices = {{"E", "I"}, {"S", "N"}, {"T", "F"}, {"J", "P"}};
      String personalityType = "";
      for (int i = 0; i < DIMENSIONS; i++) {
         if (bPercentages[i] < 50) {
            personalityType = personalityType + personalityChoices[i][0];
         } else if (bPercentages[i] > 50) {
            personalityType = personalityType + personalityChoices[i][1];
         } else {
            personalityType = personalityType + "X";
         }
      }
      return personalityType;
      
   }
}


