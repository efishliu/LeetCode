package arrayList;

import java.util.Arrays;
import java.util.Comparator;

/*
    给定一个数组，里面都是正的整数，求这个数组所有元素能拼接成的最大数
 */
/*
    关键：
    此题求拼接起来的最小数字，本质上是一个排序问题。设数组 numsnums 中任意两数字的字符串为 x 和 y ，
    则规定 排序判断规则 为：
        若拼接字符串 x + y > y + x ，则 x “大于” y ；
        反之，若 x + y < y + x ，则 x “小于” y ；
    x “小于” y 代表：排序完成后，数组中 x 应在 y 左边；“大于” 则反之。
    tips: java中字符串的比较为A.compareTo(B)
 */
public class ByteDance01 {
    public static void main(String[] agrs){
        Integer[] arr = new Integer[]{1,5,33,0,335};
        Arrays.sort(arr, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                String s1 = String.valueOf(o1);
                String s2 = String.valueOf(o2);
                return (s2 + s1).compareTo(s1 + s2);
            }
        });
        StringBuilder res = new StringBuilder();
        for(int i = 0; i < arr.length; i++){
            res.append(String.valueOf(arr[i]));
        }
        System.out.println(res.toString());
    }
}
