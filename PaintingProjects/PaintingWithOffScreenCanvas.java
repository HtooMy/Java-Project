package PaintingProjects;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class PaintingWithOffScreenCanvas extends JPanel {

    private static class drawingData {
        Color color; // Color of the drawubg
        ArrayList<Point> points; // The points on the line
    }

    private Color currentColor;
    private ArrayList<drawingData> curves; // A list of all lines in the picture

    /*
     * Constructor
     * Sets background color white, adds a black border, sets up a mouse
     * listener for mouse and mouse motion events, and sets the preferrenced
     * size of the panel to be 700 and 500
     */
    PaintingWithOffScreenCanvas() {
        curves = new ArrayList<drawingData>();
        setBackground(Color.WHITE);
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
        setPreferredSize(new Dimension(700, 500));
        MouseHandler listener = new MouseHandler();
        addMouseListener(listener);
        addMouseMotionListener(listener);
    }

    public static void main(String[] args) {
        JFrame window = new JFrame("My painting project");
        PaintingWithOffScreenCanvas content = new PaintingWithOffScreenCanvas();
        window.setContentPane(content);
        window.setJMenuBar(content.createJMenuBar());
        window.pack();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLocation(500, 200);
        window.setVisible(true);
    }

    // Creates a JMenuBar for the use of panel. It contains four menus: Control,
    // Color
    // Background color and Tool
    public JMenuBar createJMenuBar() {
        JMenuBar menubar = new JMenuBar();
        JMenu controlMenu = new JMenu("Control");
        JMenu colorMenu = new JMenu("Color");
        JMenu bgColorMenu = new JMenu("Background color");
        JMenu toolMenu = new JMenu("Tool");
        menubar.add(controlMenu);
        menubar.add(colorMenu);
        menubar.add(bgColorMenu);
        menubar.add(toolMenu);

        JMenuItem undo = new JMenuItem("Undo");
        controlMenu.add(undo);
        undo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (curves.size() > 0) {
                    curves.remove(curves.size() - 1);
                    repaint();
                }
            }
        });

        JMenuItem clear = new JMenuItem("Clear All");
        controlMenu.add(clear);
        clear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                curves = new ArrayList<>();
                repaint();
            }
        });

        JMenuItem curve = new JMenuItem("Curve");
        toolMenu.add(curve);
        curve.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });

        JMenuItem line = new JMenuItem("Line");
        toolMenu.add(line);
        line.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });

        JMenuItem rectangle = new JMenuItem("Rectangle");
        toolMenu.add(rectangle);
        rectangle.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });

        JMenuItem oval = new JMenuItem("Oval");
        toolMenu.add(oval);
        oval.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });

        JMenuItem fillRectangle = new JMenuItem("Fill Rectangle");
        toolMenu.add(fillRectangle);
        fillRectangle.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });

        JMenuItem fillOval = new JMenuItem("Fill Oval");
        toolMenu.add(fillOval);
        fillOval.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });

        JMenuItem erase = new JMenuItem("Erase");
        toolMenu.add(erase);
        erase.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });

        colorMenu.add(makeColorMenuItem("Black", Color.BLACK));
        colorMenu.add(makeColorMenuItem("Yellow", Color.YELLOW));
        colorMenu.add(makeColorMenuItem("Red", Color.RED));
        colorMenu.add(makeColorMenuItem("White", Color.WHITE));
        colorMenu.add(makeColorMenuItem("Blue", Color.BLUE));
        colorMenu.add(makeColorMenuItem("Green", Color.GREEN));
        colorMenu.add(makeColorMenuItem("Cyan", Color.CYAN));
        colorMenu.add(makeColorMenuItem("Magenta", Color.MAGENTA));
        colorMenu.add(makeColorMenuItem("Gray", Color.GRAY));

        bgColorMenu.add(makeBgColorMenuItem("Black", Color.BLACK));
        bgColorMenu.add(makeBgColorMenuItem("White", Color.WHITE));
        bgColorMenu.add(makeBgColorMenuItem("Red", Color.RED));
        bgColorMenu.add(makeBgColorMenuItem("Green", Color.GREEN));
        bgColorMenu.add(makeBgColorMenuItem("Blue", Color.BLUE));
        bgColorMenu.add(makeBgColorMenuItem("Cyan", Color.CYAN));
        bgColorMenu.add(makeBgColorMenuItem("Magenta", Color.MAGENTA));
        bgColorMenu.add(makeBgColorMenuItem("Yellow", Color.YELLOW));

        return menubar;
    }

    // This method would create a menu item which is a color whenever it is called
    // This method includes an action listener which would change the current color
    // of line
    private JMenuItem makeColorMenuItem(String command, final Color color) {
        JMenuItem item = new JMenuItem(command);
        item.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                currentColor = color;
            }
        });
        return item;
    }

    // This method would create a menu item which is a background color whenever it
    // is called
    // This method includes an action listener which would change the bg color
    private JMenuItem makeBgColorMenuItem(String command, final Color color) {
        JMenuItem item = new JMenuItem(command);
        item.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setBackground(color);
            }
        });
        return item;
    }

    /**
     * Fills the panel with the current background color and draws all the
     * curves that have been sketched by the user. (Antialiasing is
     * turned on to make the lines look nicer.)
     */
    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        for (drawingData curve : curves) {
            g.setColor(curve.color);
            for (int i = 1; i < curve.points.size(); i++) {
                int x1 = curve.points.get(i - 1).x;
                int y1 = curve.points.get(i - 1).y;
                int x2 = curve.points.get(i).x;
                int y2 = curve.points.get(i).y;
                g.drawLine(x1, y1, x2, y2);
            }
        }
    }

    /**
     * This class defines the object that is used as a mouse listener and mouse
     * motion listener on this panel. When the user presses the mouse, a new
     * CurveData object is created and is added to the ArrayList, curves. The
     * color of the curve is copied from currentColor, and the symmetric property
     * of the curve is copied from useSymmetry. As the user drags the mouse, points
     * are added to the curve. If the user doesn't move the mouse, there will only
     * be one point in the list of points; since this is not really a curve, the
     * CurveData object is removed in this case from the curves list. This is
     * done in the mouseReleased method.
     */
    private class MouseHandler implements MouseListener, MouseMotionListener {
        drawingData currentCurve;
        boolean dragging;

        public void mousePressed(MouseEvent e) {
            if (dragging) {
                return;
            }
            dragging = true;
            currentCurve = new drawingData();
            currentCurve.color = currentColor;
            currentCurve.points = new ArrayList<>();
            currentCurve.points.add(new Point(e.getX(), e.getY()));
            curves.add(currentCurve);
        }

        public void mouseDragged(MouseEvent e) {
            if (!dragging) {
                return;
            }
            currentCurve.points.add(new Point(e.getX(), e.getY()));
            repaint();

        }

        public void mouseReleased(MouseEvent e) {
            if (!dragging) {
                return;
            }
            dragging = false;
            if (currentCurve.points.size() < 2) {
                curves.remove(currentCurve);
            }
            currentCurve = null;

        }

        public void mouseClicked(MouseEvent e) {

        }

        public void mouseEntered(MouseEvent e) {

        }

        public void mouseExited(MouseEvent e) {

        }

        public void mouseMoved(MouseEvent e) {

        }
    }

}