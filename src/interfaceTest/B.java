package interfaceTest;

public interface B {
    static final int N = 100;
    public default void fun1(){
        System.out.println("B fun1");
    };
    public void bfun2();
}
