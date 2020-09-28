package classes;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Pane extends JFrame {

    ArrayList<Shape> myShapes = new ArrayList<>();
    Dimension dimScreen = Toolkit.getDefaultToolkit().getScreenSize();
    int PANE_LENGTH =dimScreen.width;
    int PANE_HEIGHT=dimScreen.height;


    public Color randomColor() {
        int type = ((int) (Math.random() * 175)) % 7;
        return switch (type) {
            case 1 -> Color.red;
            case 2 -> Color.green;
            case 3 -> Color.BLUE;
            case 4 -> Color.CYAN;
            case 5 -> Color.MAGENTA;
            case 6 -> Color.YELLOW;
            default -> Color.pink;
        };
    }

    public int generatePosX(){
        return ((int) (Math.random() * (PANE_LENGTH)) % (PANE_LENGTH-100) );

    }

    public int generatePosY() {
        return ((int) (Math.random() * (PANE_HEIGHT)) % (PANE_HEIGHT-100) );

    }

    public Shape generate() {
        int type = (((int) (Math.random() * 100)) % 4);
        switch (type) {
            case 0 -> { return new Oval(randomColor(), generatePosX() , generatePosY(), 50, 100); }
            case 1 -> { return new Rectangle(randomColor(), generatePosX(), generatePosY(), 100, 50); }
            case 2 -> { return new Oval(randomColor(), generatePosX(), generatePosY(), 50, 50); }
            case 3 -> { return new Rectangle(randomColor(), generatePosX(), generatePosY(), 50, 50); }
        }
        return null;
    }

    public Pane() {
        super("Фигуры");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        for (int i = 0; i < 20; i++) {
            Shape shape = generate();
            myShapes.add(shape);
            add(shape);
        }
        setSize(PANE_LENGTH, PANE_HEIGHT);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        JFrame.setDefaultLookAndFeelDecorated(true);
        new Pane();
    }
}
