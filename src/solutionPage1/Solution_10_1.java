package solutionPage1;

/**
 * Created with IntelliJ IDEA.
 * User：by gyw
 * Date：2018/3/30
 * Time：22:51
 */
public class Solution_10_1 {
    public static void main(String[] args) {
        System.out.println(isMatch("abbc","a*c"));
    }
    //本题可以用递归来实现 讲个冷笑话 人理解迭代，神理解递归  哈哈哈哈哈哈哈
    //本题是粘贴其他人的没有理解欢迎大神求解
    public static boolean isMatch(String s, String p) {
        if (p.isEmpty()) return s.isEmpty();

        boolean firstMatch = !s.isEmpty() && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.');

        if (p.length() >= 2 && p.charAt(1) == '*') {
            return isMatch(s, p.substring(2))||(firstMatch&&isMatch(s.substring(1),p));
        } else {
            return firstMatch && isMatch(s.substring(1), p.substring(1));
        }
    }
}
