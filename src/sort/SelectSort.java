package sort;


/*
    选择排序
 */
public class SelectSort {
    public static void main(String[] args){
        int[] arr = new int[]{2,6,9,1,4,6,7,0};
        selectSort(arr);
        for(int a : arr){
            System.out.print(a + " ");
        }
    }

    public static void selectSort(int[] arr){
        int n = arr.length;
        for(int i = 0; i < n; i++){
            int minIndex = i;
            for(int j = i + 1; j < n; j++){
                if(arr[minIndex] > arr[j]){
                    minIndex = j;
                }
            }
            swap(arr, i, minIndex);
        }
    }
    public static void swap(int[] arr, int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
