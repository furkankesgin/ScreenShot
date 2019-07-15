import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.concurrent.TimeUnit;

public class Main extends JFrame {

        private static Point point = new Point();

        public static void main(String[] args){
            source s = new source();
            s.setUndecorated(true);
            s.setBounds(50,50,300,130);
            s.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            s.setVisible(true);
            s.setBackground(new Color(0,0,0,100));

            s.addMouseListener(new MouseAdapter() {
                public void mousePressed(MouseEvent e) {
                    point.x = e.getX();
                    point.y = e.getY();
                }
            });
            s.addMouseMotionListener(new MouseMotionAdapter() {
                public void mouseDragged(MouseEvent e) {
                    Point p = s.getLocation();
                    s.setLocation(p.x + e.getX() - point.x, p.y + e.getY() - point.y);
                }
            });

        }

}

