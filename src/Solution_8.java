import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User：by gyw
 * Date：2018/3/27
 * Time：22:51
 */
public class Solution_8 {

    public static void main(String[] args) {
        int[] a=new int[]{1,2};
        int[] b=new int[]{3,4};
        System.out.println(findMedianSortedArrays(a,b));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double d=0;
        int length=nums1.length+nums2.length;
        int[] num=new int[length];
        for (int i=0;i<nums1.length;i++){
            num[i]=nums1[i];
        }
        for (int i = nums1.length; i <length ; i++) {
            num[i]=nums2[i-nums1.length];
        }
        Arrays.sort(num);
        if(num.length%2==0){
            d=((double) num[num.length/2]+(double) num[num.length/2-1])/(double)2;
        }else {
            d=(double) num[num.length/2];

        }
        return d;
    }
}
