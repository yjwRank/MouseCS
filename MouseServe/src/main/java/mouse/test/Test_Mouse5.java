package mouse.test;

/**
 * Created by yjw on 17-4-28.
 */
import java.awt.*;
import javax.swing.*;
import static java.awt.GraphicsDevice.WindowTranslucency.*;

public class Test_Mouse5 extends JFrame {
    public Test_Mouse5() {
        super("TranslucentWindow");
        setLayout(new GridBagLayout());

        setSize(300,200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Add a sample button.
        add(new JButton("I am a Button"));
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
                Test_Mouse5 tw = new Test_Mouse5();

                // Set the window to 55% opaque (45% translucent).
                tw.setOpacity(0.0f);

                // Display the window.
                tw.setVisible(true);
            }
        });
    }
}