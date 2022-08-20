package mutilThread.blockQueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable{
    BlockingQueue queue;
    ArrayBlockingQueue q;

    Consumer(){}
    Consumer(BlockingQueue queue){
        this.queue = queue;
    }

    @Override
    public void run() {
        System.out.println("consumer " + Thread.currentThread().getName() + " start!");
        Object data = null;

        try {
            data = queue.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("consumer " + Thread.currentThread().getName() + " get " + data);
    }
}
