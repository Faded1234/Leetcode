package suanfa.Array;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User：by gyw
 * Date：2018-04-06 11:27
 * 欢迎关注github https://github.com/Faded1234/Leetcode
 */
/*给定一个包括 n 个整数的数组 S，找出 S 中的三个整数使得他们的和与给定的数 target 最接近。返回这三个数的和。假定每组输入只存在一个答案。

        例如，给定数组 S = {-1 2 1 -4}, 并且 target = 1.

        与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).*/
/* S = {-6 -4 -2 0 1 2 3 5 8}
输入：
[0,1,1,1]
-100
输出：
3
预期：
2
* */
public class Solution_16 {
    public static void main(String[] args) {
        int[] a=new int[]{1,1,1,0};
        int b=5;
        System.out.println(
        threeSumClosest(a,b));

    }
    /*
    * 这一题和前一题是非常相似的我们可以用同样的思路进行解答，无非就是变为三个数字的和再减去target然后和0比较
    * */
    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int sum=nums[0]+nums[1]+nums[2];   //记录三个数字的和
        int result=sum;
        int away=0;
        for (int i = 0; i < nums.length; i++) {
            int left=i+1 , right=nums.length-1 ;
            while (left<right){
                sum = nums[i] + nums[left] + nums[right];   //对结果进行赋值
                away=sum-target;     //三个和的结果到targrt的距离带正负
                if(away==0){  //  距离为0返回结果
                    return sum;
                }else if(away>0){  //如果结果负数则左移
                    if(Math.abs(away)<Math.abs(result-target)) //如果新的距离小于之前的结果则进行更新
                        result=sum;
                    right--;
                }else if(away<0){  //如果结果过小则右移
                    if(Math.abs(away)<Math.abs(result-target))
                        result=sum;
                    left++;
                }
            }
        }
        return result;
    }
}
