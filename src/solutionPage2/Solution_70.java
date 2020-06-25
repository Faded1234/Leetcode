package solutionPage2;

/**
 * @description:
 * @author: gyw
 * @create: 2020-02-13 17:42
 **/
public class Solution_70 {

    public int climbStairs( int n) {
        if(n == 1){
            return 1;
        }
        if(n == 2){
            return 2;
        }
        //递归调用，没啥好说的
        return climbStairs(n - 1) + climbStairs(n -2 );

    }

    public int climbStairs2(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }


}
