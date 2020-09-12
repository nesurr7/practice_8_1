package classes;

import java.awt.*;

public abstract class Shape {

    //Свойства
    protected Color color;
    protected int x ,  y , type;
    protected int width , length;
    ///////////
    //Конструкторы
    ////////////
    Shape(int type ,Color color,int x ,int y ,int length , int width){
        this.type=type;
        this.color=color;
        this.x=x;
        this.y=y;
        this.length=length;
        this.width=width;
    }


}