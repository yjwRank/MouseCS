package mouse.test;

/**
 * Created by yjw on 17-5-5.
 */
public class Test_ThreadVariable implements Runnable{
    private TestEvent test;
    public Test_ThreadVariable(TestEvent test){
        this.test=test;
    }

    @Override
    public void run() {
        int pretest=0;
        while(true){
            if(pretest!=test.getTest()){
                System.out.println(test.getTest());
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        TestEvent test=new TestEvent(1);
        Thread t=new Thread(new Test_ThreadVariable(test));
        t.start();
        test.setTest(2);
        Thread.sleep(3000);
        test.setTest(3);

    }

}


class TestEvent{
    public TestEvent(int test){
        this.test=test;
    }

    public void setTest(int test){
        this.test=test;
    }

    public int getTest(){
        return this.test;
    }
    private int test;
}
