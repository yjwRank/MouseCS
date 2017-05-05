package mouse.test;

import com.sun.awt.AWTUtilities;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by yjw on 17-5-5.
 */
public class Test_JFrame {
    private JFrame myFrame=new JFrame("test frame");
    private boolean opacity=true;
    private boolean resize=true;
    private JButton button=new JButton("opacity");
    private JButton button1=new JButton("Resize");

    public Test_JFrame(){
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object src=e.getSource();
                if(opacity){
                    AWTUtilities.setWindowOpacity(myFrame,0.50f);
                    opacity=false;
                }else{
                    AWTUtilities.setWindowOpacity(myFrame,1.0f);
                    opacity=true;
                }
            }
        });
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object src=e.getSource();
                if(resize){
                    Rectangle dim=GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds();
                    int h=dim.height;
                    int w=dim.width;
                    myFrame.setBounds(00,00,w,h);
                    resize=false;
                }else{
                    myFrame.setBounds(100,100,400,400);
                }
            }
        });

        JPanel panel=new JPanel();
        panel.add(button);
        panel.add(button1);
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.add(panel);
        myFrame.setSize(400,400);
        myFrame.setVisible(true);
    }

    public static void main(String[] args){
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Test_JFrame t=new Test_JFrame();
            }
        });

    }
}
