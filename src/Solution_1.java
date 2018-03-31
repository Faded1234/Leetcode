import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User：by gyw
 * Date：2018/3/23
 * Time：22:51
 * 欢迎关注github https://github.com/Faded1234/Leetcode
 *
 * 给定一个整数数列，找出其中和为特定值的那两个数。
 *你可以假设每个输入都只会有一种答案，同样的元素不能被重用。
 *示例:
 *给定 nums = [2, 7, 11, 15], target = 9
 *因为 nums[0] + nums[1] = 2 + 7 = 9
 *所以返回 [0, 1]
 */
public class Solution_1 {
    public int[] twoSum(int[] nums, int target) {
        int[] data = new int[nums.length];      //对nums数组进行拷贝
        for(int i = 0;i<data.length;i++){
            data[i] = nums[i];
        }
        int[] result = new int[2];                  //保存特定两个数的位置
        Arrays.sort(nums);                          //对nums排序，排序后采用二分查找对代码进行优化
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
                break;                                  //结束循环
            }
        }
        for(int i = 0;i<nums.length;i++){               //找到第一个位置的数字
            if(data[i]==result[0]){
                result[0] = i;
                break;
            }
        }
        for(int i = 0;i<nums.length;i++){                //找到第一个位置的数字
            if(data[i]==result[1]&&i!=result[0]){
                result[1] = i;
                break;
            }
        }
        return result;
    }
}
