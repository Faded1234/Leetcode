
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User：by gyw
 * Date：2018-05-17 10:31
 */
class Solution_39_2 {
    public static void main(String[] args) {
        Solution_39_2 s = new Solution_39_2();
        int a[] = new int[]{2,3,5};
        List<List<Integer>> lists = s.combinationSum(a, 8);
        System.out.println();
    }

    List<List<Integer>> res = new ArrayList<List<Integer>>();
    static int start = 0;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> list = new ArrayList<Integer>();
        combination(candidates, target, list, 0);
        return res;
    }
    //深度优先算法
    public void combination(int[] candidates, int target, List<Integer> list, int start){
        if(target < 0){
            return;
        }
        if(target == 0){
            res.add(new ArrayList<Integer>(list));
            return;
        }
        for(int j = start; j < candidates.length; j++){
            if(target >= candidates[j]){
                list.add(candidates[j]);
                combination(candidates, target-candidates[j], list, j);
                list.remove(list.size()-1);
            }
        }
    }

}

