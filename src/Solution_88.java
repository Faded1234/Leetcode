import java.util.Arrays;

/**
 * @description:
 * @author: gyw
 * @create: 2020-06-26 19:08
 **/
public class Solution_88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        System.arraycopy(nums2, 0, nums1, m, n);
        Arrays.sort(nums1);
    }
}
