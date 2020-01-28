package com.company;
import javax.swing.*;
import java.awt.*;
public class MyWindow extends JFrame {
    protected static int width = 600;
    protected static int height = 600;
    private Convex n;

    public MyWindow(Convex n)
    {
        this.setSize(1000,1000);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
    public MyWindow(Convex c)
    {
        this();
        this.c = c;
    }
    @Override
    public void paint(Graphics g)
    {
        super.paint(g);
        g.translate(getWidth()/2,getHeight()/2); // Смещение точки начала координат

        // g.setColor(new Color(0,0,0));
        g.drawLine(-getWidth()/2, 0 ,getWidth()/2, 0);
        // g.setColor(new Color(0,0,0));
        g.drawLine(0,-getHeight()/2,0,getHeight()/2);
        // g.translate(-getWidth()/2,-getHeight()/2);

        g.translate(-getWidth()/2,-getHeight()/2); // Возврат точки начала координат в исходное значение (нужно для положительных значений генерирующихся координат "птиц" и их отображения на экране)
        c.draw(g);

    }

}
