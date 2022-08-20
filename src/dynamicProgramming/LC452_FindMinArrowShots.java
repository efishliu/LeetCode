package dynamicProgramming;

import java.util.Arrays;
/*
    题目：用最小数量的箭引爆气球
    难度：medium
    有一些球形气球贴在一堵用 XY 平面表示的墙面上。墙面上的气球记录在整数数组points，
    其中points[i] = [xstart, xend]表示水平直径在xstart和xend之间的气球。
    你不知道气球的确切 y 坐标。一支弓箭可以沿着 x 轴从不同点 完全垂直地射出。
    在坐标 x 处射出一支箭，若有一个气球的直径的开始和结束坐标为 xstart，xend，
    且满足 xstart≤ x ≤ xend，则该气球会被 引爆。可以射出的弓箭的数量 没有限制 。
    弓箭一旦被射出之后，可以无限地前进。
    给你一个数组 points ，返回引爆所有气球所必须射出的 最小 弓箭数。
    链接：https://leetcode-cn.com/problems/minimum-number-of-arrows-to-burst-balloons

 */
public class LC452_FindMinArrowShots {
    public int findMinArrowShots(int[][] points) {
        int n = points.length;
        if(n == 0 || n == 1)    return n;
        Arrays.sort(points, (a, b) -> (a[1] > b[1] ? 1 : -1));

        int ans = 1;
        int prevEnd = points[0][1];
        for(int i = 1; i < n; i++){
            int nextStart = points[i][0];
            //System.out.println("start:"+nextStart+",end:"+prevEnd);
            if(nextStart > prevEnd){
                prevEnd = points[i][1];
                ans++;
            }
        }
        return ans;
    }
}
