package mouse.test;

import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.peer.MouseInfoPeer;

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

    //mouse action
    public static void main3(String[] args){
        MouseControl mouseControl=new MouseControl();
        mouseControl.MoveToLoc(34,704);
        mouseControl.Click();
    }

    //mouse move action
    public static void main(String[] agrs){
        new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("mouse click");
            }

            @Override
            public void mousePressed(MouseEvent e) {
                System.out.println("mouse press");
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                System.out.println("mouse release");
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                System.out.println("mouse enter");
            }

            @Override
            public void mouseExited(MouseEvent e) {
                System.out.println("mouse exit");
            }
        };
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


    public void movetest(){

    }

    public void Click(){
        robot.mousePress(InputEvent.BUTTON1_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_MASK);
    }

    public void MoveToLoc(int x,int y){
        System.out.println("move to ("+x+","+y+")");
        robot.delay(10);
        robot.mouseMove(x,y);
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
