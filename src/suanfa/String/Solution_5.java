package suanfa.String;

/**
 * Created with IntelliJ IDEA.
 * User：by gyw
 * Date：2018/3/27
 * Time：22:51
 */
/*给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 长度最长为1000。

        示例:

        输入: "babad"

        输出: "bab"

        注意: "aba"也是有效答案


        示例:

        输入: "cbbd"

        输出: "bb"*/
public class Solution_5 {
    public static void main(String[] args) {
        Solution_5 solution_7 = new Solution_5();
        String s = solution_7.longestPalindrome("babad");
        System.out.println(s);
    }
    public String longestPalindrome(String s) {
        String res = "";
        if(s.length()==1){
            return s;
        }
        int k=0;
        int j=0;
        int max=0;      //时间复杂度有点高，思路是若回文串为奇数i为回文字符串中最中间的数kj分别向左向右找最长的回文串
        for (int i=0;i<s.length();++i){                 //若为偶数则假设i为最中间的左边数字，然后再向左向右找最长字符串
            for ( j=i,k=i;k>=0&&j<s.length();++j,--k){
                if (s.charAt(j)==s.charAt(k)&&(j-k+1)>max){
                    max=j-k+1;
                    res=s.substring(k,j+1);
                }else if (s.charAt(j)!=s.charAt(k)){
                    break;
                }
            }
            for (j=i,k=i-1;k>=0&&j<s.length();j++,k--){
                if (s.charAt(j)==s.charAt(k)&&(j-k+1)>max){
                    max=j-k+1;
                    res=s.substring(k,j+1);
                }else if (s.charAt(j)!=s.charAt(k)){
                    break;
                }
            }

        }

        return res;
    }
}
