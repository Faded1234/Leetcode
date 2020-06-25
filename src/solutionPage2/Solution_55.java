public class Solution_55 {
    public static void main(String[] args) {
        int[] nums = new int[]{1,3,4,1,1,0,4};
        canJump(nums);
    }
    public static boolean canJump(int[] nums) {
        int lastPos = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i + nums[i] >= lastPos) {
                lastPos = i;
            }
        }
        return lastPos == 0;
    }
}
