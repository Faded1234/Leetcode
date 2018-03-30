/**
 * Created with IntelliJ IDEA.
 * User：by gyw
 * Date：2018/3/27
 * Time：22:51
 */
public class Solution_7 {
    public static void main(String[] args) {
        Solution_7 solution_7 = new Solution_7();
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
        int max=0;
        for (int i=0;i<s.length();++i){
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
