package dynamicProgramming;
/*
    题目：跳跃游戏III
    难度：medium
    这里有一个非负整数数组arr，你最开始位于该数组的起始下标start处。
    当你位于下标i处时，你可以跳到i + arr[i] 或者 i - arr[i]。
    请你判断自己是否能够跳到对应元素值为 0 的 任一 下标处。
    注意，不管是什么情况下，你都无法跳到数组之外。
    链接：https://leetcode-cn.com/problems/jump-game-iii
 */
/*
    从初始节点开始往左或往右跳，如果当前节点曾经进入过直接返回
    如果当前节点为0返回true
 */
public class LC1306_CanReach {
    public boolean canReach(int[] arr, int start) {
        int n = arr.length;
        boolean[] visited = new boolean[n];
        return findZero(arr, start, n, visited);
    }
    public boolean findZero(int[] arr, int start,int n, boolean[] visited){
        if(start < 0 || start >= n){
            //越界
            return false;
        }
        if(visited[start]){
            //已经找过不用再找
            return false;
        }
        visited[start] = true;
        if(arr[start] == 0) return true;
        return findZero(arr, start - arr[start], n, visited) ||
                findZero(arr, start + arr[start], n, visited);
    }
}
