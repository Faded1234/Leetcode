import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User：by gyw
 * Date：2018/3/26
 * Time：22:51
 */
public class Solution_13 {
    public static void main(String[] args) {
        Solution_13 so =new Solution_13();

        System.out.println(so.romanToInt("DCXXI"));
    }
    // I           1
    // V           5
    // X           10
    // L           50
    // C           100
    // D           500
    // M           1000
    public int romanToInt(String s) {
        Map<Character, Integer> m = new HashMap<Character, Integer>();
        m.put('I', 1);
        m.put('V', 5);
        m.put('X', 10);
        m.put('L', 50);
        m.put('C', 100);
        m.put('D', 500);
        m.put('M', 1000);
        if (s.length()==1&&s.equals("I")){
            return 1;
        }
        int n=m.get(s.charAt(s.length()-1));

        for (int i = s.length()-1; i >= 1 ; i--) {

            if(m.get(s.charAt(i))>m.get(s.charAt(i-1))){
                n=n-m.get(s.charAt(i-1));
            }else {
                n+=m.get(s.charAt(i-1));
            }
        }
        return n;
    }
}
