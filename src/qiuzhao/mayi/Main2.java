package qiuzhao.mayi;

import java.util.*;

public class Main2 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        while(reader.hasNext()){
            int t = reader.nextInt();

            Map<Integer, Integer> leftMap = new HashMap<>();
            Map<Integer, Integer> rightMap = new HashMap<>();
            Map<Integer, Integer> indexMap = new HashMap<>();
            int n = 100000;
            int[] tree = new int[n + 1];
            indexMap.put(1, 1);
            for(int i = 0; i < t - 1; i++){
                int u = reader.nextInt();
                int v = reader.nextInt();
                if(leftMap.containsKey(u)){
                    rightMap.put(u, v);
                    indexMap.put(v, indexMap.get(u) * 2 + 1);
                }else{
                    leftMap.put(u, v);
                    indexMap.put(v, indexMap.get(u) * 2);
                }
            }

            for(Map.Entry entry : indexMap.entrySet()){
                int k = (int)entry.getKey();
                int v = (int)entry.getValue();
                tree[v] = 1;
            }
            int ans = 0;
            for(int i = 1; i <= n; i++){
                if(tree[i] != 0){
                    int res = i - tree[i];
                    if(res > 0){
                        ans += res;
                        Queue<Integer> queue = new LinkedList<>();
                        queue.offer(i);
                        while(!queue.isEmpty()){
                            int u = queue.poll();
                            tree[u] += res;
                            if(leftMap.containsKey(u)){
                                queue.offer(indexMap.get(leftMap.get(u)));
                            }
                            if(rightMap.containsKey(u)){
                                queue.offer(indexMap.get(rightMap.get(u)));
                            }
                        }
                    }
                }

            }
            System.out.println(ans);
        }
    }
}
