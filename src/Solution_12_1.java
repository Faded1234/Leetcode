/**
 * Created with IntelliJ IDEA.
 * User：by gyw
 * Date：2018-04-01 18:16
 */
/*给定一个整数，将其转为罗马数字。
        输入保证在 1 到 3999 之间。*/
// I           1
// V           5
// X           10
// L           50
// C           100
// D           500
// M           1000
public class Solution_12_1 {
    public static void main(String[] args) {
        intToRoman(1437);
    }
    public static String intToRoman(int num) {
        String str="";
        String symbol[]={"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        int value[]=    {1000,900,500,400, 100, 90,  50, 40,  10, 9,   5,  4,   113};
        while (num!=0){
            for (int i = 0; i < 13; i++) {

            }
        }
        return str;
    }
}
