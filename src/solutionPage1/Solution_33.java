package solutionPage1;

/**
 * Created with IntelliJ IDEA.
 * User：by gyw
 * Date：2018-05-12 21:24
 */
public  class  Solution_33 {
    public static void main(String[] args) {
        int[] nums = new int[]{4,5,6,7,0,1,2};
        int target =0;
        int search = search(nums, target);
        System.out.println(search);
    }
    public static int search(int[] nums, int target) {
        int left=0;
        int right=nums.length-1;
        int mid =0;
        int result =0;
        while (left<=right){
            mid=(left+right)/2;
            if (target==nums[left]){        //判断target是否和边界值相同
                return left;
            }else if(target==nums[right]){
                return right;
            }else if(target==nums[mid]){
                return mid;
            }

            if(nums[mid]<nums[right]){      //if中间值小于最右值则说明右边是有序的
                //再判断要查找的值是在左边还是右边(要查找的值大于中间值可以在右边也可能在左边)
                if(target>nums[mid]&&target<nums[right]){           //在右边情况下则是在有序的情况下
                    left=mid+1;
                }else {                                             //在左边情况下则是在不完全有序的情况下
                    right=mid-1;
                }
            }else {                           //if中间值大于最右值则说明左边边是有序的
                if(target<nums[mid]&&target>nums[left]){           //在左边情况下则是在有序的情况下
                    right=mid-1;
                }else {                                             //在左边情况下则是在不完全有序的情况下
                    left=mid+1;
                }
            }
        }
        return -1;
    }
}
