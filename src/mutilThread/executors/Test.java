package mutilThread.executors;

import java.awt.*;
import java.util.concurrent.*;

public class Test {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        /*
        Executor 四种线程池的创建方式
         */
        ExecutorService cachedExecutor = Executors.newCachedThreadPool();
        ExecutorService sigleExecutor = Executors.newSingleThreadExecutor();
        ExecutorService fixedExecutor = Executors.newFixedThreadPool(3);
        ScheduledExecutorService scheduledExecutor = Executors.newScheduledThreadPool(3);
        scheduledExecutor.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("hello scheduledExecutor!");
            }
        },3, TimeUnit.SECONDS);

        cachedExecutor.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("hello cachedExecutor");
                System.out.println("thread " + Thread.currentThread().getName() +" start");
            }
        });
        sigleExecutor.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("hello sigleExecutor");
                System.out.println("thread " + Thread.currentThread().getName() +" start");
            }
        });
        fixedExecutor.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("hello fixedExecutor");
                System.out.println("thread " + Thread.currentThread().getName() +" start");
            }
        });

        //ThreadPoolExecutor
        ExecutorService threadPollExecutor = new ThreadPoolExecutor(
                3,5,10,TimeUnit.SECONDS,
                new LinkedBlockingQueue(20),
                new ThreadPoolExecutor.AbortPolicy()
        );
        threadPollExecutor.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("thread " + Thread.currentThread().getName() + " run");
            }
        });

        Future<?> future = threadPollExecutor.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "hello";
            }
        });
        System.out.println(future.get());
    }
}
