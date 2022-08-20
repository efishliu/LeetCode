package other;
import common.TreeNode;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Test {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        //获取Class对象
        Class treeNodeClass = TreeNode.class;
        //创建实例
        Object object = treeNodeClass.getConstructor().newInstance();
        //获取Class对象指定的方法
        Method method = treeNodeClass.getMethod("print",null);
        //执行相应的方法
        method.invoke(object);
    }

}
