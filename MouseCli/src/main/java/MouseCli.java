import mouse.event.Constants;

import java.awt.*;
import java.awt.event.InputEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.InterfaceAddress;
import java.net.Socket;

/**
 * Created by yjw on 17-4-28.
 */
public class MouseCli {
    public static void main(String[] args){
        try {
            Socket client=new Socket("10.1.10.68",20006);
            client.setSoTimeout(10000);
            BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
            PrintStream out=new PrintStream(client.getOutputStream());
            BufferedReader buf=new BufferedReader(new InputStreamReader(client.getInputStream()));
            boolean flag=true;
            out.println("begin");
            String x=buf.readLine();
            String y=buf.readLine();
            System.out.println(x+" "+y);

            //get local screen size
            Dimension dim= Toolkit.getDefaultToolkit().getScreenSize();
            double xdim=dim.width/Double.valueOf(x);
            double ydim=dim.height/Double.valueOf(y);
            System.out.println(dim.width+","+dim.height+"  "+xdim+","+ydim);
            Robot robot=new Robot();
            while(flag){
                System.out.println(">>");
               /* String str=input.readLine();
                out.println(str);
                if("bye".equals(str)){
                    flag=false;
                }else{
                    String locx = buf.readLine();
                    String locy = buf.readLine();
                    int rx=(int)(xdim*Integer.valueOf(locx));
                    int ry=(int)(ydim*Integer.valueOf(locy));
                    System.out.println("x:"+rx+" y:"+ry);
                }*/
                String locx = buf.readLine();
                String locy = buf.readLine();
                String action =buf.readLine();
                int rx=(int)(xdim*Integer.valueOf(locx));
                int ry=(int)(ydim*Integer.valueOf(locy));
                System.out.println("x:"+rx+" y:"+ry);
                robot.mouseMove(rx,ry);

                switch(Integer.valueOf(action)){
                    case Constants.MOUSE_PRESS_LEFT:
                        robot.mousePress(InputEvent.BUTTON1_MASK);
                        System.out.println("left press");
                        break;
                    case Constants.MOUSE_PRESS_MID:
                        robot.mousePress(InputEvent.BUTTON2_MASK);
                        System.out.println("mid press");break;
                    case Constants.MOUSE_PRESS_RIGHT:
                        robot.mousePress(InputEvent.BUTTON3_MASK);
                        System.out.println("right press");
                        break;
                    case Constants.MOUSE_RELEASE_LEFT:
                        robot.mouseRelease(InputEvent.BUTTON1_MASK);
                        System.out.println("left release");
                        break;
                    case Constants.MOUSE_RELEASE_MID:
                        robot.mouseRelease(InputEvent.BUTTON2_MASK);
                        System.out.println("mid release");
                        break;
                    case Constants.MOUSE_RELEASE_RIGHT:
                        robot.mouseRelease(InputEvent.BUTTON3_MASK);
                        System.out.println("right release");
                        break;
                    default:
                        System.out.println("unsupport");
                        break;
                }
            }

            input.close();
            if(client!=null){
                client.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (AWTException e) {
            e.printStackTrace();
        } finally {

        }
    }
}
