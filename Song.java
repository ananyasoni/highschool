// Ananya Soni
// 9/15/2021
// CSE142
// Assignment #1
// This program will produce a cummalitive song as the output. 

public class Song {
	public static void main(String[]args) {
		printVerseOne();
		printVerseTwo();
		printVerseThree();
		printVerseFour();
		printVerseFive();
		printVerseSix();
		printVerseSeven();
	}
   
   public static void verseOneRepeated(){ 
      System.out.println("I don't know why she swallowed that fly,");
   	System.out.println("Perhaps she'll die.");
   	System.out.println();
	}
	
	public static void printVerseOne() { 
      System.out.println("There was an old woman who swallowed a fly.");
      verseOneRepeated();
   }
	
	public static void verseTwoRepeated() {
      System.out.println("She swallowed the spider to catch the fly,");
      verseOneRepeated();    
   }
	
   public static void printVerseTwo() { 
      System.out.println("There was an old woman who swallowed a spider,");
      System.out.println("That wriggled and iggled and jiggled inside her.");
      verseTwoRepeated();
   }
      
   public static void verseThreeRepeated(){
      System.out.println("She swallowed the bird to catch the spider,");
      verseTwoRepeated();
   }
	
	public static void printVerseThree() {
      System.out.println("There was an old woman who swallowed a bird,");
      System.out.println("How absurd to swallow a bird.");
      verseThreeRepeated();
   }
	
	public static void verseFourRepeated(){
      System.out.println("She swallowed the cat to catch the bird,");
      verseThreeRepeated();
   }
      
	public static void printVerseFour() {
      System.out.println("There was an old woman who swallowed a cat,");
      System.out.println("Imagine that to swallow a cat.");
      verseFourRepeated();
   }
	 
	public static void verseFiveRepeated() {
      System.out.println("She swallowed the dog to catch the cat,");
      verseFourRepeated();
   }
	 
	public static void printVerseFive() {
      System.out.println("There was an old woman who swallowed a dog,");
      System.out.println("What a hog to swallow a dog.");
      verseFiveRepeated();
   }
	 
	public static void verseSixRepeated() {
      System.out.println("She swallowed the duck to catch the dog,");
      verseFiveRepeated();
   }
	 
	public static void printVerseSix() {
      System.out.println("There was an old woman who swallowed a duck,");
      System.out.println("Imagine the duck took a buck,");
      verseSixRepeated();
   }
   
	public static void printVerseSeven() {
      System.out.println("There was an old woman who swallowed a horse,");
      System.out.println("She died of course.");
   }  
}
		
	
	
