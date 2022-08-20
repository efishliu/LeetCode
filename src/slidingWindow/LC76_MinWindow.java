package slidingWindow;
/*
    题目：最小覆盖子串
    难度：hard
    给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。
    如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
    注意：
        对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。
        如果 s 中存在这样的子串，我们保证它是唯一的答案。
    链接：https://leetcode-cn.com/problems/minimum-window-substring
 */
/*
    滑动窗口典型例题，关键在于什么时候滑动窗口
 */
public class LC76_MinWindow {
    public String minWindow(String s, String t) {
        int m = s.length();
        int n = t.length();
        if(m < n)   return "";
        int[] sCount = new int[100];//用于标记字符串出现的次数
        int[] tCount = new int[100];
        for(char c : t.toCharArray()){
            tCount[c - 'A']++;
        }
        int left = 0;
        int minLen = Integer.MAX_VALUE;
        int minLeft = 0;
        for(int right = 0; right < m; right++){
            char c = s.charAt(right);
            //右移right，将其加入
            sCount[c - 'A']++;
            //符号条件后滑动left，将left位置的元素移出
            while(isExist(sCount, tCount)){
                //记录最小子串的位置和长度
                if(right - left < minLen){
                    minLen = right - left;
                    minLeft = left;
                }
                sCount[s.charAt(left) - 'A']--;
                left++;

            }
        }
        if(minLen < Integer.MAX_VALUE){
            return s.substring(minLeft, minLeft + minLen +1);
        }else{
            return "";
        }
    }
    public boolean isExist(int[] sCount,int[] tCount){
        for(int i = 0;i < 100; i++){
            if(sCount[i] < tCount[i]){
                return false;
            }
        }
        return true;
    }
}
