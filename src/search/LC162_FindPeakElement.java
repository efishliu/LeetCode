package search;
/*
    题目：寻找峰值
    难度：medium
    峰值元素是指其值严格大于左右相邻值的元素。
    给你一个整数数组nums，找到峰值元素并返回其索引。
    数组可能包含多个峰值，在这种情况下，返回 任何一个峰值 所在位置即可。
    你可以假设nums[-1] = nums[n] = -∞ 。
    你必须实现时间复杂度为 O(log n) 的算法来解决此问题。
    输入：nums = [1,2,1,3,5,6,4]
    输出：1 或 5
    解释：你的函数可以返回索引 1，其峰值元素为 2；
        或者返回索引 5， 其峰值元素为 6。
    链接：https://leetcode.cn/problems/find-peak-element
 */
/*
    方法：采用二分法进行查找，以中点为基准,如果中点比右边的数小，更新left
    否则更新right,最终当left==right时即为峰值
 */
public class LC162_FindPeakElement {
    public int findPeakElement(int[] nums) {
        int n = nums.length;
        if(n == 0)    return -1;
        if(n == 1)    return 0;

        int left = 0;
        int right = n - 1;
        while(left < right){
            int mid = (left + right) / 2;
            if(mid + 1 < n && nums[mid] < nums[mid + 1]){
                left = mid + 1;
            }else{
                right = mid;
            }
        }
        return right;
    }
}
