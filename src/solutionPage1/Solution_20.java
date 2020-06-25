package solutionPage1;

import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * User：by gyw
 * Date：2018-04-08 10:19
 */
/*给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。

        括号必须以正确的顺序关闭，"()" 和 "()[]{}" 是有效的但是 "(]" 和 "([)]" 不是。*//*给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。

        括号必须以正确的顺序关闭，"()" 和 "()[]{}" 是有效的但是 "(]" 和 "([)]" 不是。*/
public class Solution_20 {
    public static void main(String[] args) {
        String s1 = "{[()]}";
        System.out.println(isValid(s1));
        String s2 = "456";
        System.out.println(isValid(s2));
        String s3 = "";
        System.out.println(isValid(s3));
        String s4 = "{)";
        System.out.println(isValid(s4));
        String s5 = "{{{";
        System.out.println(isValid(s5));
    }
    public static boolean isValid(String s) {
        //欢迎关注github https://github.com/Faded1234/Leetcode
        if (s==""||s.length()==0){
            return false;
        }
        Stack<Character> st = new Stack<>();
        boolean flag = true;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i)=='('||s.charAt(i)=='['||s.charAt(i)=='{'){  //如果是'(' '{' '[' 则入栈
                st.push(s.charAt(i));
            }else if(s.charAt(i)==')'&&!st.empty()){               //如果是')' 判断栈是否为空 为空直接返回false，循环结束
                if (st.peek()=='('){                    //当不为空的时候判断栈顶是不是对应的符号，如果是则出栈
                    st.pop();
                }else {                                 //如果不是则返回false，循环结束
                    flag = false;
                    break;
                }
            }else if(s.charAt(i)==']'&&!st.empty()) {
                if (st.peek() == '[') {
                    st.pop();
                } else {
                    flag = false;
                    break;
                }
            }else if(s.charAt(i)=='}'&&!st.empty()) {
                if (st.peek() == '{') {
                    st.pop();
                } else {
                    flag = false;
                    break;
                }
            }else {
                flag = false;
                break;
            }
        }
        if (!st.empty()){
            flag=false;
        }
        return flag;
    }
}
