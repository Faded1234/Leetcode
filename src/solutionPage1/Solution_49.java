package solutionPage1;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;

import static java.util.Arrays.*;

public class Solution_49 {
    /**
     * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
     *
     * 示例:
     *
     * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
     * 输出:
     * [
     *   ["ate","eat","tea"],
     *   ["nat","tan"],
     *   ["bat"]
     * ]
     */

    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) return  new ArrayList<List<String>>();

        Map<String,List<String>> map = new HashMap<String, List<String>>();
        for (String s:strs){
            char[] ca = s.toCharArray();
            sort(ca);        //从小到大排序
            String keyStr = String.valueOf(ca);
            if (!map.containsKey(keyStr)){
                map.put(keyStr,new ArrayList<String>());
            }
            map.get(keyStr).add(s);
        }

        return new ArrayList<List<String>>(map.values());
    }
}
