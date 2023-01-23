package PaintingProjects;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.awt.event.*;

public class SimplePainting extends JPanel {

    // Constructor
    /**
     * Constructor. Sets background color to white, adds a gray border, sets up
     * a listener for mouse and mouse motion events, and sets the preferred size
     * of the panel to be 500-by-500.
     */
    public SimplePainting() {
        curves = new ArrayList<CurveData>();
        setBackground(Color.WHITE);
        setBorder(BorderFactory.createLineBorder(Color.GRAY, 3));
        MouseHandler listener = new MouseHandler();
        addMouseListener(listener);
        addMouseMotionListener(listener);
        setPreferredSize(new Dimension(500, 500));
    }

    public static void main(String[] args) {
        JFrame window = new JFrame("Painting");
        SimplePainting content = new SimplePainting();
        window.setContentPane(content);
        window.setJMenuBar(content.createMenuBar());
        window.pack();
        window.setLocation(100, 100);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
    }

    /*
     * An object of type CurveData represents the data required to redraw one
     * of the curces that have been sketched by the user
     */
    private static class CurveData {
        Color color; // The color of the curve.
        boolean symmetric; // Are horizontal and vertical reflections also drawn?
        ArrayList<Point> points; // The points on the curve.
    }

    private ArrayList<CurveData> curves; // A list of all curves in the picture.

    private Color currentColor; // When a curve is created, its color is taken
                                // from this variable. The value is changed
                                // using commands in the "Color" menu.

    private boolean useSymmetry;

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
        CurveData currentCurve;
        boolean dragging;

        public void mousePressed(MouseEvent e) {
            if (dragging) {
                return;
            }
            dragging = true;
            currentCurve = new CurveData();
            currentCurve.color = currentColor;
            currentCurve.points = new ArrayList<Point>();
            currentCurve.points.add(new Point(e.getX(), e.getY()));
            curves.add(currentCurve);
        }

        public void mouseDragged(MouseEvent e) {
            if (!dragging) {
                return;
            }
            currentCurve.points.add(new Point(e.getX(), e.getY()));
            repaint(); // Redraw panel with newly added point
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

    /**
     * Fills the panel with the current background color and draws all the
     * curves that have been sketched by the user. (Antialiasing is
     * turned on to make the lines look nicer.)
     */
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        for (CurveData curve : curves) {
            g.setColor(curve.color);
            for (int i = 1; i < curve.points.size(); i++) {
                // Draw a line segment from point number i-1 to point number i.
                int x1 = curve.points.get(i - 1).x;
                int y1 = curve.points.get(i - 1).y;
                int x2 = curve.points.get(i).x;
                int y2 = curve.points.get(i).y;
                g.drawLine(x1, y1, x2, y2);
            }
        }
    }

    /**
     * Creates a menu bar for use with this panel. It contains
     * three menus: "Control", "Color", and "BackgroundColor".
     */
    public JMenuBar createMenuBar() {
        // Menu bar creating
        JMenuBar menuBar = new JMenuBar();

        // Menu creating
        JMenu contorlMennu = new JMenu("Control");
        JMenu colorMennu = new JMenu("Color");
        JMenu bgColorMenu = new JMenu("Background color");

        // Adding menu into menu bar
        menuBar.add(contorlMennu);
        menuBar.add(colorMennu);
        menuBar.add(bgColorMenu);

        /*
         * Add commands to the "Control" menu. It contains an Undo
         * command that will remove the most recently drawn curve
         * from the list of curves; a "Clear" command that removes
         * all the curves that have been drawn; and a "Use Symmetry"
         * checkbox that determines whether symmetry should be used.
         */
        JMenuItem undo = new JMenuItem("Undo");
        contorlMennu.add(undo);
        undo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (curves.size() > 0) {
                    curves.remove(curves.size() - 1);
                    repaint(); // Redraw without the curve that has been removed.
                }
            }
        });

        JMenuItem clear = new JMenuItem("Clear");
        contorlMennu.add(clear);
        clear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                curves = new ArrayList<CurveData>();
                repaint(); // Redraw with no curves shown.
            }
        });

        colorMennu.add(makeColorMenuItem("Black", Color.BLACK));
        colorMennu.add(makeColorMenuItem("Yellow", Color.YELLOW));
        colorMennu.add(makeColorMenuItem("Red", Color.RED));
        colorMennu.add(makeColorMenuItem("White", Color.WHITE));
        colorMennu.add(makeColorMenuItem("Blue", Color.BLUE));
        colorMennu.add(makeColorMenuItem("Green", Color.GREEN));
        colorMennu.add(makeColorMenuItem("Gray", Color.GRAY));

        /*
         * 
         * Add commands to the "BackgroundColor" menu. The menu contains commands
         * for setting the background color of the panel. When the user chooses
         * one of these commands, the panel is immediately redrawn with the new
         * background color. Any curves that have been drawn are still there.
         */

        bgColorMenu.add(makeBgColorMenuItem("Black", Color.BLACK));
        bgColorMenu.add(makeBgColorMenuItem("White", Color.WHITE));
        bgColorMenu.add(makeBgColorMenuItem("Red", Color.RED));
        bgColorMenu.add(makeBgColorMenuItem("Green", Color.GREEN));
        bgColorMenu.add(makeBgColorMenuItem("Blue", Color.BLUE));
        bgColorMenu.add(makeBgColorMenuItem("Cyan", Color.CYAN));
        bgColorMenu.add(makeBgColorMenuItem("Magenta", Color.MAGENTA));
        bgColorMenu.add(makeBgColorMenuItem("Yellow", Color.YELLOW));
        return menuBar;
    }

    private JMenuItem makeBgColorMenuItem(String command, final Color color) {
        JMenuItem item = new JMenuItem(command);
        item.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                setBackground(color);
            }
        });
        return item;
    }

    private JMenuItem makeColorMenuItem(String command, final Color color) {
        JMenuItem item = new JMenuItem(command);
        item.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                currentColor = color;
            }
        });
        return item;
    }
}