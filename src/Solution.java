/**
 * Created with IntelliJ IDEA.
 * User：by gyw
 * Date：2018/3/23
 * Time：22:51
 */
class Solution {
    public static void main(String[] args) {
        Solution so =new Solution();
        System.out.println(so.countDigitOne(5));
        System.out.println(so.countDigitOne(31));
//        System.out.println(so.countDigitOne(521));
    }
        public int countDigitOne(int n) {
            int res = 0;
            for (long k = 1; k <= n; k *= 10) {
                long r = n / k, m = n % k;
                res += (r + 8) / 10 * k + (r % 10 == 1 ? m + 1 : 0);
            }
            return res;
        }
}