package arrayList;

import java.util.HashSet;
import java.util.Set;
/*
    题目：最长连续序列
    难度：medium
    给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
    请你设计并实现时间复杂度为O(n) 的算法解决此问题。
    链接：https://leetcode-cn.com/problems/longest-consecutive-sequence
 */
/*
    解法：利用哈希进行查找的简化
 */
public class LC128_LongestConsecutive {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int ans = 0;
        for (int num : set) {
            if (!set.contains(num - 1)) {
                int currentNum = num;
                int len = 1;
                while (set.contains(currentNum + 1)) {
                    currentNum++;
                    len++;
                }
                ans = Math.max(ans, len);
            }
        }
        return ans;
    }
}
