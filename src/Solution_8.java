/**
 * Created with IntelliJ IDEA.
 * User：by gyw
 * Date：2018/3/29
 * Time：22:51
 */
/*实现 atoi，将字符串转为整数。

        提示：仔细考虑所有输入情况。如果你想挑战自己，请不要看下面并自己考虑所有可能的输入情况。

        说明：这题解释的比较模糊（即没有指定输入格式）。你得事先汇集所有的输入情况。



        atoi的要求：

        这个函数需要丢弃之前的空白字符，直到找到第一个非空白字符。之后从这个字符开始，选取一个可选的正号或负号后面跟随尽可能多的数字，并将其解释为数字的值。

        字符串可以在形成整数的字符后包括多余的字符，将这些字符忽略，这些字符对于函数的行为没有影响。

        如果字符串中的第一个非空白的字符不是有效的整数，或者没有这样的序列存在，字符串为空或者只包含空白字符则不进行转换。

        如果不能执行有效的转换，则返回 0。如果正确的值超过的可表示的范围，则返回 INT_MAX（2147483647）或 INT_MIN（-2147483648）。*/
public class Solution_8 {
    public static void main(String[] args) {
        System.out.println(myAtoi("-+-2"));
    }
    public static int myAtoi(String str) {  //此题主要是对题意的理解，要求是找整数
        if(str==null||str.length()==0)      //即去除空格后第一个字符应该是'+'或者'-'然后后面跟着一个数所以如果不是就可以直接终止循环
            return 0;                                       //
        char[] array = str.toCharArray();
        long result = 0; // 要返回的结果result此处为long防止越界
        int count = 0; // 记录‘+'或者‘-'出现的次数
        int num = 0;  // 判断空格出现的位置
        int flag = 1; // 正数还是负数
        for (int i = 0; i < array.length; i++) {
            Character c = array[i];
            if(Character.isDigit(c)){
                result = result*10+Character.getNumericValue(c);
                if(flag==1&&result>Integer.MAX_VALUE){
                    return Integer.MAX_VALUE;
                }else if(flag==-1&&-result<Integer.MIN_VALUE)
                    return Integer.MIN_VALUE;
                num++;
            }else if(Character.isSpaceChar(c)&&num==0&&count==0)
                continue;
            else if(c=='+'&&count==0){
                count = 1;
            }
            else if(c=='-'&&count==0){
                flag = -1;
                count = 1;
            }
            else{
                return (int) (flag*result);

            }
        }
        return (int) (flag*result);
    }
}
