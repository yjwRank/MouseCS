package mouse.test;

import java.awt.*;
import java.io.*;

/**
 * Created by yjw on 17-4-28.
 */
public class Test_Mouse4 {
    public static void main1(String[] args) throws IOException {
        BufferedInputStream in=new BufferedInputStream(new FileInputStream("/dev/input/event4"));
        int pre=0;
        while(true){
            int input=in.read();
            if(input!=-1)
                if(pre!=input) {
                    System.out.println("" + input);
                    pre=input;
                }else{
                    ;
                }
            else
                break;
        }


    }

    public static void main2(String[] args) throws IOException {
        File file=new File("/dev/input/mice");
        InputStream in=null;
        byte[] tempbytes=new byte[3];
        int bythread=0;
        in=new FileInputStream("/dev/input/mice");
        while((bythread=in.read(tempbytes))!=-1){
            //System.out.println((tempbytes[0]&0xFF)+" "+String.valueOf(tempbytes[1])+" "+String.valueOf(tempbytes[2]));
            System.out.println("1:"+(tempbytes[0]&0x01)+"   2:"+(tempbytes[0]&0x02)+"   3:"+(tempbytes[0]&0x04)+"   4:"+(tempbytes[0]&0x0A)+
            "   5:"+(tempbytes[0]&0x10)+"   6:"+(tempbytes[0]&0x20)+"   7:"+(tempbytes[0]&40)+"   8:"+(tempbytes[0]&0xA0));
            //System.out.println("left:"+(tempbytes[0]&0x01)+" right:"+(tempbytes[0]&0x02)+" mid:"+(tempbytes[0]&0x04));
        }
    }

    public static void main(String[] agrs) throws IOException, AWTException {
        InputStream in=null;
        byte[] tempbytes=new byte[3];
        int bythread=0;
        in=new FileInputStream("/dev/input/event4");
        while((bythread=in.read(tempbytes))!=-1){
            System.out.println(tempbytes[0]+" "+tempbytes[1]+" "+tempbytes[2]);
        }



    }
}
