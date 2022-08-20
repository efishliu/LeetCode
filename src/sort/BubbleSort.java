package sort;
/*
    冒泡排序
 */
public class BubbleSort {
    public static void main(String[] args){
        int[] arr = new int[]{2,6,9,1,4,6,7,0};
        bubbleSort(arr);
        for(int a : arr){
            System.out.print(a + " ");
        }
    }
    public static void bubbleSort(int[] arr){
        int n = arr.length;
        for(int i = 0; i < n - 1; i++){
            for(int j = 0; j < n - i - 1; j++){
                if(arr[j] > arr[j + 1]){
                    swap(arr, j, j + 1);
                }
            }
        }
    }
    public static void swap(int[] arr, int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
