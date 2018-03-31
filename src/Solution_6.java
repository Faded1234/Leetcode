/**
 * Created with IntelliJ IDEA.
 * User：by gyw
 * Date：2018/3/29
 * Time：22:51
 */


/**
 * Created by gyw on 2018/3/28.
 */
/*将字符串 "PAYPALISHIRING" 以Z字形排列成给定的行数：（下面这样的形状）

P   A   H   N
A P L S I I G
Y   I   R
之后按逐行顺序依次排列："PAHNAPLSIIGYIR"
0     6
1 4   7
2   5 8
3     9


实现一个将字符串进行指定行数的转换的函数:

string convert(string text, int nRows);
convert("PAYPALISHIRING", 3) 应当返回 "PAHNAPLSIIGYIR" 。
*/
public class Solution_6 {
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
        for (int i = 0; i <numRows ; i++) {         //外层循环总共有多少行
            for (int j=0;j<length;j++)              //内层循环
            if(j%cyc==i||j%cyc==cyc-i){             //如果字符串对周期cyc取余后的结果无非是0、1、2....、cyc-1
                sb.append(String.valueOf(s.charAt(j)));     //可以根据取余的结果进行分类直接添加到StringBuffer中
            }
        }

        return sb.toString();


    }
}

