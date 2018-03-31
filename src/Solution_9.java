/**
 * Created with IntelliJ IDEA.
 * User：by gyw
 * Date：2018/3/23
 * Time：22:51
 * 判断一个数字是不是回文数
 */
public class Solution_9 {
    public static void main(String[] args) {
        System.out.println(        new Solution_9().isPalindrome(2222));

    }
    public boolean isPalindrome(int x) {
        Integer abs = Math.abs(x);  //把负数转为正数 排查负数
        long res=0;
        while (true){       //总体思想是反转数字
            int n=abs%10;   //n表示abs个位数是几
            res=res*10+n;
            abs=abs/10;     //去除一个个位数
            if (abs==0){
                break;
            }
        }
        if (res==x){
            return true;
        }
        return false;
    }
}
