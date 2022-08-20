package doublePointer;

import java.util.LinkedList;
import java.util.List;

/*
    给你一个字符串 s ，颠倒字符串中 单词 的顺序。
    单词 是由非空格字符组成的字符串。s 中使用至少一个空格将字符串中的 单词 分隔开。
    返回 单词 顺序颠倒且 单词 之间用单个空格连接的结果字符串。
    注意：输入字符串 s中可能会存在前导空格、尾随空格或者单词间的多个空格。
    返回的结果字符串中，单词间应当仅用单个空格分隔，且不包含任何额外的空格。
    输入：s = "the sky is blue"
    输出："blue is sky the"
    链接：https://leetcode-cn.com/problems/reverse-words-in-a-string
。
 */
public class LC151_ReverseWords {
    public String reverseWords(String s) {
        int n = s.length();
        if(n == 0)  return s;

        List<String> res = new LinkedList<>();
        int start = 0;
        int end = 0;
        while(start < n){
            if(s.charAt(start) != ' '){
                end = start;
                while (end < n && s.charAt(end) != ' '){
                    end++;
                }
                res.add(s.substring(start, end));
                start = end;
            }else{
                start++;
            }
        }
        String ans = "";
        for(int i = res.size() - 1; i >= 0; i--){
            ans += res.get(i) + " ";
        }
        return ans.substring(0,ans.length() - 1);
    }

    public String reverseWords2(String s) {
        String[] strs = s.split("/s+");
        return "";
    }

}
