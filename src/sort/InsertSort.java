package sort;
/*
    插入排序：
 */
public class InsertSort {
    public static void main(String[] args){
        int[] arr = new int[]{2,6,9,1,4,6,7,0};
        //bubbleSort(arr);
        derInsertSort(arr);
        for(int a : arr){
            System.out.print(a + " ");
        }
    }

    public static void derInsertSort(int[] arr){
        int n = arr.length;
        for(int i = 1; i < n; i++){
            for(int j = i; j > 0 && arr[j] < arr[j - 1]; j--){
                swap(arr, j, j - 1);
            }
        }
    }
    public static void swap(int[] arr, int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
