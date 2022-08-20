package binaryTree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
    NC15 求二叉树的层序遍历
    给定一个二叉树，返回该二叉树层序遍历的结果，（从左到右，一层一层地遍历）

 */
public class TreeBFS {
    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(){
        }
        TreeNode(int v){
            val = v;
        }
    }

    public List<TreeNode> bfs(TreeNode root, List<TreeNode> list){
        if(root != null){
            Queue<TreeNode> queue = new LinkedList<>();
            int layer = 0;
            queue.offer(root);
            while(!queue.isEmpty()){
                int qSize = queue.size();
                layer++;
                while (qSize > 0){
                    TreeNode cur = queue.poll();
                    list.add(cur);
                    qSize--;
                    if(cur.left != null){
                        queue.offer(cur.left);
                    }
                    if(cur.right != null){
                        queue.offer(cur.right);
                    }
                }
            }
            return list;
        }
        return null;
    }
}
