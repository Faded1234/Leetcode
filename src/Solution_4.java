/**
 * Created with IntelliJ IDEA.
 * User：by gyw
 * Date：2018/3/23
 * Time：22:51
 * 判断一个数字是不是回文数
 */
public class Solution_4 {
    public static void main(String[] args) {
        System.out.println(        new Solution_4().isPalindrome(2222));

    }
    public boolean isPalindrome(int x) {
        Integer abs = Math.abs(x);
        long res=0;
        while (true){
            int n=abs%10;
            res=res*10+n;
            abs=abs/10;
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
