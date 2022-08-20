package mutilThread.JUC;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class MyContidion {
    public ReentrantLock lock;
    public Condition condition;
    public MyContidion(){
        lock = new ReentrantLock();
        condition = lock.newCondition();
    }

    public void test(){
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                lock.lock();
                try {
                    System.out.println("wait thread2");
                    condition.await();
                    System.out.println("thread1 start");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    lock.unlock();
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                lock.lock();
                System.out.println("thread2 first");
                condition.notify();
                lock.unlock();
            }
        });
    }
}
