import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User：by gyw
 * Date：2018/3/23
 * Time：22:51
 */
public class Main {
    public static void main(String[] args) {

        int foo = foo(17, 8);
        System.out.println(foo);
    }
    static int foo(int a,int b){
        if(a<=0||b<=0)
            return 1;
        else
            return 3*foo(a-6,b/2);
    }

}
