package mutilThread.JUC;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

public class MyCountDownLatch implements Runnable{
    CountDownLatch countDownLatch;
    MyCountDownLatch(){}
    MyCountDownLatch(CountDownLatch cdl){
        this.countDownLatch = cdl;
    }
    @Override
    public void run() {
        System.out.println("thread " + Thread.currentThread().getName() + "start!");
        try {
            Thread.sleep(new Random().nextInt(3000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        countDownLatch.countDown();
        System.out.println("thread " + Thread.currentThread().getName() + "end!");
    }
}
