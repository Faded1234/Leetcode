import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User：by gyw
 * Date：2018-05-15 16:30
 */
public class Solution_39 {
    public static void main(String[] args) {
        int[] a=new int[]{2,3,5};
        List<List<Integer>> lists = combinationSum(a, 8);
        System.out.println(lists.size());
    }
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (candidates == null || candidates.length < 1)
            return res;
        Arrays.sort(candidates);

        backtrack(candidates, target, res, new ArrayList<Integer>(), 0);

        return res;
    }

    // 如果不加参数start，会出现：input:[2,3,6,7]7
    // 结果：[[2,2,3],[2,3,2],[3,2,2],[7]]instead of [[2,2,3],[7]]的情况
    private static void backtrack(int[] nums, int target, List<List<Integer>> res, ArrayList<Integer> list, int start) {
        if (target < 0)
            return;
        if (target == 0) {
            res.add(list);
            return;
        }
        //加上target >= nums[i]：33ms to 23ms
        for (int i = start; i < nums.length && target >= nums[i]; i++) {
            list.add(nums[i]);
            backtrack(nums, target - nums[i], res, new ArrayList<Integer>(list), i);
            list.remove(list.size() - 1);
        }
    }
}
