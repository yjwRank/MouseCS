package mouse.test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import static java.awt.GraphicsDevice.WindowTranslucency.TRANSLUCENT;

/**
 * Created by yjw on 17-4-28.
 */
public class Test_Mouse6 extends JFrame implements MouseMotionListener,MouseListener {
    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("mouse click");
    }

    @Override
    public void mousePressed(MouseEvent e) {
        System.out.println("mouse press");
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


    public Test_Mouse6(){
        super("TranslucentWindows");
       /* setLayout(new GridBagLayout());
        setSize(300,200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Add a sample button.
        addMouseListener(this);
        addMouseMotionListener(this);
        add(new JButton("I am a Button"));*/
    }


    public static void main(String[] args){
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
                /*Test_Mouse5 tw = new Test_Mouse5();
                // Set the window to 55% opaque (45% translucent).
                tw.setOpacity(0.0f);

                // Display the window.
                tw.setVisible(true);*/
                JFrame jFrame=new JFrame("test");
                jFrame.setSize(100,100);
                Test_Mouse6 t=new Test_Mouse6();
                jFrame.addMouseListener(t);
                jFrame.addMouseMotionListener(t);
                jFrame.setLocation(100,100);
                jFrame.setOpacity(0.3f);
                jFrame.setVisible(true);
                jFrame.setAlwaysOnTop(true);
            }
        });
    }

}
