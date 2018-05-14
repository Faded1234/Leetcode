/**
 * Created with IntelliJ IDEA.
 * User：by gyw
 * Date：2018-05-14 17:07
 */
public class Solution_38 {
    public static void main(String[] args) {
        String s = countAndSay(2);
        System.out.println(s);
    }
    public static String countAndSay(int n) {
        if (n==0){
            return null;
        }

        if (n==1){
            return  "1";
        }
        //递归调用，然后对字符串处理
        String str = countAndSay(n-1) + "*";//为了str末尾的标记，方便循环读数
        char[] c = str.toCharArray();
        int count = 1;
        String s = "";
        for(int i = 0; i < c.length - 1;i++){
            if(c[i] == c[i+1]){
                count++;//计数增加
            }else{
                s = s + count + c[i];//上面的*标记这里方便统一处理
                count = 1;//初始化
            }
        }
        return s;
    }
}
