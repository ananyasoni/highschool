//Ananya Soni
//12/2/2021
//AP CSA Period 4

//Purpose:
// This program prompts the 
// user for two words and reports 
// whether they "rhyme" (end with 
// the same last two letters) and/or 
// "alliterate" (start with the same letter).

import java.util.*;

public class RhymeAlliterate {
   
   private static Scanner console = new Scanner(System.in);
   
   public static void main(String[]args) {
      System.out.print("Type two words: ");
      String wordOne = console.next().toLowerCase();
      String wordTwo = console.next().toLowerCase();
      if  (rhyme(wordOne, wordTwo)) {
         System.out.println("They rhyme!");
      }
      if (alliterate(wordOne, wordTwo)) {
         System.out.println("They alliterate (start with the same letter)!");
      }
      if ((!alliterate(wordOne, wordTwo))  && (!rhyme(wordOne, wordTwo))) {
         System.out.println("They have nothing in common.");
      }
      
   }
   
   public static boolean alliterate(String wordOne, String wordTwo) {
      return (wordOne.startsWith(wordTwo.substring(0, 1)));
   }
   public static boolean rhyme(String wordOne, String wordTwo) {
      return (wordTwo.length() >= 2 && wordOne.endsWith(wordTwo.substring(wordTwo.length() - 2)));
   }
   
   
   
   
}
