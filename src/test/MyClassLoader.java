package test;

import java.net.URL;
import java.net.URLClassLoader;

public class MyClassLoader extends URLClassLoader {
    public MyClassLoader(URL[] urls, ClassLoader parent) {
        super(urls, parent);
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        return super.findClass(name);
    }
    public static void main(String[] args){
        MyClassLoader.getSystemClassLoader();
        Thread.class.getClassLoader();
        Character.isDigit('1');
    }
}
