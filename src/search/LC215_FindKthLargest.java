package search;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Random;
/*
    题目：数组中的第K个最大元素
    难度：medium
    给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
    请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
    链接：https://leetcode.cn/problems/kth-largest-element-in-an-array/
 */
public class LC215_FindKthLargest {
    //采用直接排序
    public int findKthLargest1(int[] nums, int k) {
        int n = nums.length;
        if(n < k)   return 0;

        Arrays.sort(nums);
        return nums[n - k];
    }
    //采用堆方式进行排序
    public int findKthLargest2(int[] nums, int k) {
        int n = nums.length;
        if(n < k)   return 0;

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> (b - a));

        for(int num : nums){
            maxHeap.offer(num);
        }
        int ans = 0;
        while(k > 0){
            ans = maxHeap.poll();
            k--;
        }
        return ans;
    }

    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        if(n < k)   return 0;

        return find(nums, 0, n - 1, n, k);
    }

    public int find(int[] nums, int left, int right, int n, int k){
        int pos = potition(nums, left, right);
        if(pos == n - k){
            return nums[n - k];
        }else if(pos > n - k){
            return find(nums, left, pos - 1, n, k);
        }else{
            return find(nums, pos + 1, right, n, k);
        }
    }
    public int potition(int[] nums, int left, int right){
        int p = new Random().nextInt(right - left + 1) + left;
        swap(nums, p, right);
        int index = left - 1;
        for(int i = left; i < right; i++){
            if(nums[i] < nums[right]){
                index++;
                swap(nums, index, i);
            }
        }
        index++;
        swap(nums, index, right);
        return index;
    }

    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
