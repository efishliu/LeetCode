package mutilThread.blockQueue;

import java.util.Random;
import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable{
    private BlockingQueue blockingQueue;
    int data;
    Producer(){}
    Producer(BlockingQueue queue){
        this.blockingQueue = queue;
    }

    @Override
    public void run() {
        System.out.println("producer " + Thread.currentThread().getName() + " start");
        data = new Random().nextInt(10);
        try {
            blockingQueue.put(data);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("producer " + Thread.currentThread().getName() + " add " + data);
    }
}
