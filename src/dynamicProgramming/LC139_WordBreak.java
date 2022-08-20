package dynamicProgramming;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
    题目：单词拆分
    难度：medium
    给你一个字符串 s 和一个字符串列表 wordDict 作为字典。请你判断是否可以利用字典中出现的单词拼接出 s 。
    注意：不要求字典中出现的单词全部都使用，并且字典中的单词可以重复使用。
    链接：https://leetcode-cn.com/problems/word-break
 */
/*
    讲其视为一个完全背包问题，物品为字典，s为背包
 */
public class LC139_WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] dp = new boolean[n+1];
        Set<String> wordSet = new HashSet(wordDict);
        dp[0] = true;
        //先遍历背包再遍历字典
        for(int i = 1; i <= n; i++){
            for(int j = 0; j < i; j++){
                if(dp[j] && wordSet.contains(s.substring(j, i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }
}
