import mouse.test.MouseEventList;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import static java.awt.GraphicsDevice.WindowTranslucency.TRANSLUCENT;

/**
 * Created by yjw on 17-5-5.
 */
public class TestMouseServe  {
    private JFrame jFrame=null;
    private float opacity=0.5f;
    private String id=null;
    private MouseEventList t=null;
    public TestMouseServe(String id){
        this.id=id;
    }
    public MouseEventList getMouseEventList(){return t;}
    public boolean build() {
        GraphicsEnvironment ge =
                GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice gd = ge.getDefaultScreenDevice();



        final Rectangle bounds = ge.getMaximumWindowBounds();
        System.out.println("Screen Bounds: " + bounds );
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
                jFrame = new JFrame(id);
                //jFrame.setSize(width, height);
                 t = new MouseEventList();
                jFrame.addMouseListener(t);
                jFrame.addMouseMotionListener(t);
                //   jFrame.setLocation(loc_x, loc_y);
                jFrame.setOpacity(opacity);
                jFrame.setLocation((int)bounds.getX(),(int)bounds.getY());
                jFrame.setVisible(true);
                jFrame.setSize((int)bounds.getWidth(),(int)bounds.getHeight());

            }
        });


        try {
            ServerSocket server=new ServerSocket(20006);
            Socket client=null;
            boolean f=true;
            while(f){
                client=server.accept();
                System.out.println("connect cli");
                new Thread(new TestServerThread(client,getMouseEventList(),jFrame.getLocation().x,jFrame.getLocation().y,jFrame.getWidth(),jFrame.getHeight())).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return true;
    }

    public void stop(){
        jFrame.dispose();
        jFrame.setVisible(false);
    }

    public static void main(String[] args){
        TestMouseServe m=new TestMouseServe("test");
        m.build();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(m.getMouseEventList().getLastMotion());
        m.stop();
    }
}
