package binaryTree;

public class Test {
    public static void main(String[] a){
        TreeNode[] nodeList = new TreeNode[5];
        for(int i = 0; i < 5; i++){
            nodeList[i] = new TreeNode();
            nodeList[i].val = i;
        }
        nodeList[0].left = nodeList[1];
        nodeList[0].right = nodeList[2];
        nodeList[1].left = nodeList[3];
        nodeList[2].right = nodeList[4];
        TreeNode root = nodeList[0];
        TreeNode find = dfs(root, 0);
        if(find != null){
            System.out.println("node:" + find.val);
        }
    }
    /*
        二叉树寻找某一值进行返回
     */
    public static TreeNode dfs(TreeNode root, int val){
        if(root == null || root.val == val){
            return root;

        }
        TreeNode left = dfs(root.left, val);
        TreeNode right = dfs(root.right, val);
        if(left == null)    return right;
        else if(right == null)  return left;
        else return  null;
    }
}
