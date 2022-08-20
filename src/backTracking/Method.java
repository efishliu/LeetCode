package backTracking;
/*
    回溯法专题总结     for循环横向遍历，递归纵向遍历，回溯不断调整结果集
    1.组合问题: 从n个数中按一定的规则找出k个数的集合 组合问题推荐递归思想做法，设置index可以进行去重
        1.1 组合 LC77 从数组中选择数字组合成长度为k的集合，有两种思路，第一种方法是基于递归思想，第二种基于路径回溯(当前选或者不选)
        1.2 组合总和III LC216   从1-9选出长度为k且和为n的组合，只能取一次
        1.3 电话号码的组合 LC17
        1.4 组合总和    LC39    数组中的元素可以重复取，并且组合为某个数
        1.5 组合总和II ⭐ LC40   数组中元素只能取一次，但元素存在重复，并且不能包含重复的组合   采用一个Boolean数组记录当前所在的层和之前元素的选取情况
            解决思路 要保证同一层的元素不能选取重复

    2.排列问题: n个数按一定的规则全排列
        2.1 全排列 LC46    只选一次，没有重复数字，返回所有全排列
        2.2 全排列II   LC47    只选一次，包含重复数字，返回不含重复的全排列

    3.分割问题
        3.1 分割回文子串  LC131   返回所有子串为回文串的所有分割方案
        3.2 复原IP地址  LC93    将字符串切割成IP地址 利用回溯进行切割，然后进行判断

    4.子集问题
        4.1 子集  LC78  不含重复数的子集集合
        4.2 递增子序列   LC491   子集递增的所有情况

    5.棋盘问题
        5.1 N皇后问题   LC51
        5.2 解数独 LC37




    回溯法模板：
    方法一：
        result = []
        backTrack(buffer){
            if(结束条件)
                result.add(new buffer)
                return
            for 选择
                //做选择
                buffer.add(选择)
                //下一层回溯
                backTrack(buffer)
                //撤销当前选择，回溯
                buffer.removeLast()

    方法二：
    result = []
        backTrack(buffer){
            if(结束条件)
                result.add(new buffer)
                return
            //不选择当前数字
            backTrack(buffer)
            //选择当前数字
            buffer.add(选择)
            backTrack(buffer)
            buffer.removeLast()
    }


    组合问题： index回溯 + 剪枝

    组合和排列中，如果数组中存在重复元素，返回组合或排列的方法：
        定义一个visited数组记录当前的选取情况
        for(int i = ..; i < n; i++)
            if(i > 0 && nums[i] == nums[i - 1] && visited[i - 1] == false)
                continue;
        //核心：在同一层选取时去除已经遍历过的相同元素， visited[i - 1] == false 则表明当前层i不能作为起始节点
 */
public class Method {

}
