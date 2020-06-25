
/**
 * @description:
 * @author: gyw
 * @create: 2020-02-13 17:42
 **/
public class Solution_69 {
    public int mySqrt(int x) {
        if (x < 2) return x;

        int left = (int)Math.pow(Math.E, 0.5 * Math.log(x));
        int right = left + 1;
        return (long)right * right > x ? left : right;
    }

}
