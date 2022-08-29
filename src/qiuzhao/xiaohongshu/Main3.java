package qiuzhao.xiaohongshu;

import java.util.*;

public class Main3 {
    public static int[] t = new int[]{1,1};
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        while (reader.hasNext()) {
            int n = reader.nextInt();
            //邻接矩阵代表朋友关系，friends[i][j] = 1代表是朋友
            int[][] friends = new int[n + 1][n + 1];
            for(int i = 1; i < n; i++){
                int j = reader.nextInt();
                //i+1员工与j员工为朋友
                friends[i + 1][j] = 1;
                friends[j][i + 1] = 1;
            }
            //代表访问过
            boolean[] visited = new boolean[n + 1];
            int[] ans = new int[1];
            ans[0] = 0;
            dfs(n, friends, visited, new LinkedList<>(), ans);
            System.out.println(ans[0]);
        }
    }

    public static void dfs(int n, int[][] friends, boolean[] visited, List<int[]> buf, int[] ans){
        if(buf.size() > ans[0]){
            ans[0] = buf.size();
        }
        //遍历未配对的员工
        for(int i = 1; i <= n; i++){
            if(!visited[i]){
                for(int j = 1; j <= n; j++){
                    if(i != j && !visited[j] && friends[i][j] == 1){
                        buf.add(t);
                        visited[i] = true;
                        visited[j] = true;
                        dfs(n, friends, visited, buf, ans);
                        buf.remove(buf.size() - 1);
                        visited[i] = false;
                        visited[j] = false;
                    }
                }
            }
        }
    }
}
