package binaryTree;

import java.util.LinkedList;
import java.util.Queue;

/*
    题目：二叉树的最小深度
    难度：easy
    给定一个二叉树，找出其最小深度。
    最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
    说明：叶子节点是指没有子节点的节点。
    链接：https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/
 */
/*
    两种解法：
    1、BFS层次遍历
    2、DFS深度遍历
 */
public class LC111_MinDepth {
    public int minDepth(TreeNode root) {
        if(root == null)    return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int layer = 0;
        while(!queue.isEmpty()){
            layer++;
            int size = queue.size();
            for(int i = 0;i < size;i++){
                TreeNode node = queue.poll();
                if(node.left == null && node.right == null){
                    return layer;
                }
                if(node.left != null){
                    queue.add(node.left);
                }
                if(node.right != null){
                    queue.add(node.right);
                }
            }
        }
        return layer;
    }
    //递归dfs
    public int minDepth2(TreeNode root) {
        if(root == null)    return 0;
        else if(root.left == null)  return minDepth(root.right) + 1;
        else if(root.right == null) return minDepth(root.left) + 1;
        else return Math.min(minDepth(root.left),minDepth(root.right)) + 1;
    }
}
