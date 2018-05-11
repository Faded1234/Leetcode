/**
 * Created with IntelliJ IDEA.
 * User：by gyw
 * Date：2018-04-17 14:08
 */
/*给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。

        返回被除数 dividend 除以除数 divisor 得到的商。
        示例 1:

输入: dividend = 10, divisor = 3
输出: 3
示例 2:

输入: dividend = 7, divisor = -3
输出: -2
说明:

被除数和除数均为 32 位有符号整数。
除数不为 0。
假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−231,  231 − 1]。本题中，如果除法结果溢出，则返回 231 − 1。*/
public class Solution_29 {
    public static void main(String[] args) {
        int divide = divide(-2147483648, -1);
        System.out.println(divide);
    }
    public static int divide(int dividend, int divisor) {
        //欢迎关注github https://github.com/Faded1234/Leetcode
        //没啥好说的，比较简单的思路就是直接加 不过对正负结果要进行判断
        //但是时间复杂度太高
        if(divisor==0||dividend==0) {
            return 0;
        }
        if (dividend==Integer.MIN_VALUE&&divisor==-1){
            return Integer.MAX_VALUE;
        }
        int a = Math.abs(dividend);
        int b = Math.abs(divisor);
        int result=b;
        int retu=0;
        if((dividend<0&&divisor>0)||(dividend>0&&divisor<0)){
            while (result<=a){
                result =result+b;
                --retu;
            }
        }else {
            while (result<=a){
                result =result+b;
                ++retu;
            }
        }

       return retu;
    }
}
