package classes;

import javax.swing.*;
import java.awt.*;

// реализация компонента
class Figure extends JComponent
{
    private Color color;//Цвет
    private int type;//Форма фигуры
    private int x,y;
    private int length , width;
    ///////////////
    Figure(int type , Color color ,int x ,int y,int length , int width) {
        this.color = color;
        this.type = type;
        this.x=x;
        this.y=y;
        this.length=length;
        this.width=width;
    }
    public void paintComponent(Graphics g) {//Выполняется автоматически//Находится в JComponent
        //Когда JVM посчитает , что экран нужно обновить вызовется этот метод
        // прорисовка фигуры
        g.setColor(color);
        switch (type) {
            case 0: g.fillOval(0, 0, length, width); break;
            case 1: g.fillRect(0, 0, length, width); break;
            case 2: g.fillOval(0,0,length,length);break;
            case 3: g.fillRect(0, 0, width, width); break;
        }
    }
}
public class Pane extends JFrame
{

    final int paneLength=1366;
    final int paneWidth=780;


    public Color randomColor(){
        int type=((int)(Math.random()*175))%7;
        switch (type){
            case 1: return Color.red;
            case 2: return Color.green;
            case 3: return Color.BLUE;
            case 4: return Color.CYAN;
            case 5: return Color.MAGENTA;
            case 6: return Color.YELLOW;
        }
        return Color.pink;
    }


    public Shape generate(){
        int type=(((int)(Math.random()*100))%4);
        switch (type) {
            case 0:return new Oval(type ,randomColor(),((int)(Math.random()*(paneWidth)/2)),((int)(Math.random()*(paneLength/2))),80,130);
            case 1:return new Rectangle(type ,randomColor(),((int)(Math.random()*(paneWidth)/2)),((int)(Math.random()*(paneLength/2))),120,80);
            case 2:int a=((int)(Math.random()*(paneWidth)/2));return new Oval(type ,randomColor(),a,a,50,50);
            case 3:int b=((int)(Math.random()*(paneWidth)/2));return new Rectangle(type ,randomColor(),b,b,70,70);
    }
        return new Rectangle(type ,randomColor().brighter(),50,50,40,60);
    }

    public Figure initShape(Shape obj1){
      Figure figure = new Figure(obj1.type,obj1.color , obj1.x , obj1.y , obj1.length , obj1.width);
      figure.setBounds(obj1.x, obj1.y,obj1.length,obj1.width);
      return figure;
    }

    public Pane()
    {
        super("Фигуры");//Задаем название для окна//невидимый фрэйм для текста
        setDefaultCloseOperation(EXIT_ON_CLOSE);//выход
        JLayeredPane lp = getLayeredPane();// панель с глубиной (слоистая)
        //////////////////////
        // добавление фигур в различные слои


        for(int i=0;i<20;i++){
            lp.add(initShape(generate()), JLayeredPane.POPUP_LAYER  );//300-тый слой =>ниже
        }
        setSize(paneWidth, paneLength);
        setVisible(true);
    }
    public static void main(String[] args)
    {
        JFrame.setDefaultLookAndFeelDecorated(true);
        new Pane();
    }
}
