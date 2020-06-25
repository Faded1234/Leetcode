package solutionPage1;

/**
 * Created by gyw on 2018/4/3.
 *  因为数字不是很大所以，我们可以采用直接列举的方法
 *  欢迎关注github https://github.com/Faded1234/Leetcode
 */
public class Solution_12_1 {
    public static void main(String[] args) {
        System.out.println(intToRoman(1437));

    }
    public static String intToRoman(int num) {
        String str="";
        String symbol[]={"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        int value[]=    {1000,900,500,400, 100, 90,  50, 40,  10, 9,   5,  4,   1};
        while (num!=0){
            for (int i = 0; i < 13; i++) {
                if(num>=value[i]){
                    num=num-value[i];
                    str=str+symbol[i];
                    break;  //必须及时终止否则得到的结果会不匹配
                }
            }
        }
        return str;
    }

}
