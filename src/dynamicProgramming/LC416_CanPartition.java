package dynamicProgramming;
/*
    题目：分割等和子集
    难度：medium
    给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
    链接：https://leetcode-cn.com/problems/partition-equal-subset-sum/
 */
/*
    可以将元素和转化为查找target=sum/2的查找问题，利用递归进行查找，但会超时
    也可以转化为0-1背包问题，该元素是否进行放入
    定义状态，分为了前i个元素和查找的元素为j
    dp[i][j]表示前[0,i)元素的元素和为j时是否存在。
 */
public class LC416_CanPartition {
    public boolean canPartition(int[] nums) {
        int target = 0;
        int sum = 0;
        int n = nums.length;
        for(int num : nums){
            sum += num;
        }
        if(sum % 2 != 0)    return false;
        target = sum / 2;
        boolean[][] dp = new boolean[n + 1][target + 1];
        dp[0][0] = true;
        for(int i = 1;i <= n ;i++){
            for(int j = 1;j <= target;j++){
                if(nums[i - 1] > j){ //大于j，不加入
                    dp[i][j] = dp[i - 1][j];
                }else{//加入或者不加入中选择
                    dp[i][j] = dp[i - 1][j - nums[i - 1]] || dp[i - 1][j];
                }
            }
        }
        return dp[n][target];
    }
    public boolean canPartition2(int[] nums) {
        int target = 0;
        int sum = 0;
        int n = nums.length;
        for(int num : nums){
            sum += num;
        }
        if(sum % 2 != 0)    return false;
        target = sum / 2;
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;
        for(int i = 0; i < n; i++){
            /*
            for(int j = nums[i]; j <= target; j++){
                dp[j] = dp[j] || dp[j - nums[i]];
            }
            */
            //从后往前遍历是为了不利用dp[j-nums[i]],因为只能选择一次
            for(int j = target; j >= nums[i]; j--){
                dp[j] = dp[j] || dp[j - nums[i]];
            }
        }
        return dp[target];
    }
}
