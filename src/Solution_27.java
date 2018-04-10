import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User：by gyw
 * Date：2018-04-10 15:16
 */

/*
给定一个数组和一个值，在这个数组中原地移除指定值和返回移除后新的数组长度。
        不要为其他数组分配额外空间，你必须使用 O(1) 的额外内存原地修改这个输入数组。
        元素的顺序可以改变。超过返回的新的数组长度以外的数据无论是什么都没关系。
        示例:
        给定 nums = [3,2,2,3]，val = 3，
        你的函数应该返回 长度 = 2，数组的前两个元素是 2。
*/
public class Solution_27 {
    public static void main(String[] args) {
        int[] i = new int[]{4,3,3,4};
        int i1 = removeElement(i, 4);
        System.out.println(i1);
    }
    public static int removeElement(int[] nums, int val) {
        if (nums.length==1){
            if (nums[0]==val){
                return 0;
            }else {
                return 1;
            }
        }
        //欢迎关注github https://github.com/Faded1234/Leetcode
        int left=0;
        int right=nums.length-1;
        int num=0;
        while (left<=right){
            if (nums[left]!=val){
                left++;
                ++num;
            }else {
                if (nums[left]==nums[right]){
                    right--;
                }else {
                    int temp=nums[left];
                    nums[left]=nums[right];
                    nums[right]=temp;
                    right--;
                    left++;
                    ++num;
                }
            }
        }
        if (left==0){
            return 0;
        }
        return num;
    }
}
