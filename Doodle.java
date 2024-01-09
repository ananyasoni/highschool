// Ananya Soni
// 10/30/2021
// Program Description: 
// This program draws a snowman

import java.awt.*;

public class Doodle {

    public static void main(String[] args) {
        DrawingPanel panel = new DrawingPanel(400, 400);
        Graphics g = panel.getGraphics();
        panel.setBackground(Color.BLUE);
        g.setColor(Color.WHITE);
        g.fillOval(170, 200, 50, 50);
        g.fillOval(159, 240, 75, 75);
        g.fillOval(147, 290, 100, 100);
        g.setColor(Color.BLACK);
        g.drawLine(233, 270, 265, 250);
        g.drawLine(159, 270, 135, 250);
        g.fillOval(180, 220, 5, 5);
        g.fillOval(205, 220, 5, 5);
        g.setColor(Color.BLACK);
        g.fillRect(159, 195, 70, 10);
        g.fillRect(172, 155, 40, 40);
        g.setColor(Color.ORANGE);
        g.drawPolygon(new int[] {194,194,204}, new int[] {229,232,230}, 3);
        g.setColor(Color.BLACK);
        g.fillOval(193, 278, 7, 7);
        g.fillOval(193, 257, 7, 7);
        g.fillOval(193, 299, 7, 7);
        g.setColor(Color.WHITE);
        g.fillRect(0, 380, 400, 380);
    }

}
