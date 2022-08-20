package dynamicProgramming;

import java.util.*;

/*
    题目：跳跃游戏IV
    难度：hard
    给你一个整数数组arr，你一开始在数组的第一个元素处（下标为 0）。
    每一步，你可以从下标i跳到下标i + 1 、i - 1 或者 j ：
        i + 1 需满足：i + 1 < arr.length
        i - 1需满足：i - 1 >= 0
        j 需满足：arr[i] == arr[j]且i != j
    请你返回到达数组最后一个元素的下标处所需的最少操作次数。
    注意：任何时候你都不能跳到数组外面。
    链接：https://leetcode-cn.com/problems/jump-game-iv
 */
/*
    此题不能用动态规划，应用深度优先遍历
    当前状态由 i-1, i+1, j 转移的来，但是d[j]可能在d[i]前面或者后面，可能未计算，所以不能复用
    由BFS的层数即为最小步数
 */
public class LC1345_MinJumps {
    public int minJumps(int[] arr) {
        int n = arr.length;
        if(n == 0 || n == 1)    return 0;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < n; i++){
            if(map.containsKey(arr[i])){
                map.get(arr[i]).add(i);
            }else{
                List<Integer> list = new LinkedList<>();
                list.add(i);
                map.put(arr[i], list);
            }
        }
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n];
        q.offer(0);
        visited[0] = true;
        int ans = -1;
        while(!q.isEmpty()){
            int size = q.size();
            ans++;
            while(size > 0){
                int index = q.poll();
                if(index == n - 1)  return ans;
                size--;
                if(index - 1 >= 0 && !visited[index - 1]){
                    q.offer(index - 1);
                    visited[index - 1] = true;
                }
                if(index + 1 < n && !visited[index + 1]){
                    q.offer(index + 1);
                    visited[index + 1] = true;
                }
                if(map.containsKey(arr[index])) {
                    for (int i : map.get(arr[index])) {
                        if (!visited[i]) {
                            q.offer(i);
                            visited[i] = true;
                        }
                    }
                    //已经全部遍历过，直接删除，避免重复判断
                    map.remove(arr[index]);
                }
            }
        }
        return ans;
    }
}
