package suanfa.DynamicProgramming;

import java.util.Stack;

/**
 * 动态编程
 *也属于String包下分类
 *
 * Created with IntelliJ IDEA.
 * User：by gyw
 * Date：2018-05-11 21:54
 * 这道题需要注意的是最长的有效的括号
 */
public  class Solution_32 {
    public static void main(String[] args) {
        int i = longestValidParentheses("(())(()");
        System.out.println(i);
    }
    public static int longestValidParentheses(String s) {
        Stack<Character> stack = new Stack<>(); //用栈的思想是很正确的但是进出栈需要保存的应该是i而不是（）
        for(int i = 0 ; i < s.length() ; i++){
            if(s.charAt(i)==')'){   //保存无对应的）和多余的（的位置
                if(!stack.isEmpty() && s.charAt(stack.peek())=='('){
                    stack.pop();
                    continue;
                }
            }
            stack.push((char) i);
        }
        int maxLength = 0;
        int nextIndex = s.length();
        while(!stack.isEmpty()){
            int curIndex = stack.pop();
            int curLength = nextIndex-curIndex-1;
            maxLength = curLength>maxLength ? curLength : maxLength;
            nextIndex = curIndex;
        }
        return Math.max(nextIndex, maxLength);
    }
}
