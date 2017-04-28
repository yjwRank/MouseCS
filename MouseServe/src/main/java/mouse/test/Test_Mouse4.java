package mouse.test;

import java.io.*;

/**
 * Created by yjw on 17-4-28.
 */
public class Test_Mouse4 {
    public static void main(String[] args) throws IOException {
        BufferedInputStream in=new BufferedInputStream(new FileInputStream("/dev/input/mouse0"));
        while(true){
            int input=in.read();
            if(input!=-1)
                System.out.println(""+input);
            else
                break;
        }


    }
}
