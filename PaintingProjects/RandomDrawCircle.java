package PaintingProjects;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * When run as a program, this class opens a window on the screen that
 * shows a large number of colored disks. The positions of the disks
 * are selected at random, and the color is randomly selected from
 * red, green, or blue. A black outline is drawn around each disk.
 * The picture changes every three seconds.
 */

public class RandomDrawCircle extends JPanel {

    public void paintComponent(Graphics g) {
        drawCircle(g);
    }

    public void drawCircle(Graphics g) {
        int colorChoice;
        int centerX;
        int centerY;
        for (int i = 0; i < 500; i++) {
            colorChoice = (int) (5 * Math.random());
            switch (colorChoice) {
                case 0:
                    g.setColor(Color.RED);
                    break;
                case 1:
                    g.setColor(Color.GREEN);
                    break;
                case 2:
                    g.setColor(Color.BLUE);
                    break;
                case 3:
                    g.setColor(Color.YELLOW);
                    break;
                case 4:
                    g.setColor(Color.GRAY);
                    break;
                case 5:
                    g.setColor(Color.MAGENTA);
                    break;
            }
            centerX = (int) (1000 * Math.random());
            centerY = (int) (1000 * Math.random());
            g.fillOval(centerX - 50, centerY - 50, 200, 200);
            g.setColor(Color.BLACK);
            g.drawOval(centerX - 50, centerY - 50, 300, 300);
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Random painting circle");
        RandomDrawCircle panel = new RandomDrawCircle();
        frame.add(panel);
        frame.setSize(900, 600);
        frame.setLocation(300, 100);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        JButton button = new JButton("Repaint");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.repaint();
            }
        });
        panel.add(button);
    }

}