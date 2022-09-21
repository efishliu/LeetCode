package qiuzhao.xiecheng;
//携程一面笔试题

import java.util.*;

public class Main {
    //题目：输入某年某月某天，判断是这一年的第几天

    public static void main(String[] args){
        //case1
        String date = "2022-09-21";
        int ans = today(date);
        System.out.println(ans);
    }
    public static int today(String date){
        String[] strs = date.split("-");
        int year = Integer.parseInt(strs[0]);
        int month = Integer.parseInt(strs[1]);
        int day = Integer.parseInt(strs[2]);

        Map<Integer, Integer> map = new HashMap<>();
        map.put(1,31);
        map.put(2,28);
        map.put(3,31);
        map.put(4,30);
        map.put(5,31);
        map.put(6,30);
        map.put(7,31);
        map.put(8,31);
        map.put(9,30);
        map.put(10,31);
        map.put(11,30);
        map.put(12,31);

        //判断当前年是不是闰年
        if(isRuiYear(year)){
            map.put(2, 29);
        }
        //记录天数
        int ans = 0;
        //月相加
        for(int i = 1; i < month; i++){
            ans += map.get(i);
        }
        //日
        ans += day;
        return ans;
    }
    /*
        判断当前年份是否是闰年
     */
    public static boolean isRuiYear(int year){
        return false;
    }

}

