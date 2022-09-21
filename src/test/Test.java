package test;

import java.util.*;

public class Test{
    static class TreeNode{
        public int val;
        public TreeNode left;
        public TreeNode right;
        public TreeNode(){};
        public TreeNode(int v){this.val = v;}

    }
    static class ListNode{
        int val;
        ListNode next;
        ListNode(){};
        ListNode(int v){this.val = v;};
    }
    public static void main(String[] args){
        Scanner reader = new Scanner(System.in);
        while(reader.hasNext()){
            String s = reader.nextLine();
            String str = reader.nextLine();
            int n = Integer.parseInt(s);
            List<Integer> res = new LinkedList<>();
            PriorityQueue<Integer> minHeap = new PriorityQueue<>(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return 0;
                }
            });
            //String[] strs = str.split("\s+");
//            for(int i = 0; i < strs.length; i++){
//
//            }
        }
    }
}