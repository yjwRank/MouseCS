import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

/**
 * Created by yjw on 17-4-28.
 */
public class MouseCli {
    public static void main(String[] args){
        try {
            Socket client=new Socket("127.0.0.1",20006);
            client.setSoTimeout(10000);
            BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
            PrintStream out=new PrintStream(client.getOutputStream());
            BufferedReader buf=new BufferedReader(new InputStreamReader(client.getInputStream()));
            boolean flag=true;
            while(flag){
                System.out.println(">>");
                String str=input.readLine();
                out.println(str);
                if("bye".equals(str)){
                    flag=false;
                }else{
                    String echo = buf.readLine();
                    System.out.println(echo);
                }
            }

            input.close();
            if(client!=null){
                client.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

        }
    }
}
