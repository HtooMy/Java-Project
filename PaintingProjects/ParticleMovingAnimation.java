package PaintingProjects;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ParticleMovingAnimation extends JPanel implements ActionListener {

    final int PANEL_WIDTH = 500;
    final int PANEL_HEIGHT = 500;
    Image particle;
    Image backgroundImage;
    Timer timer;
    int xVelocity = 2;
    int yVelocity = 3;
    int x = 0;
    int y = 0;

    /*
     * Constructor
     * This panel set size, background color and initialize image and timer
     * that are going to be used as a particle image and delay time
     */
    ParticleMovingAnimation() {
        this.setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
        this.setBackground(Color.BLACK);
        particle = new ImageIcon(
                "/Users/htoomyataung/Desktop/Javaproject/GUI Project/FirstGUISwing/src/PaintingProjects/particle.png")
                .getImage();
        backgroundImage = new ImageIcon(
                "/Users/htoomyataung/Desktop/Javaproject/GUI Project/FirstGUISwing/src/PaintingProjects/earth.jpeg")
                .getImage();
        timer = new Timer(30, this);
        timer.start();
    }

    public static void main(String[] args) {
        JFrame window = new JFrame("Particle Moving Animation");
        ParticleMovingAnimation panel = new ParticleMovingAnimation();
        window.setContentPane(panel);
        window.pack();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLocationRelativeTo(null);
        window.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (x >= PANEL_WIDTH - particle.getWidth(null) || x < 0) {
            xVelocity = xVelocity * -1;
        }
        x = x + xVelocity;

        if (y >= PANEL_WIDTH - particle.getWidth(null) || y < 0) {
            yVelocity = yVelocity * -1;
        }
        y = y + yVelocity;

        repaint(); // This allow me to do animiation
    }

    public void drawImage(Graphics g) {
        Graphics2D g2D = (Graphics2D) g;
        g2D.drawImage(particle, x, y, null);

    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawImage(g);

    }

}