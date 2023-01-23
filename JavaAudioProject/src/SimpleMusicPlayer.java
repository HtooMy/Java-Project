import java.io.File;
import java.io.IOException;
import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SimpleMusicPlayer extends JPanel {
    static JButton button1; // Play button
    static JButton button2; // Stop button
    static JButton button3; // Restart button
    static JButton button4; // Quit button
    static Image bgImage;

    /* Constructor */
    SimpleMusicPlayer() {
        setPreferredSize(new Dimension(700, 450));
        add(button1);
        add(button2);
        add(button3);
        add(button4);
    }

    /* Painting background image */
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        bgImage = new ImageIcon("/Users/htoomyataung/Desktop/JavaAudioProject/src/Image/music.png").getImage();
        Graphics2D g2D = (Graphics2D) g;
        g2D.drawImage(bgImage, 1, 1, null);
    }

    /* Main method */
    public static void main(String[] args) throws LineUnavailableException, IOException, UnsupportedAudioFileException {
        File file = new File("/Users/htoomyataung/Desktop/JavaAudioProject/src/sounds/PopMusic.wav");
        AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
        Clip clip = AudioSystem.getClip();
        clip.open(audioStream);

        button1 = new JButton("Play");
        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                clip.start();
            }
        });

        button2 = new JButton("Stop");
        button2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                clip.stop();
            }
        });

        button3 = new JButton("Restart");
        button3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                clip.start();
                clip.setMicrosecondPosition(0);
            }
        });

        button4 = new JButton("Quit");
        button4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        JFrame window = new JFrame("Simple Music Player");
        SimpleMusicPlayer panel = new SimpleMusicPlayer();
        window.setContentPane(panel);
        window.pack();
        window.setLocation(500, 100);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
        window.setResizable(false);
    }
}
