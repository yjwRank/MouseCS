package mouse.test;

import mouse.event.Constants;

import javax.swing.*;
import java.awt.event.*;


/**
 * Created by yjw on 17-4-28.
 */
public class MouseEventList implements MouseMotionListener,MouseListener {
    @Override
    public void mouseClicked(MouseEvent e) {
        switch (e.getButton()){
            case 1:
                lastMotion= Constants.MOUSE_CLICK_LEFT;
                break;
            case 2:
                lastMotion=Constants.MOUSE_CLICK_MID;
                break;
            case 3:
                lastMotion=Constants.MOUSE_CLICK_RIGHT;
        }
        System.out.println("button:"+e.getButton()+" mouse click");
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

    @Override
    public void mouseDragged(MouseEvent e) {
        System.out.println("mouse drage");
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        System.out.println("mouse move:"+e.getX()+","+e.getY());
    }


    public int getLastMotion(){return lastMotion;}

    public static void main(String[] args) throws InterruptedException {
        ActionListener actionListener=new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        };
        Timer timer=new Timer(1000,actionListener);
        timer.start();
        Thread.sleep(10000);
    }



    private int lastMotion=-1;

}
