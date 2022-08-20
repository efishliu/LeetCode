package qiuzhao.lenovo;
import java.util.*;
public class Main2 {
    public static void main(String[] args){
        Scanner reader = new Scanner(System.in);
        Map<Character, Integer> map = new HashMap<>();
        map.put('A', 8);
        map.put('7', 7);
        map.put('6', 6);
        map.put('5', 5);
        map.put('4', 4);
        map.put('3', 3);
        map.put('2', 2);

        int T = Integer.parseInt(reader.nextLine());
        for(int j = 0; j < T; j++){
            String str = reader.nextLine();
            String[] temp = str.split(" ");
            int [] alice = new int[3];
            int [] bob = new int[3];
            for(int i = 0; i < 3; i++){
                alice[i] = map.get(temp[i].charAt(0));
                bob[i] = map.get(temp[i + 3].charAt(0));
            }
            int[] res1 = pType(alice);
            int[] res2 = pType(bob);
            if(res1[0] > res2[0]){
                System.out.println("Alice");
            }else if(res1[0] < res2[0]){
                System.out.println("Bob");
            }else{

            }

        }
    }
    public static int[] pType(int[] cs){
        //第一个string为类型，后面为牌大小
        String[] res = new String[4];
        int[] count = new int[10];
        Arrays.fill(count, 0);
        int max = 0;
        int min = 10;
        for(int i = 0; i < 3; i++){
            count[cs[i]]++;
            max = Math.max(max, cs[i]);
            min = Math.min(min, cs[i]);
        }

        for(int i = 9; i > 0; i--){
            if(count[i] == 3){
                return new int[]{3, i, i, i};
            }
            else if(count[i] == 2){
                if(i ==  max){
                    return new int[]{2, i, i, min};
                }else{
                    return new int[]{2,max, i, i};
                }
            }
        }
        return new int[]{1, max, max, min};

    }
}
