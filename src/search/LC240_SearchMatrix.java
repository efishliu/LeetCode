package search;
/*
    题目：搜索二维矩阵II
    难度：medium
    编写一个高效的算法来搜索mxn矩阵 matrix 中的一个目标值 target 。该矩阵具有以下特性：
        每行的元素从左到右升序排列。
        每列的元素从上到下升序排列。
    链接：https://leetcode.cn/problems/search-a-2d-matrix-ii
 */
/*
    方法：采用Z字型查找法
 */
public class LC240_SearchMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int x = 0, y = n - 1;
        while (x < m && y >= 0) {
            if (matrix[x][y] == target) {
                return true;
            }else if (matrix[x][y] > target) {
                --y;
            }else if (matrix[x][y] < target){
                ++x;
            }
        }
        return false;
    }
}
