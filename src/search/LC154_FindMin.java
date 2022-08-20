package search;
/*
    题目：寻找旋转排序数组中的最小值 II
    难度：hard
    已知一个长度为 n 的数组，预先按照升序排列，经由 1 到 n 次 旋转 后，得到输入数组。例如，原数组 nums = [0,1,4,4,5,6,7] 在变化后可能得到：
    若旋转 4 次，则可以得到 [4,5,6,7,0,1,4]
    若旋转 7 次，则可以得到 [0,1,4,4,5,6,7]
    注意，数组 [a[0], a[1], a[2], ..., a[n-1]] 旋转一次 的结果为数组 [a[n-1], a[0], a[1], a[2], ..., a[n-2]] 。
    给你一个可能存在 重复 元素值的数组 nums ，它原来是一个升序排列的数组，并按上述情形进行了多次旋转。请你找出并返回数组中的 最小元素 。
    链接：https://leetcode.cn/problems/find-minimum-in-rotated-sorted-nums-ii
 */
public class LC154_FindMin {
    public int findMin(int[] nums) {
        int n = nums.length;
        int left = 0;
        int right = n - 1;
        while(left < right){
            int mid = (left + right) / 2;
            if(nums[left] < nums[right]){
                //区间是有序的
                return nums[left];
            }else{
                //[left,mid]无序
                if(nums[mid] < nums[left]){
                    right = mid;
                }
                else if(nums[mid] > nums[right]){
                    //[mid,right]无序
                    left = mid + 1;
                }else{
                    right--;
                }
            }
            //System.out.println("left:" + left + " right:" + right);
        }
        return nums[left];
    }
}
