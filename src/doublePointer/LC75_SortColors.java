package doublePointer;
/*
    题目：颜色分类
    难度：medium
    给定一个包含红色、白色和蓝色、共n 个元素的数组nums，原地对它们进行排序，
    使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
    我们使用整数 0、1 和 2 分别表示红色、白色和蓝色。
    必须在不使用库的sort函数的情况下解决这个问题。
    链接：https://leetcode-cn.com/problems/sort-colors
 */
/*
    采用双指针
 */
public class LC75_SortColors {
    public void sortColors(int[] nums) {
        int n = nums.length;
        int redIndex = 0;
        int blueIndex = n - 1;
        for(int i = 0; i <= blueIndex; i++){
            if(nums[i] == 2){
                while(nums[i] == 2 && i <= blueIndex){
                    swap(nums, i, blueIndex);
                    blueIndex--;
                }
            }
            if(nums[i] == 0){
                swap(nums, i, redIndex);
                redIndex++;
            }
        }
        return;
    }
    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
