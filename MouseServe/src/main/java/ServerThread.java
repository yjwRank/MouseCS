import mouse.test.MJFrame;
import mouse.test.MouseFrame;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

/**
 * Created by yjw on 17-4-28.
 */
public class ServerThread implements Runnable {

    private Socket client=null;
    private MJFrame frame=null;
    private MouseFrame mouseFrame=null;

    public ServerThread(Socket client,MJFrame frame){
        this.client=client;
        this.frame=frame;
        System.out.println("test");
    }

    public ServerThread(Socket client,MouseFrame mouseFrame){
        this.mouseFrame=mouseFrame;
    }

    public ServerThread(Socket client){
        this.client=client;
    }

    @Override
    public void run() {

            try {
                PrintStream out=new PrintStream(client.getOutputStream());
                BufferedReader buf=new BufferedReader(new InputStreamReader(client.getInputStream()));
                boolean flag=true;
                mouseFrame=new MouseFrame("test");
                mouseFrame.build();
                int windowsWidth=0;
                int windowsHeight=0;
                System.out.println(buf.readLine());
                out.println(String.valueOf(windowsWidth));
                out.println(String.valueOf(windowsHeight));
                int prex=0;
                int prey=0;
                while(flag){
                   /* String str=buf.readLine();
                    if(str==null||"".equals(str)){
                        flag=false;
                    }else{
                        int locx=MouseInfo.getPointerInfo().getLocation().x;
                        int locy=MouseInfo.getPointerInfo().getLocation().y;
                        out.println(locx);
                        out.println(locy);

                    }*/
                    int locx=MouseInfo.getPointerInfo().getLocation().x;
                    int locy=MouseInfo.getPointerInfo().getLocation().y;
                    if(locx!=prex&&locy!=prey) {
                        out.println(locx);
                        out.println(locy);
                      //  this.frame.stop();
                        mouseFrame.stop();
                        prex=locx;
                        prey=locy;
                    }else{
                        ;
                    }
                }

                out.close();
                client.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

    }
}
