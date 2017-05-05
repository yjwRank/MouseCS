package mouse.test;

import java.awt.*;

/**
 * Created by yjw on 17-5-5.
 */
public class Test_MouseClick {
    public static void main(String[] args) throws InterruptedException {
        DisplayMode[] t=MouseInfo.getPointerInfo().getDevice().getDisplayModes();
        for(DisplayMode dis:t){
            System.out.println("bitdepth:"+dis.getBitDepth()+" height:"+dis.getHeight()+" width:"+dis.getWidth()+" refreshrate:"+dis.getRefreshRate());
        }

        System.out.println();
        System.out.println(MouseInfo.getPointerInfo().getDevice().getType());
        DisplayMode mouse=MouseInfo.getPointerInfo().getDevice().getDisplayMode();
        System.out.println("mouse bitdepth:"+mouse.getBitDepth()+" height:"+mouse.getHeight()+" width:"+mouse.getWidth()+" refreshrate:"+mouse.getRefreshRate());



    }
}
