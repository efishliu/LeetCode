package interfaceTest;
import common.TreeNode;
public class Test1 extends TreeNode implements C{
    int a;
    @Override
    public void fun1() {
        C.super.fun1();
    }

    @Override
    public void afun2() {

    }




}
