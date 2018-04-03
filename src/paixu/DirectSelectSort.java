package paixu;

/**
 * Created with IntelliJ IDEA.
 * User：by gyw
 * Date：2018-03-31 21:10
 */
public class DirectSelectSort
{

    public static void main(String[] args)
    {
        int[] a = { 49, 38, 65, 97, 76, 13, 27, 49, 78, 34, 12, 64, 1, 8 };
        System.out.println("排序之前：");
        for (int i = 0; i < a.length; i++)
        {
            System.out.print(a[i] + " ");
        }
        // 直接选择排序
        for (int i = 0; i < a.length; i++)
        {
            int min = a[i];
            int n = i; // 最小数的索引
            for (int j = i + 1; j < a.length; j++)
            {
                if (a[j] < min)
                { // 找出最小的数
                    min = a[j];
                    n = j;
                }
            }
            a[n] = a[i];
            a[i] = min;

        }
        System.out.println();
        System.out.println("排序之后：");
        for (int i = 0; i < a.length; i++)
        {
            System.out.print(a[i] + " ");
        }

    }

}