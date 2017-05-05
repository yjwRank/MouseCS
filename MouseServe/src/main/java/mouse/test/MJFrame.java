package mouse.test;

/**
 * Created by yjw on 17-4-28.
 */
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.*;
import static java.awt.GraphicsDevice.WindowTranslucency.*;

public class MJFrame extends JFrame implements MouseMotionListener,MouseListener {
    public MJFrame() {
        super("TranslucentWindow");
        setLayout(new GridBagLayout());

        // setSize(1999,1999);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Add a sample button.
        addMouseListener(this);
        addMouseMotionListener(this);
       // setExtendedState(JFrame.MAXIMIZED_BOTH);
        //System.out.println(getMaximumSize());
        GraphicsEnvironment ge =
                GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice gd = ge.getDefaultScreenDevice();

        Rectangle bounds = ge.getMaximumWindowBounds();
        setLocation((int)bounds.getX(),(int)bounds.getY());
        setSize((int)bounds.getWidth(),(int)bounds.getHeight());
        //setOpacity(0.5f);
        setVisible(true);
        // Create the GUI on the event-dispatching thread

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("mouse click");
    }

    @Override
    public void mousePressed(MouseEvent e) {

        System.out.println("button:"+e.getButton()+" mouse press");
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        System.out.println("mouse release");
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        System.out.println("mouse enter");
    }

    @Override
    public void mouseExited(MouseEvent e) {
        System.out.println("mouse exit");
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        System.out.println("mouse drage");
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        System.out.println("mouse move:"+e.getX()+","+e.getY());
    }

    public static void main(String[] args) {
        // Determine if the GraphicsDevice supports translucency.
        GraphicsEnvironment ge =
                GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice gd = ge.getDefaultScreenDevice();

        //If translucent windows aren't supported, exit.
        if (!gd.isWindowTranslucencySupported(TRANSLUCENT)) {
            System.err.println(
                    "Translucency is not supported");
            System.exit(0);
        }

        JFrame.setDefaultLookAndFeelDecorated(true);

        // Create the GUI on the event-dispatching thread
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                MJFrame tw = new MJFrame();

                // Set the window to 55% opaque (45% translucent).
                tw.setOpacity(0.5f);

                // Display the window.
                tw.setVisible(true);
                System.out.println("hh:"+tw.getContentPane().getSize());

            }
        });
    }
}