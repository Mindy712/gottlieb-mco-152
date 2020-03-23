package gottlieb.shapes;

import javax.swing.*;
import java.awt.*;

public class ShapesFrame extends JFrame {
    private ShapeComponent shapeComponent;

    public ShapesFrame()
    {
        setSize(300, 400);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Shapes");

        setLayout(new BorderLayout());

        shapeComponent = new ShapeComponent();
        add(shapeComponent, BorderLayout.CENTER);

        JPanel buttonFrame = new JPanel();
        add(buttonFrame, BorderLayout.WEST);
        buttonFrame.setLayout(new GridLayout(4, 1, 0, 15));

        JButton starButton = new JButton("Star");
        buttonFrame.add(starButton);
        starButton.addActionListener(actionEvent ->
        {
            shapeComponent.setShapeStar();
        });

        JButton houseButton = new JButton("House");
        buttonFrame.add(houseButton);
        houseButton.addActionListener(actionEvent ->
        {
            shapeComponent.setShapeHouse();
        });

        JButton stopSignButton = new JButton("Stop sign");
        buttonFrame.add(stopSignButton);
        stopSignButton.addActionListener(actionEvent ->
        {
            shapeComponent.setShapeStopSign();
        });

        JButton smileyButton = new JButton("Surprised face");
        buttonFrame.add(smileyButton);
        smileyButton.addActionListener(actionEvent ->
        {
            shapeComponent.setShapeSmiley();
        });

    }

    public static void main(String[] args) {
        new ShapesFrame().setVisible(true);
    }
}
