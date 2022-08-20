package dynamicProgramming;

import java.util.Arrays;

/*
    题目：无重叠区间
    难度：medium
    给定一个区间的集合intervals，其中 intervals[i] = [starti, endi]。返回 需要移除区间的最小数量，使剩余区间互不重叠。
    链接：https://leetcode-cn.com/problems/non-overlapping-intervals
 */
/*
    贪心策略：
    如果使得区间剩余更多或者移除更少，则将区间按end进行排序
    //如果使得区间剩余更少，即融合后剩余更少，则将区间按start进行排序
 */
public class LC435_EraseOverlapIntervals {
    public int eraseOverlapIntervals(int[][] intervals) {
        int n = intervals.length;
        if(n == 0 || n == 1)    return 0;
        //按结束日期升序排序
        Arrays.sort(intervals, (a, b) -> (a[1] - b[1]));
        int maxCount = 0;
        int end = intervals[0][1];
        for(int i = 1; i < n; i++){
            int start = intervals[i][0];
            if(start < end){
                maxCount++;
            }else{
                end = intervals[i][1];
            }
        }
        return maxCount;
    }
}
