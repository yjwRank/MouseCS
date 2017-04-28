package mouse.test;

import javax.swing.*;
import java.awt.*;

import static java.awt.GraphicsDevice.WindowTranslucency.TRANSLUCENT;

/**
 * Created by yjw on 17-4-28.
 */
public class MouseFrame {
    private JFrame jFrame=null;
    private int width=100;
    private int height=100;
    private int loc_x=0;
    private int loc_y=0;
    private float opacity=0.5f;
    private String id=null;
    public MouseFrame(String id,int width,int height,int loc_x,int loc_y,float opacity){
        this.id=id;
        this.width=width;
        this.height=height;
        this.loc_x=loc_x;
        this.loc_y=loc_y;
        this.opacity=opacity;
    }

    public boolean build() {
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
                jFrame = new JFrame(id);
                jFrame.setSize(width, height);
                MouseEventList t = new MouseEventList();
                jFrame.addMouseListener(t);
                jFrame.addMouseMotionListener(t);
                jFrame.setLocation(loc_x, loc_y);
                jFrame.setOpacity(opacity);
                jFrame.setVisible(true);
               // jFrame.setAlwaysOnTop(true);
            }
        });
            return true;
        }

        public void stop(){
            jFrame.dispose();
            jFrame.setVisible(false);
        }


        public static void main(String[] args){
            MouseFrame m=new MouseFrame("test",10000,100,-50,-50,0.5f);
            m.build();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
         //   m.stop();
        }


    }
