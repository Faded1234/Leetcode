package solutionPage1;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User：by gyw
 * Date：2018-04-04 12:48
 * 欢迎关注github https://github.com/Faded1234/Leetcode
 * 编写一个函数来查找字符串数组中最长的公共前缀字符串。
 * 给出字符串数组,查找这个数组中所有字符串的最长公共前缀
 * example 1
     input: ['asdqowi','asdb', 'asdmnc']
     output: 'asd'
 */
public class Solution_14 {
    public static void main(String[] args) {
        String[] s=new String[]{"c","c"};
        System.out.println(longestCommonPrefix(s));

    }
    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0)
            return "";
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++)
            while (strs[i].indexOf(prefix) != 0) {                      //返回一个整数值，指出 String 对象内子字符串的开始位置。如果没有找到子字符串，则返回-1。
                prefix = prefix.substring(0, prefix.length() - 1);      //子字符串开始位置不为0则缩小子字符串，再进行对比
                if (prefix.isEmpty()) return "";
            }
        return prefix;
    }
}
