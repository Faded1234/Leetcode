package suanfa.BinarySearch;

/**
 * Created with IntelliJ IDEA.
 * User：by gyw
 * Date：2018-04-17 15:01
 */
public class Solution_29_1 {
    public static void main(String[] args) {
        int divide = divide(1, 1);
        System.out.println(divide);
    }
    public static int divide(int dividend, int divisor) {
        //欢迎关注github https://github.com/Faded1234/Leetcode
        // 相除时溢出处理
        if (divisor == 0 || dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        // 求符号位
        int sign = ((dividend < 0) ^ (divisor < 0)) ? -1 : 1;

        // 求绝对值，为防止溢出使用long  左移一位相当乘以一个2
        long dvd = Math.abs((long) dividend);
        long dvs = Math.abs((long) divisor);
        // 记录结果
        int result = 0;
        // 被除数大于除数
        while (dvd >= dvs) {
            // 记录除数
            long tmp = dvs;
            // 记录商的大小
            long mul = 1;
            while (dvd >= (tmp << 1)) {
                tmp <<= 1;
                mul <<= 1;
            }
            // 减去最接近dvd的dvs的指数倍的值（值为tmp）
            dvd -= tmp;
            // 修正结果
            result += mul;
        }

        return result * sign;
    }
}
