package mutilThread.waitAndNotify;
/*
    题目：按序打印
    难度：easy
    三个不同的线程 A、B、C 将会共用一个Foo实例。
    线程 A 将会调用 first() 方法
    线程 B 将会调用 second() 方法
    线程 C 将会调用 third() 方法
    请设计修改程序，以确保 second() 方法在 first() 方法之后被执行，third() 方法在 second() 方法之后被执行。
    链接：https://leetcode-cn.com/problems/print-in-order
 */
/*
    线程间的同步方法：
    1、wait和notifAll进行同步
    2、await和signal进行同步
    3、使用信号量进行同步
        private Semaphore two = new Semaphore(0);
        private Semaphore three = new Semaphore(0);
        two.release();      V操作 variable + 1
        two.acquire();      P操作 variable - 1


 */
public class LC1114_Foo {
    public volatile boolean firstFinished;
    public volatile boolean secondFinished;
    public Object lock;
    public LC1114_Foo() {
        firstFinished = false;
        secondFinished = false;
        lock = new Object();
    }

    public void first(Runnable printFirst) throws InterruptedException {
        synchronized(lock){
            // printFirst.run() outputs "first". Do not change or remove this line.
            printFirst.run();
            firstFinished = true;
            lock.notifyAll();
        }
    }

    public void second(Runnable printSecond) throws InterruptedException {
        synchronized(lock){
            while(!firstFinished){
                lock.wait();
            }
            printSecond.run();
            secondFinished = true;
            lock.notifyAll();
        }
    }

    public void third(Runnable printThird) throws InterruptedException {
        synchronized(lock){
            while(!secondFinished){
                lock.wait();
            }
            printThird.run();
        }
        // printThird.run() outputs "third". Do not change or remove this line.

    }
}
