import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User：by gyw
 * Date：2018/3/23
 * Time：22:51
 */
public class Solution_1 {
    public int[] twoSum(int[] nums, int target) {
        int[] data = new int[nums.length];
        for(int i = 0;i<data.length;i++){
            data[i] = nums[i];
        }
        int[] result = new int[2];
        Arrays.sort(nums);
        for(int left=0,right=nums.length-1;left<right;){
            if(nums[left]+nums[right]<target){
                left++;
            }
            else if(nums[left]+nums[right]>target){
                right--;
            }
            else{
                result[0] = nums[left];
                result[1] = nums[right];
                break;
            }
        }
        for(int i = 0;i<nums.length;i++){
            if(data[i]==result[0]){
                result[0] = i;
                break;
            }
        }
        for(int i = 0;i<nums.length;i++){
            if(data[i]==result[1]&&i!=result[0]){
                result[1] = i;
                break;
            }
        }
        return result;
    }
}
