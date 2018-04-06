import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User：by gyw
 * Date：2018-04-06 12:56
 * 欢迎关注github https://github.com/Faded1234/Leetcode
 */
public class Solution_17 {
    public static void main(String[] args) {
        List<String> list = letterCombinations("23");
        System.out.println();
    }
    public static List<String> letterCombinations(String digits) {
        List<String> list = new ArrayList<>();
        if(digits.length()<1||digits==null){
            return  list;
        }
        if (isInt(digits)==false){  //判断是否包含非法字符
            return list;
        }

        HashMap<Character,String> map = new HashMap<>();
        map.put('0',"");
        map.put('1',"");
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");
        char[] ch = new char[digits.length()];
        work(digits,0,ch,list,map);
        return list;
    }
    //递归实现 递归的关键是终止条件，分析当digits为个位数时可知当指针index=digits.length()时递归终止
    public static void work(String digits, int index, char[] ch,  List<String> res, HashMap<Character, String> hm){
        if(index == digits.length()){  // 如果成立，表明已经连接到最后一个数字了，因此要将结果加入res
            res.add(new String(ch));
            return;
        }
        char c = digits.charAt(index);  //index对应的数字也就是map对应的key
        for(int i = 0; i < hm.get(c).length(); i++){  //
            ch[index] = hm.get(c).charAt(i);  // 获取index所对应数字的字符串中的字符
            work(digits, index + 1, ch, res, hm); // 获取下一个数字所对应的字符串中的字符
        }
    }

    private static boolean isInt(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i)<'0'||s.charAt(i)>'9'){
                return false;
            }
        }
        return true;
    }

}
