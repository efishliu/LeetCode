package sort;

import java.util.Stack;

/*
    归并排序
 */
public class MergeSort {
    public static void main(String[] args){
        int[] arr = new int[]{2,6,9,1,4,6,7,0};
        sort(arr);
        for(int a : arr){
            System.out.print(a + " ");
        }
    }
    public static void sort(int[] arr){
        mergeSort(arr, 0, arr.length - 1);
    }
    public static void mergeSort(int[] arr, int left, int right){
        if(left < right){
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }
    public static void merge(int[] arr,int left, int mid, int right){
        int[] temp = new int[arr.length];
        int i = left;
        int j = mid + 1;
        int index = left;
        while(i <= mid && j <= right){
            if(arr[i] < arr[j]){
                temp[index++] = arr[i++];
            }else{
                temp[index++] = arr[j++];
            }
        }
        while(i <= mid){
            temp[index++] = arr[i++];
        }
        while(j <= right){
            temp[index++] = arr[j++];
        }
        while(left <= right){
            arr[left] = temp[left++];
        }
    }

    //归并排序 非递归算法
    public static void mergeSort2(int[] arr){
        int n = arr.length;
        int left = 0;
        int right = n - 1;
        Stack<Integer> stack = new Stack<>();

        stack.push(left);
        stack.push(right);

        while(!stack.isEmpty()){
            right = stack.pop();
            left = stack.pop();
            int mid = (left + right) / 2;
            if(left < mid){
                stack.push(left);
                stack.push(mid);
            }else{
                left = stack.pop();

            }
            if(mid + 1 < right){
                stack.push(mid + 1);
                stack.push(right);
            }else{

            }

        }
    }
}
