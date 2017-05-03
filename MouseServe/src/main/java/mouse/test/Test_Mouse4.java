package mouse.test;

import java.io.*;

/**
 * Created by yjw on 17-4-28.
 */
public class Test_Mouse4 {
    public static void main1(String[] args) throws IOException {
        BufferedInputStream in=new BufferedInputStream(new FileInputStream("/dev/input/mice"));
        while(true){
            int input=in.read();
            if(input!=-1)
                System.out.println(""+input);
            else
                break;
        }


    }

    public static void main(String[] args) throws IOException {
        File file=new File("/dev/input/mice");
        InputStream in=null;
        byte[] tempbytes=new byte[3];
        int bythread=0;
        in=new FileInputStream("/dev/input/mice");
        while((bythread=in.read(tempbytes))!=-1){
            //System.out.println((Integer.valueOf(tempbytes[0])&0x1F)+" "+String.valueOf(tempbytes[1])+" "+String.valueOf(tempbytes[2]));
            System.out.println("left:"+(tempbytes[0]&0x01)+" right:"+(tempbytes[0]&0x02)+" mid:"+(tempbytes[0]&0x04));
        }
    }
}
