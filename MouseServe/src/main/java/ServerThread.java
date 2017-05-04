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

    public ServerThread(Socket client){
        this.client=client;
    }

    @Override
    public void run() {

            try {
                PrintStream out=new PrintStream(client.getOutputStream());
                BufferedReader buf=new BufferedReader(new InputStreamReader(client.getInputStream()));
                boolean flag=true;
                Dimension dim=Toolkit.getDefaultToolkit().getScreenSize();
                String screen=dim.width+","+dim.height;
                System.out.println(buf.readLine());
                out.println(String.valueOf(dim.width));
                out.println(String.valueOf(dim.height));
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
                    out.println(locx);
                    out.println(locy);
                }

                out.close();
                client.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

    }
}
