package ImmortalSoul.thread;

/**
 * Created by tansibin on 2018/3/24.
 * 模拟出售火车票，三个窗口，一共100张
 */
public class ExamWindos {

    public static void main(String[] args) {
        test1();
    }

    public static void test2(){

    }

    public static void test1(){
        Runnable run = new Runnable() {

            int ticket = 100;

            //所有线程必须用同一把锁

            @Override
            public void run() {
                while (true) {
                    show();
                }
            }

            private synchronized void show(){
                if (ticket > 0) {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + " : 出售" + ticket + "号");
                    ticket--;
                }
            }

        };

        Thread one = new Thread(run);
        Thread two = new Thread(run);
        Thread three = new Thread(run);

        one.setName("窗口 1 ");
        two.setName("窗口 2 ");
        three.setName("窗口 3 ");

        one.start();
        two.start();
        three.start();
    }

}

