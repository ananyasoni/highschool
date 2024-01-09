// Ananya Soni
// 9/15/2021
// CSE142
// Assignment #1
// This program will produce a custom Art piece. 

public class Ascii {

    public static void main(String[] args) {
        drawBody();
        drawBody();

    }
    public static void drawBody() {
        drawLine();
        System.out.println("+^^^^^^^+");
        System.out.println("+|||||||+");
        System.out.println("+>>>>>>>+");
        System.out.println("+<<<<<<<+");
        drawLine();

    }
    public static void drawLine() {
        System.out.println("+-+-+-+-+");


    }
}
