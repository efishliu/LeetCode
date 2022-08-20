package backTracking;

import java.util.LinkedList;
import java.util.List;

/*
    题目：分割回文串
    难度：medium
    给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。
    回文串 是正着读和反着读都一样的字符串。
    链接：https://leetcode-cn.com/problems/palindrome-partitioning/
 */
/*
    难点：将分割子串的问题转换为回溯问题
 */
public class LC131_Partition {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new LinkedList<>();
        dfs(s, 0, new LinkedList<>(), ans);
        return ans;
    }
    public void dfs(String s, int begin, List<String> buffer, List<List<String>> ans){
        if(begin == s.length()){
            ans.add(new LinkedList<>(buffer));
            return;
        }
        for(int end = begin; end < s.length(); end++){
            if(isHuiwen(s.substring(begin, end + 1))){
                buffer.add(s.substring(begin, end + 1));
                dfs(s, end + 1, buffer, ans);
                buffer.remove(buffer.size() - 1);
            }
        }
    }

    public boolean isHuiwen(String s){
        int n = s.length();
        for(int i = 0, j = n - 1; i < j; i++, j--){
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
        }
        return true;
    }
}
