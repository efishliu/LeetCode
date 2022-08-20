package mutilThread.JUC;

import java.util.concurrent.CountDownLatch;

public class Test {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(2);
        Thread thread1 = new Thread(new MyCountDownLatch(countDownLatch));
        Thread thread2 = new Thread(new MyCountDownLatch(countDownLatch));
        thread1.start();
        thread2.start();
        countDownLatch.await();
        System.out.println("main finished!" );

    }
}
