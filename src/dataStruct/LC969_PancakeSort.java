package dataStruct;

import java.util.LinkedList;
import java.util.List;

/*
    题目：煎饼排序
    难度：medium
    给你一个整数数组 arr ，请使用 煎饼翻转 完成对数组的排序。
    一次煎饼翻转的执行过程如下：
        选择一个整数 k ，1 <= k <= arr.length
        反转子数组 arr[0...k-1]（下标从 0 开始）
        例如，arr = [3,2,1,4] ，选择 k = 3 进行一次煎饼翻转，反转子数组 [3,2,1] ，得到 arr = [1,2,3,4] 。
    以数组形式返回能使 arr 有序的煎饼翻转操作所对应的 k 值序列。
    任何将数组排序且翻转次数在10 * arr.length 范围内的有效答案都将被判断为正确。
    链接：https://leetcode-cn.com/problems/pancake-sorting
 */
/*
    解法：递归
 */
public class LC969_PancakeSort {
    public List<Integer> pancakeSort(int[] arr) {
        List<Integer> ans = new LinkedList<>();
        int n = arr.length;
        sort(arr, n, ans);
        return ans;
    }
    public void sort(int[] arr, int n, List<Integer> ans){
        if(n == 1){
            return;
        }
        int maxVal = 0;
        int maxIndex = 0;
        for(int i = 0; i < n; i++){
            if(arr[i] > maxVal){
                maxVal = arr[i];
                maxIndex = i;
            }
        }
        reverse(arr, 0, maxIndex);
        ans.add(maxIndex + 1);
        reverse(arr, 0, n - 1);
        ans.add(n);

        sort(arr, n - 1, ans);
    }

    public void reverse(int[] arr, int i, int j){
        while(i < j){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }

    }
}
