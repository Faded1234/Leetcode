package suanfa.HashTable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User：by gyw
 * Date：2018-05-11 14:10
 */
/*
给定一个字符串 s 和一些长度相同的单词 words。在 s 中找出可以恰好串联 words 中所有单词的子串的起始位置。

        注意子串要与 words 中的单词完全匹配，中间不能有其他字符，但不需要考虑 words 中单词串联的顺序。

        示例 1:

        输入:
        s = "barfoothefoobarman",
        words = ["foo","bar"]
        输出: [0,9]
        解释: 从索引 0 和 9 开始的子串分别是 "barfoor" 和 "foobar" 。
        输出的顺序不重要, [9,0] 也是有效答案。
        示例 2:

        输入:
        s = "wordgoodstudentgoodword",
        words = ["word","student"]
        输出: []*/
public class Solution_30 {

    public static void main(String[] args) {

        String[] words = {};
        List<Integer> barfoothefoobarman = findSubstring("barfoothefoobarman", words);
        System.out.println();
    }
    public static List<Integer> findSubstring(String s, String[] words) {
        //欢迎关注github https://github.com/Faded1234/Leetcode
        List<Integer> list = new ArrayList<>();
        if (words.length==0){
            return list;
        }
        int L = s.length(), N = words[0].length();  //L为s的长度，N为一个单词的长度
        int M = N * words.length;   //M是words所有单词的总长度
        if(L == 0 || N == 0 || M > L) return list;
        Map<String, Integer> dict = new HashMap<>();
        for(String word:words) {
            Integer cnt = dict.get(word);
            dict.put(word, cnt == null ? 1 : cnt+1);
        }
        for(int i=0; i<=L-M; i++) {
            String str = s.substring(i, i+M);
            if(containWords(str, words, dict)) {
                list.add(i);
            }
        }
        return list;
    }

    private static boolean containWords(String str, String[] words, Map<String, Integer> dict) {
        int N = words[0].length();
        Map<String, Integer> map = new HashMap<>();
        for(int i=0; i<str.length(); i+=N) {
            String word = str.substring(i, i+N);
            Integer cnt = map.get(word);
            cnt = cnt == null ? 1 : cnt+1;
            map.put(word, cnt);
            if(!dict.containsKey(word) || cnt > dict.get(word)) return false;   //判断map和dict是否是完全一样
        }
        return true;
    }

}
