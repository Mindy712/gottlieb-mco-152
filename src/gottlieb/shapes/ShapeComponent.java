package gottlieb.shapes;

import javax.swing.*;
import java.awt.*;

public class ShapeComponent extends JComponent {
    private String shape  ="";
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int width = getWidth();
        int height = getHeight();

        int centerX = width / 2;
        int centerY = height / 2;

        g.translate(centerX, centerY);
        if (shape.equals("star"))
        {
            drawStar(g);
        }
        else if (shape.equals("house"))
        {
            drawHouse(g);
        }
        else if (shape.equals("stopSign"))
        {
            drawStopSign(g);
        }
        else if (shape.equals("smiley")) {
            drawSmiley(g);
        }
        else
        {
            drawNothing();
        }
    }

    private void drawStar(Graphics g)
    {
        int[] xpoints = {-15, -20,  0, 20, 15,  30,  10,   0, -10, -30};
        int[] ypoints = {  5,  25, 10, 25,  5, -10, -10, -30, -10, -10};
        int npoints = 10;
        g.setColor(Color.blue);
        g.fillPolygon(xpoints, ypoints, npoints);
    }

    public void setShapeStar()
    {
        shape = "star";
        repaint();
    }

    private void drawHouse(Graphics g)
    {
        g.drawRect(-20, -20, 40,  40);
        g.drawLine(-20, -20, 0, -40);
        g.drawLine(0, -40, 20, -20);
        g.drawRect(-5, 5, 10, 15);
        g.drawRect(-15, -10, 8, 8);
        g.drawRect(7, -10, 8, 8);
        g.drawLine(-11, -10, -11, -2);
        g.drawLine(-15, -6, -7, -6);
        g.drawLine(11, -10, 11, -2);
        g.drawLine(7, -6, 15, -6);
        g.fillOval(-3, 12, 2, 2);
    }

    public void setShapeHouse()
    {
        shape = "house";
        repaint();
    }

    private void drawStopSign(Graphics g)
    {
        int[] xpoints = {-35, -15, 15, 35,  35,  15, -15, -35};
        int[] ypoints = { 15,  35, 35, 15, -15, -35, -35, -15};
        int npoints = 8;
        g.setColor(Color.red);
        g.fillPolygon(xpoints, ypoints, npoints);
        g.setColor(Color.black);
        g.drawString("STOP", -15, 5);
    }

    public void setShapeStopSign()
    {
        shape = "stopSign";
        repaint();
    }

    private void drawSmiley(Graphics g)
    {
        g.setColor(Color.yellow);
        g.fillOval(-20, -20, 40, 40);
        g.setColor(Color.white);
        g.fillOval(-12, -15, 10, 15);
        g.fillOval(2, -15, 10, 15);
        g.fillOval(-5, 5, 10, 10);
        g.setColor(Color.black);
        g.fillOval(-10, -10, 6, 6);
        g.fillOval(4, -10, 6,6);
        g.drawOval(-5, 5, 10, 10);
        g.drawOval(-20, -20, 40, 40);
        g.drawOval(-12, -15, 10, 15);
        g.drawOval(2, -15, 10, 15);
    }

    public void setShapeSmiley()
    {
        shape = "smiley";
        repaint();
    }

    private void drawNothing()
    {

    }
}
