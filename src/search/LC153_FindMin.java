package search;
/*
    题目：寻找旋转排序数组中的最小值
    难度：medium
    已知一个长度为 n 的数组，预先按照升序排列，经由 1 到 n 次 旋转 后，得到输入数组。例如，原数组 nums = [0,1,2,4,5,6,7] 在变化后可能得到：
    若旋转 4 次，则可以得到 [4,5,6,7,0,1,2]
    若旋转 7 次，则可以得到 [0,1,2,4,5,6,7]
    注意，数组 [a[0], a[1], a[2], ..., a[n-1]] 旋转一次 的结果为数组 [a[n-1], a[0], a[1], a[2], ..., a[n-2]] 。
    给你一个元素值 互不相同 的数组 nums ，它原来是一个升序排列的数组，并按上述情形进行了多次旋转。请你找出并返回数组中的 最小元素 。
    你必须设计一个时间复杂度为O(log n) 的算法解决此问题。
    链接：https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array
 */
/*
    旋转数组找最小值
 */
public class LC153_FindMin {
    public int findMin(int[] nums){
        int n = nums.length;
        int left = 0;
        int right = n - 1;
        while(left <= right){
            int mid = (left + right) / 2;
            if(nums[mid] < nums[right]){
                right = mid;
            }else if(nums[mid] > nums[right]){
                left = mid + 1;
            }else{
                //mid == right == left
                break;
            }
        }
        return nums[left];
    }
    public int findMin2(int[] nums) {
        int n = nums.length;
        int minVal = nums[0];
        int left = 0;
        int right = n - 1;
        while(left <= right){
            int mid = (left + right) / 2;
            if(nums[left] < nums[right]){
                minVal = Math.min(minVal, nums[left]);
                break;
            }
            else if(nums[mid] < nums[right]){
                //右侧数组有序
                minVal = Math.min(minVal, nums[mid]);
                right = mid - 1;
            }
            else if(nums[mid] > nums[left] || mid == left){
                //左侧数组有序
                minVal = Math.min(minVal, nums[left]);
                left = mid + 1;
            }else{
                minVal = Math.min(minVal, nums[mid]);
                break;
            }
        }
        return minVal;
    }
}
