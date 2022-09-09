package dataStruct;

import java.util.*;

/*
    题目：有效的括号
    难度：easy
    给定一个只包括 '('，')'，'{'，'}'，'['，']'的字符串 s ，判断字符串是否有效。
    有效字符串需满足：
        左括号必须用相同类型的右括号闭合。
        左括号必须以正确的顺序闭合。
        每个右括号都有一个对应的相同类型的左括号。
    链接：https://leetcode.cn/problems/valid-parentheses
 */
public class LC20_IsValid {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
        for(char c : s.toCharArray()){
            if(c == '(' || c == '{' || c == '['){
                stack.push(c);
            }else if(!stack.isEmpty()){
                char t = stack.pop();
                if(map.get(c) != t){
                    return false;
                }
            }else{
                return false;
            }
        }
        if(!stack.isEmpty()){
            return false;
        }else{
            return true;
        }
    }
}
