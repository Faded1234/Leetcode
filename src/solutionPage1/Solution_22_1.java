package solutionPage1;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User：by gyw
 * Date：2018-04-08 18:10
 */
public class Solution_22_1 {
    public static void main(String[] args) {
        Solution_22_1 Solution_22_1 = new Solution_22_1();
        List<String> list = Solution_22_1.generateParenthesis(3);
        System.out.println(list);
        System.out.println();
    }
    private List<String> arr =new ArrayList<String>();
    public List<String> generateParenthesis(int n) {
        gen(n,0,0,"");
        return arr;
    }

    public void gen(int n,int left,int right,String str){
        //这个也是别人写的，逻辑和代码都是非常的清晰，非常值得学习研究
        //不知道为什么，看递归的时候有一个莫名的想法，儿孙自有儿孙福 （儿孙是调用递归函数 “福”则是那终止条件）
        if(right==n){
            arr.add(str);
        }
        if(left<n){
            gen(n,left+1,right,str+"(");
        }
        if(right<left){
            gen(n,left,right+1,str+")");
        }
    }
}
