package sort;

import java.util.Random;
import java.util.Stack;

public class QuickSort {
    public static void main(String[] args){
        int[] arr = new int[]{2,6,9,1,4,6,7};
        //sort(arr);
        //quickSort2(arr);
        iterativeQuickSort(arr);
        for(int a : arr){
            System.out.print(a + " ");
        }
    }
    public static void sort(int[] arr){
        quickSort(arr, 0, arr.length - 1);
    }
    public static void quickSort(int[] arr, int left, int right){
        if(left < right){
            int pos = position(arr, left, right);
            quickSort(arr, left, pos - 1);
            quickSort(arr, pos + 1, right);
        }

    }
    public static int position(int[] arr, int left, int right){
        int pos = new Random().nextInt(right - left + 1) + left;
        int index = left;
        swap(arr, pos, right);
        for(int i = left; i < right; i++){
            if(arr[i] < arr[right]){
                swap(arr, index, i);
                index++;
            }
        }
        swap(arr, index, right);
        return index;
    }
    public static void swap(int[] arr, int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    //快排的非递归算法
    public static void quickSort2(int[] arr){
        int n = arr.length;
        int left = 0;
        int right = n - 1;
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{left, right});
        while(!stack.isEmpty()){
            int[] t = stack.pop();
            left = t[0];
            right = t[1];
            if(left < right){
                int pos = position(arr, left, right);
                if(pos - 1 > left){
                    stack.push(new int[]{left, pos - 1});
                }
                if(pos + 1 < right){
                    stack.push(new int[]{pos + 1, right});
                }
            }
        }
    }

    /*
    快排的迭代算法，用栈来模拟递归
     */
    public static void iterativeQuickSort(int[] nums){
        int n = nums.length;
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        stack.push(n-1);

        while (!stack.isEmpty()){
            int right = stack.pop();
            int left = stack.pop();
            if(left < right){
                int pos = position(nums,left,right);
                //pos左侧的数入栈
                stack.push(left);
                stack.push(pos-1);
                //pos右侧的数入栈
                stack.push(pos+1);
                stack.push(right);
            }
        }
    }

}
