package search;
/*
    总结二分查找的通用写法
    1. 有序数组里寻找一个数，传统二分法
    2. 有序数组里寻找一个数，如果有重复数字，则返回最左边的数
    3. 有序数组里寻找一个数，如果有重复数字，则返回最右边的数
 */
public class BinarySearch {
    public static void main(String[] args){
        int[] arr = new int[]{1,3,3,5,5,5,5,6,6,7,8,9};
        int target = 7;
        int ans = binarySearch1(arr, target);
        System.out.println(ans);
        ans = binarySearch2(arr, target);
        System.out.println(ans);
        ans = binarySearch3(arr, target);
        System.out.println(ans);
    }
    //只是找到这个数字，不管重复
    public static int binarySearch1(int[] arr, int target){
        int n = arr.length;
        int left = 0;
        int right = n - 1;
        while (left <= right){
            int mid = left + (right - left) / 2;
            if(arr[mid] == target){
                return mid;
            }else if(arr[mid] > target){
                right = mid - 1;
            }else if(arr[mid] < target){
                left = mid + 1;
            }
        }
        return -1;
    }
    //找到这个数字，如果有重复数字，返回最左边的索引
    //返回最左边的索引即为left，但是返回之前要进行判断
    public static int binarySearch2(int[] arr, int target){
        int n = arr.length;
        int left = 0;
        int right = n - 1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(arr[mid] == target){
                right = mid - 1;
            }else if(arr[mid] < target){
                left = mid + 1;
            }else if(arr[mid] > target){
                right = mid - 1;
            }
        }
        if(left >= n || arr[left] != target){
            return -1;
        }
        return left;
    }
    //找到这个数字，如果有重复数字，返回最右边的索引
    //返回最右边的索引即为right，但是返回之前要进行判断
    public static int binarySearch3(int[] arr, int target){
        int n = arr.length;
        int left = 0;
        int right = n - 1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(arr[mid] == target){
                left = mid + 1;
            }else if(arr[mid] < target){
                left = mid + 1;
            }else if(arr[mid] > target){
                right = mid - 1;
            }
        }
        if(right < 0 || arr[right] != target){
            return -1;
        }
        return right;
    }



}
