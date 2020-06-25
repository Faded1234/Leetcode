package solutionPage1;

public class Solution_50 {
    /**
     * 实现 pow(x, n) ，即计算 x 的 n 次幂函数。
     *
     * 示例 1:
     *
     * 输入: 2.00000, 10
     * 输出: 1024.00000
     * 示例 2:
     *
     * 输入: 2.10000, 3
     * 输出: 9.26100
     */
    public double myPow(double x, int n) {
        // Deal with corner case
        if (x == 0) return 0.0;
        if (n == 0) return 1.0;

        double ans = 1.0;
        // Seperate positive and negative cases:
        if (n > 0) {
            ans = myPowRecursive(x, n);
            return ans;
        } else {
            ans = x * myPowRecursive(x, -(n + 1));
            return 1.0 / ans;
        }
    }

    public double myPowRecursive(double x, int n) {
        if (n == 0) return 1.0;
        if (n == 1) return x;
        double res;
        res = myPowRecursive(x, n/2);
        if (n % 2 == 1)
            return x * res * res;
        else
            return res * res;
    }
}
