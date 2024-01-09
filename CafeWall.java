// Ananya Soni
// 10/30/2021
// AP CSA Period 4
// Program Description: 

//This program produces a CafeWall illusion.
//It is 650 pixels by 400 pixels and has a gray background. 
//It has many structures made up of Black and white squares, 
//which are used to form rows and rows are combined to form grids.  
//The output has two free-standing rows and four grids.

import java.awt.*;

public class CafeWall {

    public static final int MORTAR = 2;
    public static DrawingPanel panel = new DrawingPanel(650, 400);
    public static Graphics g = panel.getGraphics();

    public static void main(String[] args) {

        panel.setBackground(Color.GRAY);
        Graphics g = panel.getGraphics();

        //Two free standing rows output:

        // Description  (x, y) position     Number of pairs   Size of each box
        // upper-left   (0, 0)              4                  20
        //mid-left     (50, 70)             5                  30

        //     (x,  y,  numPairs, size) 

        drawRow(0, 0, 4, 20); //upper-left free standing row		
        drawRow(50, 70, 5, 30); //mid-left free standing row

        // Four Grids output:

        //Description     (x, y) position     Number of pairs    Size of each box    2nd row offset    
        //lower left      (10, 150)           4                  25                  0
        //lower middle    (250, 200)          3                  25                  10
        //lower right     (425, 180)          5                  20                  10
        //upper right     (400, 20)           2                  35                  35

        //      (x,   y,   numPairs, offset, boxSize)

        drawGrid(10, 150, 4, 0, 25); //lower left grid
        drawGrid(250, 200, 3, 10, 25); //lower middle grid
        drawGrid(425, 180, 5, 10, 20); //lower right grid
        drawGrid(400, 20, 2, 35, 35); //upper right grid		

    }

    // This method produces the rows with the black and white box pairs. In this method the number 
    // of pairs specifies the amount of black and white pair boxes in the row.  
    // The boxes are specified using a single size parameter (boxSize) since they are squares 
    // The varying positions are determined by the x and y paremeters, the number of black/white pairs (numPairs), and the box size (boxSize).  
    // A loop is used so that the method can produce various rows based on the number of black/white pairs (numPairs).

    public static void drawRow(int x, int y, int numPairs, int boxSize) {

        for (int i = 1; i <= numPairs; i++) {

            //Black Box
            g.setColor(Color.BLACK);
            g.fillRect(2 * (i - 1) * boxSize + x, y, boxSize, boxSize);

            //White Box: add Box Size again to x-coordinate so White Box is not covering Black Box
            g.setColor(Color.WHITE);
            g.fillRect(2 * (i - 1) * boxSize + boxSize + x, y, boxSize, boxSize);

            //Blue Cross on Black Box
            g.setColor(Color.BLUE);
            g.drawLine(2 * (i - 1) * boxSize + x, y, 2 * (i - 1) * boxSize + x + boxSize, y + boxSize);
            g.drawLine(2 * (i - 1) * boxSize + x, y + boxSize, 2 * (i - 1) * boxSize + boxSize + x, y);

        }

    }

    //This method produces the grids of the rows by calling the rows.  
    //The Grids are made up of pairs of rows where the second row is offset a certain distance in the x direction relative to the first. 
    //In this method the number of pairs of black and white squares (numPairs) determines
    //the amount of columns and rows in the grid. The offset indicates how far the second row is shifted to the right in each pair.  
    //Each row in the grid is separated by a certain distance (MORTAR), revealing the gray background underneath. 
    //A class constant is used to set the gap (MORTAR) equal to 2 pixels.

    public static void drawGrid(int x, int y, int numPairs, int offset, int boxSize) {

        for (int i = 1; i <= numPairs; i++) {

            drawRow(x, 2 * (i - 1) * boxSize + y + 2 * (2 * i - 2), numPairs, boxSize); //first row no offset 
            drawRow(x + offset, 2 * (i - 1) * boxSize + y + 2 * (2 * i - 2) + MORTAR + boxSize, numPairs, boxSize); //second offset row in the x-direction from first row 
        }

    }

}
