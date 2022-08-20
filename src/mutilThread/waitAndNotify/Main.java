package mutilThread.waitAndNotify;

public class Main {
    public static void main(String[] agrs) throws InterruptedException {
        Object lock = new Object();
        Thread thread1 = new Thread(new MyThread(lock,"thread1"));
        Thread thread2 = new Thread(new MyThread(lock,"thread2"));
        Thread thread3 = new Thread(new MyThread(lock,"thread3"));
        thread1.start();
        thread2.start();
        Thread.sleep(3000);
        thread3.start();


        synchronized (lock){
            lock.notify();
            //Thread.sleep(3000);
            lock.notifyAll();
        }

    }
}
