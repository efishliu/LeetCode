package backTracking;

import java.util.LinkedList;
import java.util.List;

/*
    题目：复原IP地址
    难度：medium
    有效 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。
    例如："0.1.2.201" 和 "192.168.1.1" 是 有效 IP 地址，
    但是 "0.011.255.245"、"192.168.1.312" 和 "192.168@1.1" 是 无效 IP 地址。
    给定一个只包含数字的字符串 s ，用以表示一个 IP 地址，返回所有可能的有效 IP 地址，
    这些地址可以通过在 s 中插入'.' 来形成。你 不能重新排序或删除 s 中的任何数字。你可以按 任何 顺序返回答案。
    链接：https://leetcode-cn.com/problems/restore-ip-addresses
 */
public class LC93_RestoreIpAddresses {
    public List<String> restoreIpAddresses(String s) {
        List<String> ans = new LinkedList<>();
        dfs(s, 0, new LinkedList<>(), ans);
        return ans;
    }

    public void dfs(String s, int begin, List<String> buffer, List<String> ans){
        if(buffer.size() > 4 || begin > s.length() || (buffer.size() == 4 && begin < s.length())){
            return;
        }
        if(buffer.size() == 4 && begin == s.length()){
            StringBuilder str = new StringBuilder();
            for(String st : buffer){
                str.append(st + ".");
            }
            str.deleteCharAt(str.length() - 1);
            ans.add(str.toString());
            return;
        }

        if(begin + 1 <= s.length() && s.substring(begin, begin + 1).equals("0")){
            buffer.add(s.substring(begin, begin + 1));
            dfs(s, begin + 1, buffer, ans);
            buffer.remove(buffer.size() - 1);
        }else{
            for(int i = 1; i <= 3 && begin + i <= s.length(); i++){
                int num = Integer.parseInt(s.substring(begin, begin + i));
                if(num <= 255){
                    buffer.add(s.substring(begin, begin + i));
                    dfs(s, begin + i, buffer, ans);
                    //System.out.println(buffer);
                    buffer.remove(buffer.size() - 1);
                }else{
                    break;
                }
            }
        }
    }
}
