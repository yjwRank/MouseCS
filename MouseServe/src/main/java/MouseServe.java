import mouse.test.MJFrame;
import mouse.test.MouseFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.AWTEventListener;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import static java.awt.GraphicsDevice.WindowTranslucency.TRANSLUCENT;

/**
 * Created by yjw on 17-4-28.
 */
public class MouseServe {
    public static void main(String[] args) throws IOException {
        ServerSocket server=new ServerSocket(20006);
        Socket client=null;
        boolean f=true;
        while(f){
            client=server.accept();
            System.out.println("connect to cli");
            //MouseFrame m=new MouseFrame("test",10000,100,-50,-50,0.5f);

            new Thread(new ServerThread(client)).start();
        }
    }
    public static void main2(String[] args){
        Point mousepoint=null;
        Point old=null;
        while(true){
            mousepoint=MouseInfo.getPointerInfo().getLocation();
            if(mousepoint!=null){
                if(old!=null && (mousepoint.x!=old.x&&mousepoint.y!=old.y)){
                    System.out.println("loc (x,y)=>("+mousepoint.x+","+mousepoint.y+")");
                }
                old=mousepoint;
            }else{
                System.out.println("error");
            }
        }
    }


    public static void main1(String[] args) {
        Toolkit.getDefaultToolkit().addAWTEventListener(
                new Listener(), AWTEvent.MOUSE_EVENT_MASK | AWTEvent.FOCUS_EVENT_MASK);
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    private static class Listener implements AWTEventListener {
        public void eventDispatched(AWTEvent event) {
            System.out.print(MouseInfo.getPointerInfo().getLocation() + " | ");
            System.out.println(event);
        }
    }
}
