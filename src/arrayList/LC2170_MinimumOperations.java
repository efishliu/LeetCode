package arrayList;

import java.util.Arrays;

/*
    给你一个下标从 0 开始的数组 nums ，该数组由 n 个正整数组成。
    如果满足下述条件，则数组 nums 是一个 交替数组 ：
        nums[i - 2] == nums[i] ，其中 2 <= i <= n - 1 。
        nums[i - 1] != nums[i] ，其中 1 <= i <= n - 1 。
    在一步 操作 中，你可以选择下标 i 并将 nums[i] 更改 为 任一 正整数。
    返回使数组变成交替数组的 最少操作数 。
    链接：https://leetcode.cn/problems/minimum-operations-to-make-the-array-alternating
*/
public class LC2170_MinimumOperations {
    static int N = 100010;
    static int[] m1 = new int[N], m2 = new int[N];
    public int minimumOperations(int[] nums) {
        int n = nums.length;
        Arrays.fill(m1, 0);
        Arrays.fill(m2, 0);
        int a = 0, b = 0, c = 0, d = 0;
        for (int i = 0; i < n; i++) {
            int t = nums[i];
            if (i % 2 == 0) {
                m1[t]++;
                if (a == 0 || m1[t] > m1[a]) {
                    b = a; a = t;
                } else if (t != a && (b == 0 || m1[t] > m1[b])) {
                    b = t;
                }
            } else {
                m2[t]++;
                if (c == 0 || m2[t] > m2[c]) {
                    d = c; c = t;
                } else if (t != c && (d == 0 || m2[t] > m2[d])) {
                    d = t;
                }
            }
        }
        if (a != c) return n - m1[a] - m2[c];
        else return n - Math.max(m1[a] + m2[d], m1[b] + m2[c]);
    }
}
