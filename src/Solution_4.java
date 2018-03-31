import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User：by gyw
 * Date：2018/3/27
 * Time：22:51
 */
/*有两个大小为 m 和 n 的排序数组 nums1 和 nums2 。

        请找出两个排序数组的中位数并且总的运行时间复杂度为 O(log (m+n)) 。

        示例 1:

        nums1 = [1, 3]
        nums2 = [2]

        中位数是 2.0


        示例 2:

        nums1 = [1, 2]
        nums2 = [3, 4]

        中位数是 (2 + 3)/2 = 2.5*/
public class Solution_4 {

    public static void main(String[] args) {
        int[] a=new int[]{1,2};
        int[] b=new int[]{3,4};
        System.out.println(findMedianSortedArrays(a,b));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double d=0;         //思路是把两个排序数组合并为一个数组再找中位数
        int length=nums1.length+nums2.length;
        int[] num=new int[length];
        for (int i=0;i<nums1.length;i++){
            num[i]=nums1[i];
        }
        for (int i = nums1.length; i <length ; i++) {
            num[i]=nums2[i-nums1.length];
        }
        Arrays.sort(num);   //对新的数组排序
        if(num.length%2==0){
            d=((double) num[num.length/2]+(double) num[num.length/2-1])/(double)2;
        }else {
            d=(double) num[num.length/2];

        }
        return d;
    }
}
