package other;
/*
    单例模式：双重检查锁实现（线程安全）
 */
public class Single {
    //volatile禁止指令重排
    private volatile static Single instance;
    private Single(){};
    public static Single getInstance(){
        if(instance == null){
            //双重检查锁
            synchronized (Single.class){
                if(instance == null){
                    instance = new Single();
                }
            }
        }
        return instance;
    }
}
