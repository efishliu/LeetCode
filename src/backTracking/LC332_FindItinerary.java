package backTracking;

import java.util.*;

/*
    题目：重写安排行程
    难度：hard
    给你一份航线列表 tickets ，其中 tickets[i] = [fromi, toi] 表示飞机出发和降落的机场地点。请你对该行程进行重新规划排序。
    所有这些机票都属于一个从 JFK（肯尼迪国际机场）出发的先生，所以该行程必须从 JFK 开始。
    如果存在多种有效的行程，请你按字典排序返回最小的行程组合。
    例如，行程 ["JFK", "LGA"] 与 ["JFK", "LGB"] 相比就更小，排序更靠前。
    假定所有机票至少存在一种合理的行程。且所有的机票 必须都用一次 且 只能用一次。
        输入：tickets = [["MUC","LHR"],["JFK","MUC"],["SFO","SJC"],["LHR","SFO"]]
        输出：["JFK","MUC","LHR","SFO","SJC"]
    链接：https://leetcode-cn.com/problems/reconstruct-itinerary
 */
public class LC332_FindItinerary {
    public List<String> findItinerary(List<List<String>> tickets) {
        List<String> ans = new LinkedList<>();
        Map<String, TreeMap<String, Integer>> map = new HashMap<>();
        for(List<String> ticket : tickets){

        }
        return ans;
    }
}
