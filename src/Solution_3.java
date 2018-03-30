/**
 * Created with IntelliJ IDEA.
 * User：by gyw
 * Date：2018/3/23
 * Time：22:51
 *
 */
public class Solution_3 {
    public static void main(String[] args) {
        Solution_3 so = new Solution_3();
        System.out.println(so.reverse(321));
        System.out.println(so.reverse(-321));
        System.out.println(so.reverse(1534236469));
        System.out.println(so.reverse(0));
    }
    public int reverse(int x) {
        int a=0;
        if(x>0){
            a = reverses(x);
        }else if(x<1){
            x=-x;
            a = -reverses(x);
        }
        return a;

    }
    static int reverses(int a){
        int renum;
        Integer y = a;
        StringBuffer sb = new StringBuffer(y.toString());
        sb.reverse();
        try{
            renum= Integer.parseInt(sb.toString());

        }catch (Exception e){
            renum=0;
        }
        return renum;
    }
}
