import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame {
    private Convex c;
//    private static final int width = 1280;
//    private static final int height = 720;
    public Frame(Convex c){
        this.c = c;
        //this.setSize(width, height);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setExtendedState(MAXIMIZED_BOTH);

    }
    public void paint(Graphics g){
        super.paint(g);
        g.clearRect(0,0,2000,2000);
        g.translate(getWidth()/2,getHeight()/2);
        g.drawLine(-getWidth()/2, 0 ,getWidth()/2, 0);
        g.drawLine(0,getHeight()/2,0,-getHeight()/2);
        this.repaint();
        c.draw(g);
    }
}
