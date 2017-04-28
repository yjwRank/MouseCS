import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

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
            new Thread(new ServerThread(client)).start();
        }
    }
}
