import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User：by gyw
 * Date：2018-05-17 11:18
 */
public class Solution_40 {
    public static void main(String[] args) {
        Solution_40 Solution_40 = new Solution_40();
        int a[] = new int[]{2, 3, 5, 5};
        List<List<Integer>> lists = Solution_40.combinationSum2(a, 10);
        System.out.println();
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        combinationSum2(candidates, target, 0, res, new ArrayList<>());
        return res;
    }

    private void combinationSum2(int[] candidates, int target, int start, List<List<Integer>> res, List<Integer> res_sub) {
        if (start > candidates.length || target < 0) {
            return;
        } else if (target == 0) {
            res.add(new ArrayList(res_sub));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }
            res_sub.add(candidates[i]);
            combinationSum2(candidates, target - candidates[i], i + 1, res, res_sub);
            res_sub.remove(res_sub.size() - 1);
        }
    }
}