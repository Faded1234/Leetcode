package solutionPage1;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User：by gyw
 * Date：2018-04-08 16:22
 */
/*给出 n 代表生成括号的对数，请你写出一个能够生成所有可能括号组合的函数。

        比如，给出 n = 3，则生成结果为：

        [
        "((()))",
        "(()())",
        "(())()",
        "()(())",
        "()()()"
        ]*/
public class Solution_22 {
    public static void main(String[] args) {
        List<String> list = generateParenthesis(3);
        System.out.println();
    }
    public static List<String> generateParenthesis(int n) {
        //欢迎关注github https://github.com/Faded1234/Leetcode
        List<String> list = new ArrayList<>();
        if (n<=0){
            return list;
        }
        int left=n;
        int right=n;
        char[] chars = new char[2*n];
        work(list,n,n,chars,0);
        return list;
    }

    private static void work(List<String> list, int n1, int n2, char[] chars,int count) {
        if(n1 < 0 || n2 < n1) {   // 无效输入
            return ;
        }
        if(n1 == 0 && n2 == 0) { // 没有括号了
            String s = String.copyValueOf(chars);
            list.add(s);
        }else {
            if(n1 > 0) {    // 还有左括号可用则加入左括号
                chars[count] = '(';
                work(list, n1 - 1, n2, chars, count + 1);
            }
            if(n2 > n1) { // 右括号比左括号跟多就可以加入右括号
                chars[count] = ')';
                work(list, n1, n2 - 1, chars, count + 1);
            }
        }

    }
}
