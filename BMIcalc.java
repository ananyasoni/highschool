//Ananya Soni
//11/1/2021
//Purpose:
// This program reads data for two people and
// computes their body mass index (BMI). It looks to see whether 
// each person is overweight, underweight, or normal
// based on their BMI. Then the program compares the two 
// people's BMI and reports whether they are the same or different. 

import java.util.*;

public class BMIcalc {
   
   private static Scanner console = new Scanner(System.in);
   
   public static void main(String[] args){
      
      intro();
      double person1BMI = getBMI();
      double person2BMI = getBMI();
      reportBMI(1, person1BMI);
      reportBMI(2, person2BMI);
      reportComparison(person1BMI, person2BMI);
   }
   
   //This method prints the introduction
   public static void intro() {
      System.out.println("This program reads data for two people and");
      System.out.println("computes their body mass index (BMI).");
      System.out.println();
   }
   
   //This method collects the information on the people's weight and height
   public static double getBMI() {
      System.out.println("Enter next person's information:");
      double weight = getDouble("Enter your weight (lbs): ");
      double height = getDouble("Enter your height (in): ");
      System.out.println();
      return (703 * weight) / (height * height);
   }
   
   //This method reduces redundancy when asking for Person1 and Person2 BMI by using the parameter prompt so the prompt for weight and height is only typed
   //once in the method getBMI.
   public static double getDouble(String prompt) {
      System.out.print(prompt);
      return console.nextDouble();
   }
   //This method states whether a person is underweight, normal, or overweight based on the bmi value.
   public static void reportBMI(int personNumber, double bmi) {
      System.out.println("Person " + personNumber + " BMI = " + bmi);
      if (bmi < 18.5) {
         System.out.println("underweight");
      } else if (bmi < 24.9){
         System.out.println("normal");
      } else if (bmi < 29.9){
         System.out.println("overweight");
      } else {
         System.out.println("obese");
      }
   }
   
   //This method reports whether person1BMI and person2BMI are the same or
   //one is higher than the other.
   
   public static void reportComparison(double person1BMI, double person2BMI) {
      double error = Math.abs(person1BMI - person2BMI);
      if ( error < 0.001 ) {
         System.out.print("The BMI values are the same.");
      }
      else if ( person1BMI > person2BMI) {
         System.out.print("Person 1 BMI value is higher.");
         
      } else {
         System.out.print("Person 2 BMI value is higher.");
      }
   }
   
   
}











