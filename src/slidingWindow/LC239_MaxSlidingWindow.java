package slidingWindow;

import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
/*
    题目：滑动窗口最大值
    难度：困难
    给你一个整数数组 nums，有一个大小为k的滑动窗口从数组的最左侧移动到数组的最右侧。
    你只可以看到在滑动窗口内的 k个数字。滑动窗口每次只向右移动一位。
    返回 滑动窗口中的最大值 。
    链接：https://leetcode.cn/problems/sliding-window-maximum
 */
public class LC239_MaxSlidingWindow {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[n - k + 1];
        Deque<Integer> maxQueue = new LinkedList<>();
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < n; i++){
            if(i < k){
                queue.offer(nums[i]);
                while (!maxQueue.isEmpty() && maxQueue.peekLast() < nums[i]){
                    maxQueue.pollLast();
                }
                maxQueue.offer(nums[i]);
                if(i == k - 1){
                    ans[i - k + 1] = maxQueue.peekFirst();
                }
            }else{
                int num = queue.poll();
                if(num == maxQueue.peekFirst()){
                    maxQueue.pollFirst();
                }
                queue.offer(nums[i]);
                while (!maxQueue.isEmpty() && maxQueue.peekLast() < nums[i]){
                    maxQueue.pollLast();
                }
                maxQueue.offer(nums[i]);
                ans[i - k + 1] = maxQueue.peekFirst();
            }
        }
        return ans;
    }

    public int[] maxSlidingWindow2(int[] nums, int k){
        int n = nums.length;
        int[] ans = new int[n - k + 1];
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> (b[0] - a[0] == 0 ? a[1] - b[1] : b[0] - a[0]));
        for(int i = 0; i < k; i++){
            maxHeap.offer(new int[]{nums[i], i});
        }
        ans[0] = maxHeap.peek()[0];
        for(int i = k; i < n; i++){
            maxHeap.offer(new int[]{nums[i],i});
            while(maxHeap.peek()[1] <= i - k){
                maxHeap.poll();
            }
            ans[i - k + 1] = maxHeap.peek()[0];
        }
        return ans;
    }

    public int[] maxSlidingWindow3(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[n - k + 1];
        Deque<Integer> maxQueue = new LinkedList<>();
        for(int i = 0; i < k; i++){
            while (!maxQueue.isEmpty() && nums[maxQueue.peekLast()] <= nums[i]){
                maxQueue.pollLast();
            }
            maxQueue.offerLast(i);
        }
        ans[0] = nums[maxQueue.peekFirst()];
        for(int i = k; i < n; i++){
            while (!maxQueue.isEmpty() && nums[maxQueue.peekLast()] <= nums[i]){
                maxQueue.pollLast();
            }
            maxQueue.offerLast(i);
            while(maxQueue.peekFirst() <= i - k){
                maxQueue.pollFirst();
            }
            ans[i - k + 1] = nums[maxQueue.peekFirst()];
        }
        return ans;
    }
}
