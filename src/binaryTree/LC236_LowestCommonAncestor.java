package binaryTree;
/*
    题目：二叉树的最近公共祖先
    难度：medium
    给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
    百度百科中最近公共祖先的定义为：“对于有根树 T 的两个节点 p、q，最近公共祖先表示为一个节点 x，
    满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
    链接：https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree
 */
/*
    解法：二叉树后序递归遍历，
 */
public class LC236_LowestCommonAncestor {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //如果找到p,q直接返回
        if(root == null || root == p || root == q){
            return root;
        }
        TreeNode leftNode = lowestCommonAncestor(root.left, p, q);
        TreeNode rightNode = lowestCommonAncestor(root.right, p, q);
        if(leftNode == null)    return rightNode;
        else if(rightNode == null)  return leftNode;
        //如果两个子树上都找到p,q，则说明该节点为公共祖先
        else    return root;
    }
}
