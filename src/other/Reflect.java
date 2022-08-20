package other;
import common.TreeNode;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.LinkedList;
import java.util.List;

public class Reflect {
    Reflect(){}
    public Object copy(Object object) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        Class classType = object.getClass();
        Class treeNodeClass = TreeNode.class;
        Class temp = Class.forName("common.TreeNode");
        Object obj = treeNodeClass.getConstructor(int.class).newInstance(123);
        Field field = temp.getField("data");
        System.out.println(field.getName());

        Method method = treeNodeClass.getMethod("print",null);
        method.invoke(obj);
        return obj;
    }
    public static void main(String[] args){
        List<Integer> list = new LinkedList<>();
        list.add(1);
        System.out.println(list.get(0).getClass());
    }
}
