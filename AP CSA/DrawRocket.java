// Ananya Soni
// 10/15/2021
// Assignment #2
// This program will produce the image of a Rocketship. 
// It will also use a class constant to scale the size of the Rocket ship.


public class DrawRocket {

    public static final int SIZE = 2;
    public static void main(String[] args) {
        drawTriangle();
        drawLine();
        drawUpperDiamond();
        drawLowerDiamond();
        drawLine();
        drawLowerDiamond();
        drawUpperDiamond();
        drawLine();
        drawTriangle();

    }

    /*This method produces the top and bottom triangles of the rocket ship. 
    It uses a for loop to produce the dashes and periods on the left and
    right side of the column of two stars in the middle. The amount of rows of 
    the triangles depends on what the class constant is set equal to. The amount of rows 
    is equal to the SIZE times 2 minus 1. So if the class constant (SIZE) is set equal
    to three, then the triangle has 5 rows. */

    public static void drawTriangle() {
        for (int i = 1; i <= SIZE * 2 - 1; i++) {
            for (int j = 1; j <= 2 * SIZE - i; j++) {
                System.out.print(" ");
            }

            for (int j = 1; j <= i; j++) {
                System.out.print("/");
            }

            System.out.print("**");

            for (int j = 1; j <= i; j++) {
                System.out.print("\\");
            }

            System.out.println(" ");


        }

    }

    /*This method produces the upper parts of the diamonds in the Rocketship. 
    It uses a for loop to determine the amount of rows that are produced 
    depending on what the class constant is set equal to. It also determines 
    the amount of vertical bars that are used. For example if the
    class constant (SIZE) is set equal to 3, then three rows of the upper diamond part are produced, with a vertical
    bar at the start and end. As such there are also three rows produced with "/\" and "."
    The number of "/\" and "."  in each row is also determined by a for loop which is inside the first for loop
    that determines the amount of rows produced. In the method for the upper diamond,
    the amount of "/\" increments up with each consecutive row you go down and the number of ".",
    increments down with each consecutive row you go down. */

    public static void drawUpperDiamond() {

        for (int i = 1; i <= SIZE; i++) {


            System.out.print("|");

            for (int j = 1; j <= SIZE - i; j++) {
                System.out.print(".");
            }

            for (int j = 1; j <= i; j++) {
                System.out.print("/\\");
            }

            for (int j = 1; j <= (SIZE - i) * 2; j++) {
                System.out.print(".");
            }

            for (int j = 1; j <= i; j++) {
                System.out.print("/\\");
            }
            for (int j = 1; j <= SIZE - i; j++) {
                System.out.print(".");
            }
            System.out.println("|");


        }


    }

    /*This method produces the lower parts of the diamonds in the Rocketship. 
    It uses a for loop to determine the amount of rows that are produced 
    depending on what the class constant is set equal to. It also determines 
    the amount of vertical bars that are used. For example if the
    class constant (SIZE) is set equal to 3, then three rows of the upper diamond part are produced, with a vertical
    bar at the start and end. As such there are also three rows produced with "/\" and "."
    The number of "/\" and "."  in each row is also determined by a for loop which is inside the first for loop
    that determines the amount of rows produced. In the method for the lower diamond,
    the amount of "/\" increments down with each consecutive row you go down and the number of ".",
    increments up with each consecutive row you go down. This method is exactly the opposite of the upper
    diamond method. */

    public static void drawLowerDiamond() {

        for (int i = 1; i <= SIZE; i++) {

            System.out.print("|");

            for (int j = 2; j <= i; j++) {
                System.out.print(".");
            }

            for (int j = 0; j <= SIZE - i; j++) {
                System.out.print("\\/");
            }

            for (int j = 1; j <= 2 * i - 2; j++) {
                System.out.print(".");
            }

            for (int j = 0; j <= SIZE - i; j++) {
                System.out.print("\\/");
            }
            for (int j = 2; j <= i; j++) {
                System.out.print(".");
            }
            System.out.println("|");


        }
    }

    /*This method produces the lines in the Rocketship that
    go between each of the different sections. Once again it uses a 
    for loop to determine the amount of times the symbols in between
    repeat. In this case the amount of "=*" is equal to what the class
    constant (SIZE) is set to, times 2. The "+" symbol goes outside the for
    loop since we only want it at the beginning and end of the line. */

    public static void drawLine() {
        System.out.print("+");

        for (int i = 1; i <= SIZE * 2; i++) {
            System.out.print("=*");
        }
        System.out.println("+");
    }

}
