package binaryTree;

import java.util.HashMap;
import java.util.Map;

/*
    题目：从前序与中序遍历序列构造二叉树
    难度：medium
    给定两个整数数组preorder 和 inorder，其中preorder 是二叉树的先序遍历， inorder是同一棵树的中序遍历，请构造二叉树并返回其根节点。
    链接：https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal
 */
/*
    解法：本质上是一个前序遍历，先构建根节点，再根据根节点构建左子树和右子树，最后返回根节点
    难点：prev数组顺序遍历，根据prev数组定位到innor数组的根节点位置，其中根节点位置左边全为左子树节点，右边全为右子树节点
    再根据innor数组中左右子树的个数，判断prev数组中左右子树的区域划分
 */
public class LC105_BuildTree {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer,Integer> map = new HashMap<>();
        int n = preorder.length;
        for(int i = 0; i < n; i++){
            map.put(inorder[i],i);
        }
        TreeNode root = build(preorder, inorder, 0, n - 1, 0, n - 1, map);
        return root;
    }
    public TreeNode build(int[] preorder, int[] inorder, int preLeft, int preRight, int inorLeft, int inorRight,Map<Integer,Integer> map){
        if(preLeft > preRight || inorLeft > inorRight){
            return null;
        }
        TreeNode root = new TreeNode(preorder[preLeft]);
        int inorIndex = map.get(root.val);
        int leftNum = inorIndex - inorLeft;
        root.left = build(preorder, inorder, preLeft + 1, preLeft + leftNum, inorLeft, inorIndex - 1, map);
        root.right = build(preorder, inorder, preLeft + leftNum + 1, preRight, inorIndex + 1, inorRight, map);
        return root;
    }
}
