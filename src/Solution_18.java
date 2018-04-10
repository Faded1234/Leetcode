import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User：by gyw
 * Date：2018-04-06 18:24
 * 欢迎关注github https://github.com/Faded1234/Leetcode
 */
/*给定一个含有 n 个整数的数组 S，数列 S 中是否存在元素 a，b，c 和 d 使 a + b + c + d = target ？

        请在数组中找出所有满足各元素相加等于特定值 的 不重复 组合。

        注意：解决方案集不能包含重复的四元组合。

        例如，给定数组 S = [-2, -1, 0, 0, 1, 2]，并且给定 target = 0。

        示例答案为：
        [
        [-1,  0, 0, 1],
        [-2, -1, 1, 2],
        [-2,  0, 0, 2]
        ]*/
public class Solution_18 {
    public static void main(String[] args) {
        int[] nums =new int[]{1, -1, 0, 0, -2, 2};
        List<List<Integer>> lists = fourSum(nums, 0);
        System.out.println();

    }
    //这题好有意思，之前是两数相加，然后三数相加在三数相加的和与给定的数比较，最后又四数相加，可以采用三数相加的思路
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        Set<List<Integer>> set = new HashSet<>();

        if(nums==null||nums.length<4){
            List list = new ArrayList();
            return list;
        }

        Arrays.sort(nums);

        for (int i = 0; i < nums.length-3; i++) {
            for (int j = i+1; j < nums.length-2; j++) {
                int temp = nums[i]+nums[j];     //前两个数字的和
                int result = target-temp;       //后两个数字的和应该是result
                int left = j+1;             //第三个数字开始的地方
                int right = nums.length-1;   //第四和数字开始的地方
                while (left<right){
                    if(nums[left]+nums[right]>result){              //后两个数字的和大于预期值则结果过大右边的左移
                        right--;
                    }else if(nums[left]+nums[right]<result){          //右移
                        left++;
                    }else {
                        List list = new ArrayList(4);   //找到预期值返回结果
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[left]);
                        list.add(nums[right]);
                        set.add(list);
                        right--;
                        left++;
                    }
                }

            }
        }

        List<List<Integer>> lists = new ArrayList<>(set);
        return lists;
    }
}
