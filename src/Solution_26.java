import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User：by gyw
 * Date：2018-04-10 14:08
 */
/*
给定一个有序数组，你需要原地删除其中的重复内容，使每个元素只出现一次,并返回新的长度。
        不要另外定义一个数组，您必须通过用 O(1) 额外内存原地修改输入的数组来做到这一点。
        示例：
        给定数组: nums = [1,1,2],
        你的函数应该返回新长度 2, 并且原数组nums的前两个元素必须是1和2
        不需要理会新的数组长度后面的元素
*/
public class Solution_26 {
    public static void main(String[] args) {
        int[] i = new int[]{1,1,2};
        int i1 = removeDuplicates(i);
        System.out.println();
    }
    public static int removeDuplicates(int[] nums) {
        //欢迎关注github https://github.com/Faded1234/Leetcode
        int size=0;
        if (nums==null&&nums.length==0){
            return size;
        }
        //利用快慢指针 如果两个数字不相等就把慢点对应的数字换位快的，然后慢指针向后移
        int slow = 0;
        int fast = 0;
        for ( fast = 1; fast < nums.length; fast++) {
                if (nums[fast]!=nums[slow]){
                    nums[slow+1]=nums[fast];
                    slow++;
                }
        }
        return slow+1;
    }
}
