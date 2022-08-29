package qiuzhao.xiaohongshu;
import java.util.*;
public class Main1 {
    public static void main(String[] args){
        Scanner reader = new Scanner(System.in);
        while (reader.hasNext()){
            int n = reader.nextInt();
            int m = reader.nextInt();
            int id = reader.nextInt();
            int[][] arr = new int[n][m];
            int[][] imp = new int[n][2];    //[id,importance]
            for(int i = 0; i < n; i++){
                int sum = 0;
                for(int j = 0; j < m; j++){
                    arr[i][j] = reader.nextInt();
                    sum += arr[i][j];
                }
                imp[i][0] = i + 1;  //id号
                imp[i][1] = sum;
            }
            Arrays.sort(imp, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    if(o1[1] != o2[1]){
                        //如果两个重要程度不同，按重要程度降序
                        return o2[1] - o1[1];
                    }else{
                        //如果两个重要程度相同同，按id升序
                        return o1[0] - o2[0];
                    }
                }
            });
            //查找
            for(int i = 0; i < n; i++){
                if(imp[i][0] == id){
                    //找到
                    System.out.println(i + 1);
                }
            }
        }
    }
}
