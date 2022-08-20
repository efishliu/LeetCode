package backTracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
    题目：括号生成
    难度：medium
    数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
    输入：n = 3
    输出：["((()))","(()())","(())()","()(())","()()()"]
    链接：https://leetcode-cn.com/problems/generate-parentheses/
 */
/*
    采用回溯法：
    1. 在'('的左右加入一个完整的括号"()"进行回溯
    2. 结合括号的性质，一个字符串中的左括号应大于等于右括号数目，在回溯中进行剪枝

 */
public class LC22_GenerateParenthesis {
    //方法1
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<String>();
        List<String> res = new ArrayList<String>();
        backtrack(ans,n,1,new String("()"));
        Set<String> hashset = new HashSet<String>();
        for(int i=0;i<ans.size();i++){
            if(hashset.contains(ans.get(i)))    continue;
            else{
                hashset.add(ans.get(i));
                res.add(ans.get(i));
            }
        }
        //return ans;
        return res;
    }
    public void backtrack(List<String> ans,int n,int index,String s){
        if(index == n)  ans.add(s);
        else{
            int m = s.length();
            for(int i=0;i<m;i++){
                if(s.charAt(i) == '('){
                    //在(左边放置一个()
                    String t1 = s.substring(0,i) + new String("()") + s.substring(i);
                    backtrack(ans,n,index+1,t1);
                    //在(右边放置一个()
                    String t2 = s.substring(0,i+1) + new String("()") + s.substring(i+1);
                    backtrack(ans,n,index+1,t2);

                }
            }
        }
    }

    public List<String> generateParenthesis2(int n) {
        List<String> ans = new ArrayList<String>();
        backtrack2(ans, new StringBuilder(), 0, 0, n);
        return ans;
    }

    public void backtrack2(List<String> ans, StringBuilder cur, int open, int close, int max) {
        if (cur.length() == max * 2) {
            ans.add(cur.toString());
            return;
        }
        if (open < max) {
            cur.append('(');
            backtrack2(ans, cur, open + 1, close, max);
            cur.deleteCharAt(cur.length() - 1);
        }
        if (close < open) {
            cur.append(')');
            backtrack2(ans, cur, open, close + 1, max);
            cur.deleteCharAt(cur.length() - 1);
        }
    }
}
