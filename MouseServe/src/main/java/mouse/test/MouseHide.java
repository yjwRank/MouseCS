package mouse.test;

import java.awt.*;

/**
 * Created by yjw on 17-5-2.
 */
public class MouseHide {
    public static void main(String[] args){
        System.out.println(Cursor.getDefaultCursor().toString());
        System.out.println(MouseInfo.getNumberOfButtons());
        System.out.println(MouseInfo.getPointerInfo().getDevice());
    }
}
