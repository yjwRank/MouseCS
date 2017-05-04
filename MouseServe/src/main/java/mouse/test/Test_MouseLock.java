package mouse.test;

/**
 * Created by yjw on 17-5-4.
 */
public class Test_MouseLock implements Runnable {
    @Override
    public void run() {
        MouseControl mouseControl=new MouseControl();
        while(true){
            System.out.println("move to loc");
            mouseControl.MoveToLoc(500,500);
        }
    }
}
