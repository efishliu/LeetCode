package dynamicProgramming;

import common.TreeNode;

import java.util.HashMap;
import java.util.Map;

/*
    题目：打家劫舍
    难度：medium
    小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为root。
    除了root之外，每栋房子有且只有一个“父“房子与之相连。一番侦察之后，
    聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。
    如果 两个直接相连的房子在同一天晚上被打劫 ，房屋将自动报警。
    给定二叉树的root。返回在不触动警报的情况下，小偷能够盗取的最高金额。
    链接：https://leetcode-cn.com/problems/house-robber-iii
 */
public class LC337_RobIII {
    Map<TreeNode, Integer> map = new HashMap<>();
    public int rob(TreeNode root) {
        int ans = dfs(root);
        return ans;
    }
    public int dfs(TreeNode root){
        if(root == null)    return 0;
        if(map.containsKey(root))   return map.get(root);
        //抢当前节点
        int robVal = root.val;
        if(root.left != null){
            robVal += dfs(root.left.left) + dfs(root.left.right);
        }
        if(root.right != null){
            robVal += dfs(root.right.left) + dfs(root.right.right);
        }
        //不抢当前节点的价值
        int noRobVal = dfs(root.left) + dfs(root.right);
        int val = Math.max(robVal, noRobVal);
        map.put(root, val);
        return val;
    }
}
