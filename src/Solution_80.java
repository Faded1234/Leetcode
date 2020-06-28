/**
 * @description:
 * @author: gyw
 * @create: 2020-04-10 17:30
 **/
public class Solution_80 {
    public static void main(String[] args) {
        int[] a = new int[]{1,1,1,1,2,2,2,3,3,4};
        removeDuplicates(a);
    }

    public static int removeDuplicates(int[] nums) {
        int i = 0;
        for (int n : nums) {
            if (i < 2 || n > nums[i-2]){
                nums[i] = n;
                i++;
            }
        }
        return i;
    }

}
