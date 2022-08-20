package interfaceTest;

public interface A {
    static final int N = 100;
    public default void fun1(){
        System.out.println("A fun1");
    };
    public void afun2();

}
