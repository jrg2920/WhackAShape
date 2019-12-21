// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, 
//nor will I accept the actions of those who do.
// Jhanavi Ghadia (jrg2920)package game;
package game;


import java.awt.Color;
import CS2114.Button;
import CS2114.CircleShape;
import CS2114.Shape;
import CS2114.SquareShape;
import CS2114.TextShape;
import CS2114.Window;
import CS2114.WindowSide;
import bag.SimpleBagInterface;
import student.TestableRandom;

/**
 * @author jhanavi ghadia
 * @version 2019.09.26
 *          WhackaShape class
 */
public class WhackAShape {
    private SimpleBagInterface<Shape> bag;
    private Window window;
    private TestableRandom randomGenerator;
    private Button quitButton;


    /**
     * A default constructor for WhackAShape class
     */
    public WhackAShape() {

        bag = new SimpleArrayBag<Shape>();
        window = new Window();
        this.quitButton = new Button("Quit");
        quitButton.onClick(this, "clickedQuit");
        window.addButton(quitButton, WindowSide.SOUTH);
        String[] shapes = { "redcircle", "bluecircle", "redsquare",
            "bluesquare" };
        randomGenerator = new TestableRandom();
        int count = randomGenerator.nextInt(6) + 7;
        // A for loop to add random string into an array
        for (int i = 0; i < count; i++) {
            int index = randomGenerator.nextInt(shapes.length);
            bag.add(buildShape(shapes[index]));
        }
        window.addShape(bag.pick());
    }


    /**
     * getter for a bag
     * 
     * @return a bag
     */
    public SimpleBagInterface<Shape> getBag() {
        return bag;
    }

    /**
     * Getter for window
     * 
     * @return window
     */
    public Window getWindow() {
        return window;
    }

    /**
     * exits when hit a quit button
     * @param button
     * button of type Button
     */
    public void clickedQuit(Button button) {
        System.exit(0);
    }

    /**
     * clickedShape method that removed and adds a shape
     */
    public void clickedShape(Shape shape) {
        window.removeShape(shape);
        bag.remove(shape);
        Shape nextShape = bag.pick();
        TextShape textShape = new TextShape(0, 0, "");
        if (nextShape == null) {
            TextShape win = new TextShape(window.getGraphPanelWidth() / 2
                - textShape.getWidth() / 2, window.getGraphPanelHeight() / 2
                    - textShape.getHeight() / 2, "You WIn!");

            window.addShape(win);
        }
        else {
            window.addShape(nextShape);
        }
    }


    /**
     * WhackaShape constructor with try and catch blocks
     */
    public WhackAShape(String[] inputs) {
        bag = new SimpleArrayBag<Shape>();
        this.quitButton = new Button("Quit");
        quitButton.onClick(this, "clickedQuit");

        try {
            randomGenerator = new TestableRandom();
            for (int i = 0; i < inputs.length; i++) {

                int index = randomGenerator.nextInt(inputs.length);
                bag.add(buildShape(inputs[index]));
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * buildShape method which will create a shape from color
     * @param input
     * A string variable
     * @return a shape of that particular color
     */
    private Shape buildShape(String input) {

        int size = randomGenerator.nextInt(101) + 100;

        int x = (randomGenerator.nextInt(window.getGraphPanelWidth() - size));
        int y = (randomGenerator.nextInt(window.getGraphPanelHeight() - size));
        Shape currentShape = null;
        if (input.contains("red")) {
            if (input.contains("circle")) {
                currentShape = new CircleShape(x, y, size, Color.red);
            }
            if (input.contains("square")) {
                currentShape = new SquareShape(x, y, size, Color.red);
            }
        }
        if (input.contains("blue")) {
            if (input.contains("circle")) {
                currentShape = new CircleShape(x, y, size, Color.blue);
            }
            if (input.contains("square")) {
                currentShape = new SquareShape(x, y, size, Color.blue);
            }
        }
        if (currentShape == null) {
            throw new IllegalArgumentException();
        }

        currentShape.onClick(this, "clickedShape");

        return currentShape;
    }

}
