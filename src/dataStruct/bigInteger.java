package dataStruct;

import java.math.BigInteger;
import java.util.Scanner;

/*
        要解决的是：
        1. 任意进制r1转任意进制r2 new BigInteger(s, r1).toString(r2)
        2. 大数的加减乘除
     */
public class bigInteger {
    public static void main(String[] args){
        String s = "111001101";
        int i = 461;
        //任意进制转十进制
        //1.不溢出的情况
        int t1 = Integer.parseInt(s, 2);
        System.out.println("二进制：" + s + "转十进制：" + t1);
        //2.可能会溢出
        BigInteger t2 = new BigInteger(s, 2);
        String t3 = t2.toString(10);
        System.out.println("二进制：" + t2.toString() + "转十进制：" + t3);
        //十进制转2进制
        System.out.println(new BigInteger(new String("" + i), 10).toString(2));

        //大数的加减乘除
        BigInteger bt1 = new BigInteger(String.valueOf(1000000000));
        BigInteger bt2 = new BigInteger(String.valueOf(i));
        //1. 大数相加
        System.out.println(bt1.add(bt2).toString());
        //2. 大数相减
        System.out.println(bt1.subtract(bt2).toString());
        //3. 大数相乘
        System.out.println(bt1.multiply(bt2).toString());
        //4. 大数相除
        System.out.println(bt1.divide(bt2).toString());
        //5. 取余
        System.out.println(bt1.mod(bt2).toString());

        //判断
        if(bt1.mod(bt2).equals(BigInteger.valueOf(183))){
            System.out.println("yes");
        }else{
            System.out.println("no");
        }

        Scanner reader = new Scanner(System.in);
        while (reader.hasNext()){
            BigInteger bt3 = reader.nextBigInteger(10);
            System.out.println(bt3.toString(2));
            BigInteger bt4 = reader.nextBigInteger(2);
            System.out.println(bt4.toString());
        }


    }

}
