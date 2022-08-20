package slidingWindow;

import java.util.LinkedList;
import java.util.List;

/*
    题目：找到字符串中所有字母异位词
    难度：medium
    给定两个字符串s和p，找到s中所有p的异位词的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
    异位词 指由相同字母重排列形成的字符串（包括相同的字符串）。
    链接：https://leetcode-cn.com/problems/find-all-anagrams-in-a-string
    示例：输入: s = "cbaebabacd", p = "abc"，输出: [0,6]
 */
/*
    解决方法：滑动窗口
 */
public class LC438_FindAnagrams {
    public List<Integer> findAnagrams(String s, String p) {
        int m = s.length();
        int n = p.length();
        List<Integer> ans = new LinkedList<>();
        if(m < n)   return ans;
        int[] sCount = new int[26];
        int[] pCount = new int[26];
        for(int i = 0;i < n;i++){
            pCount[p.charAt(i) - 'a']++;
            sCount[s.charAt(i) - 'a']++;
        }
        int left = 0;
        if(isEqual(sCount,pCount)){
            ans.add(left);
        }
        for(int right = n;right < m;right++){
            sCount[s.charAt(right) - 'a']++;
            sCount[s.charAt(left++) - 'a']--;
            if(isEqual(sCount,pCount)){
                ans.add(left);
            }
        }
        return ans;
    }
    public boolean isEqual(int[] sCount, int[] pCount){
        for(int i = 0; i < 26; i++){
            if(sCount[i] != pCount[i]){
                return false;
            }
        }
        return true;
    }
}
