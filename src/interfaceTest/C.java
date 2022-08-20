package interfaceTest;

public interface C extends A, B{


    @Override
    default void fun1() {
        B.super.fun1();
    }

    @Override
    void afun2();

    @Override
    default void bfun2() {

    }
}
