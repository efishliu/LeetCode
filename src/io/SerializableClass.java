package io;

import java.io.Serializable;

public class SerializableClass implements Serializable {
    int val;
    transient int tval;
    public void fun(){
        System.out.println("hello!");
    }
}
