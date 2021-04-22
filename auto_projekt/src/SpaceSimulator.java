import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class SpaceSimulator {

    static MilkyWay milkyWay;
    static JFrame frame;

    public static void main(String[] args) {

        milkyWay = new MilkyWay();
        frame = new JFrame();
        frame.setLayout(new GridLayout(1, 1));
        frame.add(milkyWay);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ActionListener repaint = evt -> frame.repaint();
        new Timer(20, repaint).start();
    }
}