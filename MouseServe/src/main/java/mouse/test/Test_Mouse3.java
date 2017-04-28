package mouse.test;

/**
 * Created by yjw on 17-4-28.
 */

import javax.swing.*;
import javax.swing.event.MouseInputAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowAdapter;

public class Test_Mouse3 implements MouseMotionListener,MouseListener{




    public static void main(String[] args){
        JFrame jFrame=new JFrame("test");
        jFrame.setSize(100,100);
        Test_Mouse3 t=new Test_Mouse3();
        jFrame.addMouseListener(t);
        jFrame.addMouseMotionListener(t);
        jFrame.setLocation(100,100);
        jFrame.setOpacity(0.1f);
        jFrame.setVisible(true);
        jFrame.setVisible(false);
    }

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

    @Override
    public void mouseDragged(MouseEvent e) {
        System.out.println("mouse drage");
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        System.out.println("mouse move:"+e.getX()+","+e.getY());
    }
}