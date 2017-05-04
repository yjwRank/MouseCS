package mouse.test;

import java.awt.*;
import java.awt.event.InputEvent;
import java.io.*;

/**
 * Created by yjw on 17-5-4.
 */
public class Test_MouseMove implements Runnable {
    @Override
    public void run() {
        File file=new File("/dev/input/mice");
        InputStream in=null;
        byte[] tempbytes=new byte[3];
        int bythread=0;
        Dimension dim=Toolkit.getDefaultToolkit().getScreenSize();
        try {
            in=new FileInputStream("/dev/input/mice");
            while((bythread=in.read(tempbytes))!=-1){
                if((this.x+Integer.valueOf(tempbytes[1]))>=0&&(this.x+Integer.valueOf(tempbytes[1]))<=(int)dim.getWidth())
                    this.x=this.x+Integer.valueOf(tempbytes[1]);
                if((this.y+Integer.valueOf(tempbytes[2]))>=0&&(this.y+Integer.valueOf(tempbytes[2]))<=(int)dim.getHeight())
                    this.y=this.y- Integer.valueOf(tempbytes[2]);
                System.out.println("x:"+x+"  y:"+y+"  rx:"+MouseInfo.getPointerInfo().getLocation().x+" ry:"+MouseInfo.getPointerInfo().getLocation().y);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Test_MouseMove(){
        this.x= MouseInfo.getPointerInfo().getLocation().x;
        this.y=MouseInfo.getPointerInfo().getLocation().y;
        System.out.println(this.x+" "+this.y);
    }


    private Thread t=null;
    private int x=0;
    private int y=0;


    public static void main(String[] args){
      //  Test_MouseMove test=new Test_MouseMove();
       Thread te=new Thread(new Test_MouseMove());
        te.start();

    }
}
