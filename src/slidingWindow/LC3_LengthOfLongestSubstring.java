package slidingWindow;

import java.io.IOException;
import java.io.Reader;
import java.util.*;

/*
    题目：无重复字符的最长子串
    难度：medium
    给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
    链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/

 */
/*
    解法为滑动窗口，但是利用map记录下标能加快滑动速度
    解法一为利用map,解法2为传统滑动窗口滑动
 */
public class LC3_LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        Map<Character,Integer> indexMap = new HashMap<>();
        int maxLen = 0;
        int left = 0;
        for(int right = 0;right < n;right++){
            char c = s.charAt(right);
            if(indexMap.containsKey(c)){
                //关键点：left到达最大位置，这样使得窗口外其他的节点自动移出
                left = Math.max(left,indexMap.get(c) + 1);
            }
            indexMap.put(c,right);
            maxLen = Math.max(maxLen,right - left + 1);
        }
        return maxLen;
    }
    public int lengthOfLongestSubstring2(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int maxLen = 0;
        int left = 0;
        for(int right = 0;right < n;right++){
            char c = s.charAt(right);
            if(set.contains(c)){
                //区别在于这里窗口依次进行滑动
                while(s.charAt(left) != c){
                    set.remove(s.charAt(left++));
                }
                //删除c
                set.remove(s.charAt(left++));
            }
            set.add(c);
            maxLen = Math.max(maxLen,right - left + 1);
        }
        return maxLen;
    }
}
