/**
 * @author 程从广
 * @Description
 * @Date 创建于 2020/4/23 10:05
 */
public class LambdaTest {
    public static int a=0;
    public  static void  inc(){
        a++;
    }
    public static void main(String[] args) {
        MyThread one=new MyThread();
        MyThread two=new MyThread();
        MyThread three=new MyThread();
        new Thread(one).start();
        new Thread(two).start();
        new Thread(three).start();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(a);

    }
}
class MyThread implements Runnable{
    @Override
    public void run() {
        for(int i=0;i<1000;i++)
            LambdaTest.inc();

    }
}
