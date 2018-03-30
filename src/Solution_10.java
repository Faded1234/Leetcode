/**
 * Created with IntelliJ IDEA.
 * User：by gyw
 * Date：2018/3/29
 * Time：22:51
 */
public class Solution_10 {
    public static void main(String[] args) {
        System.out.println(myAtoi("+-2"));
    }
    public static int myAtoi(String str) {
        if(str==null||str.length()==0)
            return 0;
        char[] array = str.toCharArray();
        long result = 0; // 要返回的结果result
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
