import java.awt.*;
import javax.swing.*;
public class ConvexTest {
    public static void main(String[] args) throws Exception {
        Convex c = new Convex();
        Frame w = new Frame(c);

        w.setBackground(Color.white);
        for(int i = 0; i < 5; i++) {
            c.add(new R2Point());
           // System.out.println("S = " + c.area() + " , P = " + c.perimeter());
        }
        w.repaint();
    }
}


