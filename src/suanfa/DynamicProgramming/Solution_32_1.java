package suanfa.DynamicProgramming;

/**
 * Created with IntelliJ IDEA.
 * User：by gyw
 * Date：2018-05-12 22:08
 */
public class Solution_32_1 {
    public int longestValidParentheses(String s) {
        int result=0,i,len=0;       //借鉴的别人的，学习参考
        int[]dp=new int[s.length()];
        for(i=1;i<dp.length;i++){
            if(s.charAt(i)=='(')
                dp[i]=0;
            else{
                len=dp[i-1];
                if((i-len-1>=0)&&s.charAt(i-len-1)=='('){
                    dp[i]=2+dp[i-1];
                    if(i-len-1>0&&dp[i-len-2]>0)
                        dp[i]+=dp[i-len-2];
                }
            }
            result=Math.max(result, dp[i]);
        }
        return result;
    }
}
