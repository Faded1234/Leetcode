/**
 * Created with IntelliJ IDEA.
 * User：by gyw
 * Date：2018-05-13 14:30
 */
public class Solution_35 {
    public static void main(String[] args) {
        int[] nums = new int[]{1,3,6,7};
        int target=7;
        int i = searchInsert(nums, target);
        System.out.println(i);
    }
    public static int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int mid = 0;

        while (left <= right) {
            mid = (left + right) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                return mid;
            }
        }

        return left;
    }
}
