package ImmortalSoul.thread;

/**
 * Created by tansibin on 2018/3/24.
 * 两个线程交替打印1-100 ，线程1和线程2
 */
public class ExamCommunication {

    public static void main(String[] args) {

        Runnable r = new Runnable() {

            int i = 1;

            @Override
            public void run() {
                while (true){
                    synchronized (this){
                        notify();
                        if (i<=100){
                            System.out.println(Thread.currentThread().getName() + i);
                            i++;
                        }else
                            break;
                        try {
                            wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }

        };

        Thread one = new Thread(r);
        Thread two = new Thread(r);

        one.setName("线程1 : ");
        two.setName("线程2 : ");

        one.start();
        two.start();

    }

}
