package binaryTree;

import java.util.*;

/*
    题目：二叉树的锯齿形层序遍历
    难度：medium
    给你二叉树的根节点 root ，返回其节点值的 锯齿形层序遍历 。
    （即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
    链接：https://leetcode.cn/problems/binary-tree-zigzag-level-order-traversal/
 */
public class LC103_ZigzagLevelOrder {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null)    return ans;
        boolean flag = false;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> layer = new ArrayList<>();
            while(size > 0){
                TreeNode t = queue.poll();
                layer.add(t.val);
                if(t.left != null)
                    queue.offer(t.left);
                if(t.right != null)
                    queue.offer(t.right);
                size--;
            }
            if(flag){
                Collections.reverse(layer);
            }
            flag = !flag;
            ans.add(new ArrayList(layer));
        }
        return ans;
    }
}
