/**
 * 给定一个字符串 (s) 和一个字符模式 (p) ，实现一个支持 '?' 和 '*' 的通配符匹配。
 *
 * '?' 可以匹配任何单个字符。
 * '*' 可以匹配任意字符串（包括空字符串）。
 */
public class Solution_44 {
    public static void main(String[] args) {
        String s = "abbbc";
        String p = "a*?c";
        isMatch(s,p);
    }
    public static boolean isMatch(String s, String p) {
        //starj记录上一个"*"的位置
        //match记录与"*"匹配的i的位置(与starj不同的是，每次回溯，match自增)
        int i = 0, j = 0, starj = -1, match = 0;

        while(i < s.length()){
            //字符相等或者p.charAt(j) == '?'
            if(j < p.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?')){
                i++;
                j++;
                //遇到'*', 记录'*'的位置，并记录starj和match
            }else if(j < p.length() && p.charAt(j) == '*'){
                starj = j;
                j++;
                match = i;
                //不是上述两种情况，无法匹配，因此回溯
                //注意，若出现第二个'*'， 会对之前的覆盖，因为已经不需要用之前的"*"进行回溯了
            }else if(starj != -1){
                j = starj + 1;
                match++;
                i = match;
                //其他情况， 直接返回false
            }else{
                return false;
            }
        }
        //清除'*'
        while(j < p.length() && p.charAt(j) == '*') j++;
        //若p清空，说明匹配
        return j == p.length();
    }
}
