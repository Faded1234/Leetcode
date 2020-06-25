package solutionPage1;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User：by gyw
 * Date：2018-05-11 17:16
 */
public class Solution_31 {
    public static void main(String[] args) {
        int[] num = {5,6,3,4};
        nextPermutation(num);
        System.out.println(num);
    }
    public static void nextPermutation(int[] nums) {
        if (nums==null&&nums.length==1){
            return;
        }
        int num=nums.length-1;
        for (; num>0 ; num--) {
            if ( nums[num-1]<nums[num] ) {
                break;
            }
        }
        if (num==0){
            Arrays.sort(nums);
        }else {
            for (int i = nums.length-1; i >0 ; i--) {
                if (nums[i]>nums[num-1]){
                    int temp =nums[i];
                    nums[i] = nums[num-1];
                    nums[num-1]=temp;

                    int right = nums.length-1;
                    int left = num;
                    while (right>left){
                        int a= nums[right];
                        nums[right]=nums[left];
                        nums[left]=a;
                        right--;
                        left++;
                    }
                    break;
                }
            }
        }
    }
}
