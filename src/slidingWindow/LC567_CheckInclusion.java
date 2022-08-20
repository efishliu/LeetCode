package slidingWindow;
/*
    题目：字符串的排列
    难度：medium
    给你两个字符串s1和s2 ，写一个函数来判断 s2 是否包含 s1的排列。
    如果是，返回 true ；否则，返回 false 。
    换句话说，s1 的排列之一是 s2 的 子串 。
    链接：https://leetcode-cn.com/problems/permutation-in-string
 */
/*
    解法：利用计数＋窗口解决
 */
public class LC567_CheckInclusion {
    public boolean checkInclusion(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        if(n < m)   return false;
        int[] mConut = new int[26];
        int[] nCount = new int[26];
        for(int i = 0; i < m; i++){
            mConut[s1.charAt(i) - 'a']++;
            nCount[s2.charAt(i) - 'a']++;
        }
        int right = m;
        int left = 0;
        while(right < n){
            if(isExist(mConut,nCount)){
                return true;
            }
            nCount[s2.charAt(right) - 'a']++;
            right++;
            nCount[s2.charAt(left) - 'a']--;
            left++;
        }
        if(isExist(mConut,nCount)){
            return true;
        }else{
            return false;
        }

    }

    public boolean isExist(int[] mConut, int[] nCount){
        for(int i = 0;i < 26;i++){
            if(mConut[i] != nCount[i]){
                return false;
            }
        }
        return true;
    }
}
