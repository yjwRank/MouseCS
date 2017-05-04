import java.awt.*;
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
                int rx=(int)(xdim*Integer.valueOf(locx));
                int ry=(int)(ydim*Integer.valueOf(locy));
                System.out.println("x:"+rx+" y:"+ry);
                robot.mouseMove(rx,ry);
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
