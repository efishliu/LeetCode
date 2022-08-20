package backTracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/*
    题目：电话号码的字母组合
    难度：medium
    给定一个仅包含数字2-9的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
    给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
    链接：https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number
 */
public class LC17_LetterCombinations {
    public List<String> letterCombinations(String digits) {
        int n = digits.length();
        if(n == 0) return new ArrayList<String>();
        Map<Character,String> phoneMap = new HashMap<Character,String>();
        phoneMap.put('2',"abc");
        phoneMap.put('3',"def");
        phoneMap.put('4',"ghi");
        phoneMap.put('5',"jkl");
        phoneMap.put('6',"mno");
        phoneMap.put('7',"pqrs");
        phoneMap.put('8',"tuv");
        phoneMap.put('9',"wxyz");
        List<String> ans = new ArrayList<String>();
        backtrack(ans,phoneMap,digits,0,new StringBuffer());
        return ans;
    }
    public void backtrack(List<String> ans,Map<Character,String> phoneMap,String digits,int index,StringBuffer combination){
        if(index == digits.length()){
            ans.add(combination.toString());
        }
        else{
            String phoneChars = phoneMap.get(digits.charAt(index));
            for(int i=0;i<phoneChars.length();i++){
                combination.append(phoneChars.charAt(i));
                backtrack(ans,phoneMap,digits,index+1,combination);
                combination.deleteCharAt(index);
            }
        }
    }
}
