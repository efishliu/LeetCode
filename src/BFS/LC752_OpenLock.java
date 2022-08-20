package BFS;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/*
    题目：打开转盘锁
    难度：medium
    你有一个带有四个圆形拨轮的转盘锁。每个拨轮都有10个数字：
    '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' 。
    每个拨轮可以自由旋转：例如把 '9' 变为'0'，'0' 变为 '9' 。每次旋转都只能旋转一个拨轮的一位数字。
    锁的初始数字为 '0000' ，一个代表四个拨轮的数字的字符串。
    列表 deadends 包含了一组死亡数字，一旦拨轮的数字和列表里的任何一个元素相同，这个锁将会被永久锁定，无法再被旋转。
    字符串 target 代表可以解锁的数字，你需要给出解锁需要的最小旋转次数，如果无论如何不能解锁，返回 -1 。
    链接：https://leetcode-cn.com/problems/open-the-lock
 */
/*
    本题的难点在于构图，即如何将路径最短问题转化为图的路径最短问题
    核心点在于节点的邻接节点，即状态的转移
    之后采用BFS进行搜索即可
 */
public class LC752_OpenLock {
    public int openLock(String[] deadends, String target) {
        Set<String> death = new HashSet<>();
        Set<String> visited = new HashSet<>();
        for(String s : deadends){
            death.add(s);
        }
        Queue<String> q = new LinkedList<>();
        if(death.contains("0000")){
            return -1;
        }
        q.offer("0000");
        visited.add("0000");
        int step = 0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int k = 0; k < size; k++){
                String t = q.poll();
                if(t.equals(target)){
                    return step;
                }

                for(int i = 0; i < 4; i++){
                    //上滑
                    char[] ch = t.toCharArray();
                    ch[i] = ch[i] == '9' ? '0' : (char) (ch[i] + 1);
                    String upString = new String(ch);
                    if(!visited.contains(upString) && !death.contains(upString)){
                        q.offer(upString);
                        visited.add(upString);
                    }
                    //下滑
                    ch = t.toCharArray();
                    ch[i] = ch[i] == '0' ? '9' : (char) (ch[i] - 1);
                    String downString = new String(ch);
                    if(!visited.contains(downString) && !death.contains(downString)){
                        q.offer(downString);
                        visited.add(downString);
                    }

                }
            }
            step++;
        }
        return -1;
    }
}
