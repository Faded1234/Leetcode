/**
 * Created with IntelliJ IDEA.
 * User：by gyw
 * Date：2018/3/29
 * Time：22:51
 */
public class Solution_10 {
/*    '.' 匹配任意单个字符。
            '*' 匹配零个或多个前面的元素。*/
/*    isMatch("aa","a") → false
    isMatch("aa","aa") → true
    isMatch("aaa","aa") → false
    isMatch("aa", "a*") → true
    isMatch("aa", ".*") → true
    isMatch("ab", ".*") → true
    isMatch("aab", "c*a*b") → true*/
    public static void main(String[] args) {
        System.out.println(isMatch("ab",".*"));
    }
    public static boolean isMatch(String s, String p) {
        //p匹配结束，观察s是否也结束
        if(p.length() == 0)
            return s.length() == 0;

        //p下一个字符不存在连续匹配情况*，直接进行比较，并递归到第二项之后的子串
        if(p.length() == 1 || p.charAt(1) != '*')
        {
            if(s.length() != 0 && (p.charAt(0) == s.charAt(0) || p.charAt(0) == '.'))
                return isMatch(s.substring(1), p.substring(1));
            else
                return false;
        }

        //p下一个字符存在连续匹配情况*，比较首项，并且递归进行比较
        while(s.length() != 0 && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.'))
        {
            if(isMatch(s, p.substring(2)))
                return true;
            s = s.substring(1);
        }
        return isMatch(s, p.substring(2));
    }
}
