import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User：by gyw
 * Date：2018-05-13 11:14
 */
public class Solution_34 {
    public static void main(String[] args) {
        int[] nums = new int[]{5,7,7,8,8,10};
        int target =8;
        int[] ints = searchRange(nums, target);
        System.out.println();
    }
    public static int[] searchRange(int[] nums, int target) {
        int max = nums.length - 1;
        int begin = 0;
        int end = max;

        while (begin < max && nums[begin] != target) {
            begin++;
        }

        while (end > -1 && nums[end] != target) {
            end--;
        }

        if (end < begin) {
            return new int[] { -1, -1 };
        } else {
            return new int[] { begin, end };
        }
    }
}
