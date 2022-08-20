package io;

import java.io.*;

public class IOSerializable {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        SerializableClass testObject = new SerializableClass();
        testObject.val = 1;
        testObject.tval = 123;

        //序列化对象
        String filePath = "C:\\Users\\92084\\Desktop\\LeetCode\\src\\io\\serial.ser";
        FileOutputStream fileOutput = new FileOutputStream(filePath);
        ObjectOutputStream out = new ObjectOutputStream(fileOutput);
        out.writeObject(testObject);
        out.close();
        fileOutput.close();

        //反序列化对象
        FileInputStream fileInput = new FileInputStream(filePath);
        ObjectInputStream in = new ObjectInputStream(fileInput);
        SerializableClass inputClass = (SerializableClass) in.readObject();
        System.out.println(inputClass.val);
        System.out.println(inputClass.tval);
        inputClass.fun();

    }
}
