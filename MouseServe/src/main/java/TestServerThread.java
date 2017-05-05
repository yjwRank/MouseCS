import mouse.test.MouseEventList;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

/**
 * Created by yjw on 17-5-5.
 */
public class TestServerThread implements Runnable {

    private Socket client=null;
    private MouseEventList list=null;
    private int locx=0;
    private int locy=0;
    private int width=0;
    private int height=0;

    public TestServerThread(Socket client,MouseEventList list,int locx,int locy,int width,int height){
        this.client=client;
        this.list=list;
        this.locx=locx;
        this.locy=locy;
        this.width=width;
        this.height=height;
    }

    @Override
    public void run() {
        try {
            PrintStream out=new PrintStream(client.getOutputStream());
            BufferedReader buf=new BufferedReader(new InputStreamReader(client.getInputStream()));
            boolean flag=true;
            System.out.println(buf.readLine());
            out.println(width);
            out.println(height);
            int prex=0;
            int prey=0;
            int preAction=-1;
            while(flag) {
                   /* String str=buf.readLine();
                    if(str==null||"".equals(str)){
                        flag=false;
                    }else{
                        int locx=MouseInfo.getPointerInfo().getLocation().x;
                        int locy=MouseInfo.getPointerInfo().getLocation().y;
                        out.println(locx);
                        out.println(locy);

                    }*/
                int action=list.getLastMotion();
                int locx = MouseInfo.getPointerInfo().getLocation().x;
                int locy = MouseInfo.getPointerInfo().getLocation().y;
                if (locx != prex && locy != prey) {
                    out.println(locx);
                    out.println(locy);
                    //  this.frame.stop();
                    prex = locx;
                    prey = locy;
                } else {
                    ;
                }
            }
            out.close();
            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

}}
