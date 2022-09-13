package qiuzhao.webank;

import java.math.BigInteger;
import java.util.*;

public class Main2 {
    public static void main(String[] args){
        Scanner reader = new Scanner(System.in);
        int n = Integer.valueOf(reader.nextLine());
        for(int t = 0; t < n; t++){
            String[] temp = reader.nextLine().split(" ");
            String a = new BigInteger(temp[0], 10).toString(2);
            String b = new BigInteger(temp[1], 10).toString(2);
            //System.out.println("当前a："  + a + " 当前b：" + b);
            System.out.println(bfs(a, b));
        }

    }
    public static int bfs(String a, String b){
        int ans = 0;
        if(a.equals(b)){
            return ans;
        }
        Queue<String> queue = new LinkedList<>();
        queue.offer(a);
        Set<String> set = new HashSet<>();
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                String str = queue.poll();
                if(str.equals(b)){
                    return ans;
                }else{
                    if(str.compareTo(b) == -1){
                        if(!set.contains(str + "0")){
                            queue.offer(str + "0");
                            set.add(str + "0");
                        }
                        if(!set.contains(str + "00")){
                            queue.offer(str + "00");
                            set.add(str + "00");
                        }
                        if(!set.contains(str + "000")){
                            queue.offer(str + "000");
                            set.add(str + "000");
                        }

                    }else{
                        if(str.charAt(str.length() - 1) == '0'){
                            if(!set.contains(str.substring(0, str.length() - 1))){
                                queue.offer(str.substring(0, str.length() - 1));
                                set.add(str.substring(0, str.length() - 1));
                            }
                            if(str.charAt(str.length() - 2) == '0'){
                                if(!set.contains(str.substring(0, str.length() - 2))){
                                    queue.offer(str.substring(0, str.length() - 2));
                                    set.add(str.substring(0, str.length() - 2));
                                    if(str.charAt(str.length() - 3) == '0'){
                                        if(!set.contains(str.substring(0, str.length() - 3))){
                                            queue.offer(str.substring(0, str.length() - 3));
                                            set.add(str.substring(0, str.length() - 3));
                                        }
                                    }
                                }

                            }
                        }
                    }


                }
            }
            ans++;
        }
        return -1;
    }
}
