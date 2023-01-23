import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SimpleMouseListenerProject {
    static JLabel label;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Mouse Listener Project");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.setLocation(400, 100);
        frame.setVisible(true);

        JPanel panel = new JPanel();
        panel.setBackground(Color.LIGHT_GRAY);
        MouseHandler handler = new MouseHandler();
        panel.addMouseListener(handler);
        panel.addMouseMotionListener(handler);

        label = new JLabel("Nothing is done yet");
        panel.add(label);
        frame.add(panel);
    }

    private static class MouseHandler implements MouseListener, MouseMotionListener {

        public void mouseClicked(MouseEvent e) {
            label.setText("Mouse is clicked at " + e.getX() + " and " + e.getY());
        }

        public void mousePressed(MouseEvent e) {
            label.setText("Mouse is pressed down");
        }

        public void mouseReleased(MouseEvent e) {
            label.setText("Mouse is now released");
        }

        public void mouseExited(MouseEvent e) {
            label.setText("The mouse is left the window");
        }

        public void mouseEntered(MouseEvent e) {
            label.setText("The mouse enters the window");
        }

        public void mouseDragged(MouseEvent e) {
            label.setText("You are dragging the mouse");
        }

        @Override
        public void mouseMoved(MouseEvent e) {
            label.setText("You are moving the mouse");

        }
    }

}