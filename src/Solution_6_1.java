import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * User：by gyw
 * Date：2018/3/26
 * Time：22:51
 */
public class Solution_6_1 {
    public static void main(String[] args) {
        Solution_6_1 Solution_6_1=new Solution_6_1();
        int abcdeb123456789 = Solution_6_1.lengthOfLongestSubstring("abcdeb12345678b");
        System.out.println(abcdeb123456789);
    }
    public int lengthOfLongestSubstring(String s) {
        if (s.length()==0) return 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int max=0;
        for (int i=0, j=0; i<s.length(); ++i){
            if (map.containsKey(s.charAt(i))){
                j = Math.max(j,map.get(s.charAt(i))+1);
            }
            map.put(s.charAt(i),i);
            max = Math.max(max,i-j+1);
        }
        return max;
    }
}
