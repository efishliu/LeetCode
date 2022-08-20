package mutilThread.waitAndNotify;

public class MyThread implements Runnable{
    public static int num = 0;
    public Object lock;
    public String name;
    MyThread(Object object,String name){
        this.lock = object;
        this.name = name;
    }
    @Override
    public void run() {
        num++;
        System.out.println("current num: "+ num);

        //当不满足条件时等待
        if(num < 3){
            synchronized (lock){
                System.out.println("thread " + name + " sleep!");
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }else{
            synchronized (lock){
                System.out.println("thread " + name + " notify!");
                lock.notify();
            }
        }
        System.out.println("thread " + name + " awake!");



    }
}
