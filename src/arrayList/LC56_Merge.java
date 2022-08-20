package arrayList;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/*
    题目：合并区间
    难度：中等
    以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。
    请你合并所有重叠的区间，并返回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。
    输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
    输出：[[1,6],[8,10],[15,18]]
    解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
    链接：https://leetcode-cn.com/problems/merge-intervals
 */
public class LC56_Merge {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        if(n == 0)  return new int[0][2];
        if(n == 1)  return intervals;
        Arrays.sort(intervals, (a, b) -> (a[0] - b[0]));
        System.out.println(Arrays.deepToString(intervals));
        List<int[]> res = new LinkedList<>();
        res.add(intervals[0]);
        for(int i = 1; i < n; i++){
            int start = intervals[i][0];
            int end = intervals[i][1];
            if(start <= res.get(res.size() - 1)[1]){
                res.get(res.size() - 1)[1] = Math.max(end, res.get(res.size() - 1)[1]);
            }else{
                res.add(intervals[i]);
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}
