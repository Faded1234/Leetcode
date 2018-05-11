import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User：by gyw
 * Date：2018-04-10 17:21
 */
/*
实现 strStr()。
        返回蕴含在 haystack 中的 needle 的第一个字符的索引，如果 needle 不是 haystack 的一部分则返回 -1 。
        例 1:
        输入: haystack = "hello", needle = "ll"
        输出: 2
        例 2:
        输入: haystack = "aaaaa", needle = "bba"
        输出: -1
*/
public class Solution_28 {
    public static void main(String[] args) {
        int i = strStr("122323", "23");
        System.out.println(i);
    }
    public static int strStr(String haystack, String needle) {
        //欢迎关注github https://github.com/Faded1234/Leetcode
        //这个很巧妙当j==needle.length 此时的i就是开始的位置
        for (int i = 0; ; i++ ) {
            for (int j=0; ; j++) {
                if (j == needle.length())
                    return i;
                if (i + j == haystack.length()) //此时needle的长度大于剩余要比较的长度
                    return -1;
                if (needle.charAt(j) != haystack.charAt(i+j)) //如果比较时不匹配直接结束内层循环
                    break;

            }
        }
    }
}
