package solutionPage1;

import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * User：by gyw
 * Date：2018/3/26
 */
/*给定一个字符串，找出不含有重复字符的 最长子串 的长度。

        示例：

        给定 "abcabcbb" ，没有重复字符的最长子串是 "abc" ，那么长度就是3。

        给定 "bbbbb" ，最长的子串就是 "b" ，长度是1。

        给定 "pwwkew" ，最长子串是 "wke" ，长度是3。请注意答案必须是一个子串，"pwke" 是 子序列 而不是子串。*/


public class Solution_3_1 {
    public static void main(String[] args) {
        Solution_3_1 Solution_6_1=new Solution_3_1();
        int abcdeb123456789 = Solution_6_1.lengthOfLongestSubstring("abcdeb12345678b");
        //会有一个特别长的测试用例
        System.out.println(abcdeb123456789);
    }
    public int lengthOfLongestSubstring(String s) {
        if (s.length()==0) return 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();//利用hashmap的key不能重复来保存不重复的最长字符串
        int max=0;
        for (int i=0, j=0; i<s.length(); ++i){
            if (map.containsKey(s.charAt(i))){          //判断字符是否已经存在 如果存在在这两个长字符串中取最大值
                j = Math.max(j,map.get(s.charAt(i))+1); //j用来记录最长字符串的起始位置
            }
            map.put(s.charAt(i),i);
            max = Math.max(max,i-j+1);
        }
        return max;
    }
}
