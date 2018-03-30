/**
 * Created with IntelliJ IDEA.
 * User：by gyw
 * Date：2018/3/29
 * Time：22:51
 */


/**
 * Created by gyw on 2018/3/28.
 */
public class Solution_9 {
    public static void main(String[] args) {
        System.out.println(convert("0123456789",4));
    }
    public static String convert(String s, int numRows) {
        if (numRows == 1) return s;
        int length = s.length();
        int cyc=0;      //一个周期的长度
        cyc=numRows+numRows-2;
        int k=0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <numRows ; i++) {
            for (int j=0;j<length;j++)
            if(j%cyc==i||j%cyc==cyc-i){
                sb.append(String.valueOf(s.charAt(j)));
            }
        }

        return sb.toString();


    }
}

