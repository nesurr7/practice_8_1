package classes;

import javax.swing.*;
import java.awt.*;

public abstract class Shape extends JComponent {

    //Свойства
    protected Color color;
    protected int x, y, type;
    protected int height, length;

    ///////////
    //Конструкторы
    ////////////
    Shape(int type, Color color, int x, int y, int length, int height) {
        this.type = type;
        this.color = color;
        this.x = x;
        this.y = y;
        this.length = length;
        this.height = height;
        setBounds(x,y,length,height);
    }

    public void paintComponent(Graphics g) {//Выполняется автоматически//Находится в JComponent
        //Когда JVM посчитает , что экран нужно обновить вызовется этот метод
        // прорисовка фигуры
        g.setColor(color);
        switch (type) {
            case 0 -> g.fillOval(0, 0, length, height);
            case 1 -> g.fillRect(0, 0, length, height);
            case 2 -> g.fillOval(0, 0, length, length);
            case 3 -> g.fillRect(0, 0, height, height);
        }
    }


}