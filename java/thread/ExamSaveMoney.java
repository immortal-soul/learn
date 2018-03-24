package ImmortalSoul.thread;

/**
 * Created by tansibin on 2018/3/24.
 * 两个客户同时往一个账户存钱，一共存3000 每次存1000  每次存完后显示账户余额
 */
public class ExamSaveMoney {

    public static void main(String[] args) {

        Runnable r = new Runnable() {

            int money = 0;

            @Override
            public void run() {
                for (int i = 0; i < 3; i++) {
                    saveMoney();
                }
            }

            private synchronized void saveMoney(){
                money += 1000;
                System.out.println(Thread.currentThread().getName() + " : " + " 账户余额 : " + money);
            }
        };

        Thread one = new Thread(r);
        Thread two = new Thread(r);

        one.setName("小李");
        two.setName("小红");

        one.start();
        two.start();

    }
}
