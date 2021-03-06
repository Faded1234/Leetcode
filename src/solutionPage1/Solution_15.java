package solutionPage1;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User：by gyw
 * Date：2018-04-04 15:53
 * 欢迎关注github https://github.com/Faded1234/Leetcode
 *
 给定一个包含 n 个整数的数组 S，是否存在属于 S 的三个元素 a，b，c 使得 a + b + c = 0 ？找出所有不重复的三个元素组合使三个数的和为零。

 注意：结果不能包括重复的三个数的组合。

 例如, 给定数组 S = [-1, 0, 1, 2, -1, -4]，

 一个结果集合为：
 [
 [-1, 0, 1],
 [-1, -1, 2]
 ]
 输入：
 [-1,-1,0,1,2,-4]
 输出：
 [[-1,-1,2],[-1,0,1],[-1,0,1]]
 预期：
 [[-1,-1,2],[-1,0,1]]
 */
public class Solution_15 {
    public static void main(String[] args) {
        int[] a=new int[]{0,0,0,0};
        threeSum(a);
        System.out.println(a.length);
    }
    public static List<List<Integer>> threeSum(int[] nums) {
//这种写法是不可取的，因为是三层循环所以时间复杂度是非常高的。
        if (nums.length<=2)  //如果集合的长度小于3直接返回空
        {
            List li = new ArrayList();
            return li;
        }


        Set<List<Integer>> sets =new HashSet<>();   //y因为需要保存的数组是不能重复的，所以我们可以用Set保存

        Arrays.sort(nums);
        if (nums[0]>0||nums[nums.length-1]<0){
            List li = new ArrayList();
            return li;      //排序后的数字如果全为正数或者全为负数则没有符合要求的数字。
        }
        for (int i = 0; i<nums.length&&nums[i] <= 0; i++) {
            for (int j = i+1; j < nums.length; j++) {
                for (int k = j+1; k < nums.length; k++) {
                    if(nums[i]+nums[j]+nums[k]==0){
                        List<Integer> list = new ArrayList<>();
                         list.add(nums[i]);
                         list.add(nums[j]);
                         list.add(nums[k]);
                         sets.add(list);
                    }
                }
            }
        }
        List<List<Integer>> lists = new ArrayList<List<Integer>>(sets);
        return lists;
    }
}
