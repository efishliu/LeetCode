package qiuzhao.byteDance;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
Main的第二题，用BFS方法做
 */
public class Main3 {
    public static void main(String[] args){
        Scanner reader = new Scanner(System.in);
        while (reader.hasNext()){
            String t = reader.nextLine();
            String[] ts = t.split(" ");
            int n = Integer.parseInt(ts[0]);
            int m = Integer.parseInt(ts[1]);
            char[][] arr = new char[n][m];
            Queue<int[]> queue = new LinkedList<>();
            int[][] dirs = new int[][]{{-1,0}, {1,0}, {0,-1}, {0,1}};
            boolean[][] visited = new boolean[n][m];
            int ans = n * m;
            for(int i = 0; i < n; i++){
                String str = reader.nextLine();
                for(int j = 0; j < m; j++){
                    arr[i][j] = str.charAt(j);
                    if(arr[i][j] == 'O'){
                        queue.offer(new int[]{i, j});
                        visited[i][j] = true;
                    }
                }
            }

            while(!queue.isEmpty()){
                int[] cur = queue.poll();
                ans--;
                int x = cur[0];
                int y = cur[1];
                for(int k = 0; k < 4; k++){
                    int i = x + dirs[k][0];
                    int j = y + dirs[k][1];

                    if(i >= 0 && j >= 0 && i < n && j < m && !visited[i][j]){
                        //上
                        if(k == 0 && (arr[i][j] == '.' || arr[i][j] == 'D')){
                            queue.offer(new int[]{i, j});
                            visited[i][j] = true;
                        }
                        //下
                        else if(k == 1 && (arr[i][j] == '.' || arr[i][j] == 'U')){
                            queue.offer(new int[]{i, j});
                            visited[i][j] = true;
                        }
                        //左
                        else if(k == 2 && (arr[i][j] == '.' || arr[i][j] == 'R')){
                            queue.offer(new int[]{i, j});
                            visited[i][j] = true;
                        }
                        //右
                        else if(k == 3 && (arr[i][j] == '.' || arr[i][j] == 'L')){
                            queue.offer(new int[]{i, j});
                            visited[i][j] = true;
                        }
                    }
                }
            }
            System.out.println(ans);
        }
    }
}
