package qiuzhao.byteDance;
/*
    case:
5 5
.....
.RRD.
.U.DR
.ULL.
....O
 */
import java.util.*;
public class Main2 {
    public static void main(String[] args){
        Scanner reader = new Scanner(System.in);
        while (reader.hasNext()){
            String t = reader.nextLine();
            String[] ts = t.split(" ");
            int n = Integer.parseInt(ts[0]);
            int m = Integer.parseInt(ts[1]);
            char[][] arr = new char[n][m];
            for(int i = 0; i < n; i++){
                String str = reader.nextLine();
                for(int j = 0; j < m; j++){
                    arr[i][j] = str.charAt(j);
                }
            }
            int ans = 0;
            //之前走过的路记录下来
            boolean[][] sovled = new boolean[n][m];
            for(int i = 0; i < n; i++){
                for(int j = 0; j < m; j++){
                    boolean[][] visited = new boolean[n][m];
                    boolean[][] isFind = new boolean[n][m];
                    boolean[] flag = new boolean[1];
                    flag[0] = false;

                    if(!dfs(arr, i, j, n, m, flag, visited, sovled)){
                        ans++;
                    }
                }
            }
            System.out.println(ans);
        }
    }

    public static boolean dfs(char[][] arr, int i, int j, int n, int m, boolean[] flag, boolean[][] visited, boolean[][] sovled){
        //System.out.println("now i=" + i + " j=" + j);
        if(i < 0 || j < 0 || i >= n || j >= m){
            return false;
        }
        if(visited[i][j]){
            return sovled[i][j];
        }
        visited[i][j] = true;
        if(arr[i][j] == 'O' || flag[0] == true){
            //到达终点
            flag[0] = true;
            return true;
        }else{
            //未到达终点，继续走
            if(arr[i][j] == 'U'){
                //只能往上走
                sovled[i][j] = dfs(arr, i - 1, j, n, m, flag, visited, sovled);
            }else if(arr[i][j] == 'D'){
                //只能往下走
                sovled[i][j] = dfs(arr, i + 1, j, n, m, flag, visited, sovled);
            }else if(arr[i][j] == 'L'){
                //只能往左走
                sovled[i][j] = dfs(arr, i, j - 1, n, m, flag, visited, sovled);
            }else if(arr[i][j] == 'R'){
                //只能往右走
                sovled[i][j] = dfs(arr, i, j + 1, n, m, flag, visited, sovled);
            }else{
                //随便哪里都可走
                sovled[i][j] = dfs(arr, i - 1, j, n, m, flag, visited, sovled) || dfs(arr, i + 1, j, n, m, flag, visited, sovled)
                        || dfs(arr, i, j - 1, n, m, flag, visited, sovled)|| dfs(arr, i, j + 1, n, m, flag, visited, sovled);

            }
            return sovled[i][j];
        }
    }
}
