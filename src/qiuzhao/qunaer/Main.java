package qiuzhao.qunaer;

import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args){
        int[] nums = new int[]{2,3,4,2,6,2,5,1};
        int k = 3;

        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> (a[0] - b[0]));
        int n = nums.length;
        int[] ans = new int[n - k + 1];
        for(int i = 0; i < k; i++){
            maxHeap.offer(new int[]{nums[i], i});
        }
        ans[0] = maxHeap.peek()[0];

        for(int i = k; i < n; i++){
            maxHeap.offer(new int[]{nums[i], i});
            while(maxHeap.peek()[1] <= i - k){
                maxHeap.poll();
            }
            ans[i - k + 1] = maxHeap.peek()[0];
        }
        for(int i = 0; i < n - k + 1; i++){
            System.out.println(ans[i]);
        }
    }
}