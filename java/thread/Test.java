package ImmortalSoul.thread;

/**
 * Created by tansibin on 2018/3/24.
 */
public class Test {

    public static void main(String[] args) {

    }

    public static void test2(){
        new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 101; i++)
                    System.out.println(Thread.currentThread().getName() + " : " + i);
            }
        }.start();
    }

    public static void test1(){
        MyThread myThread = new MyThread();
        myThread.start();
    }
}

class MyThread extends Thread{
    @Override
    public void run() {
        for (int i=0;i<101;i++)
            System.out.println(Thread.currentThread().getName() + " : " +i);
    }
}
