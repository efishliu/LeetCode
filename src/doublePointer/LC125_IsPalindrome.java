package doublePointer;
/*
    题目：验证回文串
    难度：easy
    给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
    说明：本题中，我们将空字符串定义为有效的回文串。
    输入: "A man, a plan, a canal: Panama"
    输出: true
    解释："amanaplanacanalpanama" 是回文串
    链接：https://leetcode-cn.com/problems/valid-palindrome
 */
public class LC125_IsPalindrome {
    public boolean isPalindrome(String s) {
        int n = s.length();
        if(n == 0 || n == 1)    return true;

        int left = 0;
        int right = n - 1;
        while (left < right){
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))){
                left++;
            }
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))){
                right--;
            }
            if (left < right) {
                if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                    return false;
                }
                ++left;
                --right;
            }
        }
        return true;
    }
}
