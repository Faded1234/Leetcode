import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: gyw
 * @create: 2020-04-04 17:53
 **/
public class Solution_78 {

    public static void main(String[] args) {
        Solution_78 so = new Solution_78();
        int[] a = new int[3];
        a[0] = 1;
        a[1] = 2;
        a[2] = 3;
        List<List<Integer>> subsets = so.subsets(a);
        System.out.println();
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length == 0) return res;
        res.add(new ArrayList());
        dfs(0, nums, res, new ArrayList());
        return res;
    }

    public void dfs(int indx, int[] nums, List<List<Integer>> res, List<Integer> rr) {
        for (int i = indx; i <nums.length ; i++) {
            //加入当前的数组
            rr.add(nums[i]);
            res.add(new ArrayList<Integer>(rr));
            //继续下一个数字
            dfs(i+1,nums,res,rr);
            rr.remove(rr.size()-1);
        }
    }
}
