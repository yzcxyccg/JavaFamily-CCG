class Mythread1 extends Thread {
    public Mythread1() {
        System.out.println(Thread.currentThread().getName());
    }
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}
public class Test2{
    public static void main(String[] args) {
        Thread.currentThread().setName("main Thread");
        Mythread1 myThread = new Mythread1();
        myThread.setName("my Thread");
        myThread.start();
    }
}
