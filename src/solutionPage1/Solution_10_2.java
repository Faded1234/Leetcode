package solutionPage1;

import java.util.regex.Pattern;

/**
 * Created with IntelliJ IDEA.
 * User：by gyw
 * Date：2018/3/30
 * Time：22:51
 */
public class Solution_10_2 {
    public static void main(String[] args) {

    }
    public static boolean isMatch(String s, String p) {
        return Pattern.matches(p,s);    //苦笑.jpg  利用java的正则可以直接实现
    }
}
