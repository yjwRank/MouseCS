package mouse.test;

import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
/**
 * Created by yjw on 17-4-28.
 */
public class MouseControl {
    //get mouse pos
    public static void main1(String[] agrs){
        Point mousepoint=null;
        Point old=null;
        while(true){
            mousepoint=MouseInfo.getPointerInfo().getLocation();
            if(mousepoint!=null){
                if(old!=null && (mousepoint.x!=old.x&&mousepoint.y!=old.y)){
                    System.out.println("loc (x,y)=>("+mousepoint.x+","+mousepoint.y+")");
                }
                old=mousepoint;
            }else{
                System.out.println("error");
            }
        }
    }
    //mouse move
    public static void main2(String[] args){
        MouseControl mouseControl=new MouseControl();
        System.out.println("start");
        for(int i=0;i<10;i++){
            for(int j=0;j<10;j++){
                mouseControl.Move(1,1);
            }
        }
        System.out.println("stop");
    }

    public static void main7(String[] args){

    }
    public static void main4(String[] args){
        MouseControl mouseControl=new MouseControl();
        int r=50;
       /* for(int i=0;i<30;i++){
            int a=-Integer.valueOf((int)Math.sqrt(900-i*i));
            mouseControl.MoveToLoc(i,a);
        }
        for(int i=30;i>0;i++){
            int b=Integer.valueOf((int)Math.sqrt(900-i*i));
            mouseControl.MoveToLoc(i,b);
        }*/
        int height=Toolkit.getDefaultToolkit().getScreenSize().height;
        int width=Toolkit.getDefaultToolkit().getScreenSize().width;
       // while(true)
        mouseControl.MoveToLoc(width,height);
       /* while(true){
        for(int i=0;i<500;i++){
            mouseControl.Move(1,1);
        }
        for(int i=0;i<500;i++){
            mouseControl.Move(1,-1);
        }
        for(int i=0;i<500;i++){
            mouseControl.Move(-1,-1);
        }
        for(int i=0;i<500;i++){
            mouseControl.Move(-1,1);
        }
        }*/
    }


    //mouse action
    public static void main3(String[] args){
        MouseControl mouseControl=new MouseControl();
        mouseControl.MoveToLoc(34,704);
        mouseControl.leftClick();
    }

    //mouse move action
    public static void main(String[] agrs){
        MouseControl mouseControl=new MouseControl();
       mouseControl.rightClick();
       // mouseControl.leftClick();
    }


    private Dimension dim;//屏幕尺寸
    private Robot robot;

    public MouseControl(){
        dim=Toolkit.getDefaultToolkit().getScreenSize();
        System.out.println("screen size:"+dim.getWidth()+" "+dim.getHeight());
        try {
            robot=new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }

    public void rightClick(){
        ;
    }

    public void movetest(){

    }

    public void leftClick(){
        robot.mousePress(InputEvent.BUTTON1_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_MASK);
    }

    public void MoveToLoc(int x,int y){
        System.out.println("move to ("+x+","+y+")");
       // robot.delay(10);
        robot.mouseMove(x,y);
       // robot.delay(10000);
        //robot.delay(100);
    }

    public void Move(int width,int height){
        System.out.println("move");
        Point mousepoint=MouseInfo.getPointerInfo().getLocation();
        width+=mousepoint.x;
        height+=mousepoint.y;
        System.out.println("(x,y) from ("+mousepoint.x+","+mousepoint.y+")=>("+width+","+height+")");
        robot.delay(10);
        robot.mouseMove(width,height);
    }


}
