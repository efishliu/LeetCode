package binaryTree;

import java.util.List;
import java.util.Stack;
/*
    先序，中序，后序遍历的递归和非递归实现
 */

public class TreeDFS {
    public class TreeNode{
        int val;
        TreeNode left,right;
        TreeNode(){}
        TreeNode(int v) {
            val = v;
        }
    }

    //中序遍历-递归
    public void zDFS(TreeNode root, List<TreeNode> buffer){
        if(root == null)    return;
        zDFS(root.left,buffer);
        buffer.add(root);
        zDFS(root.right,buffer);

    }
    //先序遍历-递归
    public void xDFS(TreeNode root, List<TreeNode> buffer){
        if(root == null)    return;

        buffer.add(root);
        xDFS(root.left,buffer);
        xDFS(root.right,buffer);

    }
    //后序遍历-递归
    public void hDFS(TreeNode root, List<TreeNode> buffer){
        if(root == null)    return;
        hDFS(root.left,buffer);
        hDFS(root.right,buffer);
        buffer.add(root);

    }

    //中序遍历-非递归实现
    public void zStackDfs(TreeNode root,List<TreeNode> buffer){
        if(root == null) return;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;

        while (cur != null || !stack.isEmpty()){
            while (cur != null){
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            buffer.add(cur);
            cur = cur.right;
        }
    }

    //先序遍历-非递归实现
    public void xStackDfs(TreeNode root,List<TreeNode> buffer){
        if(root == null)    return;
        TreeNode cur = root;
        Stack<TreeNode> stack = new Stack<>();
        while (cur!=null || !stack.isEmpty()){
            while (cur != null){
                buffer.add(cur);
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            cur = cur.right;
        }
    }
    //后序遍历-非递归实现
    public void hStackDfs(TreeNode root,List<TreeNode> buffer){
        if(root == null)    return;
        TreeNode cur = root;
        TreeNode prev = null;
        Stack<TreeNode> stack = new Stack<>();
        while (cur != null || !stack.isEmpty()){
            while (cur != null){
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.peek();
            if(cur.right != null && cur.right != prev){//右子树还未访问
                cur = cur.right;
            }else{
                stack.pop();
                buffer.add(cur);
                prev = cur;
                cur = null;
            }
        }

    }

}
