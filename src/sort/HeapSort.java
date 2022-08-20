package sort;
/*
    堆排序
 */
public class HeapSort {
    public static void main(String[] args){
        int[] arr = new int[]{2,6,9,1,4,6,7,0};
        sort(arr);
        for(int a : arr){
            System.out.print(a + " ");
        }
    }
    public static void sort(int[] arr){
        heapSort(arr);
    }
    public static void heapSort(int[] arr){
        int n = arr.length;
        //构造一个大顶堆,从非叶子节点开始向上调整
        for(int i = n / 2 - 1; i >= 0; i--){
            adjustHeap(arr, i, n);
        }
        for(int i = n - 1; i > 0; i--){
            swap(arr, 0, i);
            adjustHeap(arr, 0, i);
        }
    }
    public static void adjustHeap(int[] arr, int i, int n){
        int temp = arr[i];
        //向下遍历，将左右叶子节点大值向上浮动
        for(int k = 2 * i + 1; k < n; k = 2 * k + 1){
            if(k + 1 < n && arr[k + 1] > arr[k]){
                //右节点更大
                k++;
            }
            if(arr[k] > temp){
                arr[i] = arr[k];
                i = k;
            }else{
                break;
            }
        }
        arr[i] = temp;
    }
    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
