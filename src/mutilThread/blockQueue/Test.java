package mutilThread.blockQueue;


import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class Test {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue buffer = new LinkedBlockingQueue(3);
        Thread p1 = new Thread(new Producer(buffer));
        Thread p2 = new Thread(new Producer(buffer));
        Thread c1 = new Thread(new Consumer(buffer));
        //带超时的阻塞队列
        buffer.offer(123,3, TimeUnit.SECONDS);
        p1.start();
        c1.start();
        c1.join();
        System.out.println("main end");
    }
}
