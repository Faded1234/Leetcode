import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User：by gyw
 * Date：2018-05-15 19:20
 */
public class Solution_39_1 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        DFS(0, candidates, target);
        return ans;
    }
    List<List<Integer>> ans = new ArrayList<List<Integer>>();
    int path[] = new int[1000];
    int len = 0;

    public void DFS(int index, int[] c, int target){
        if(target == 0){
            //ans记录
            List<Integer> tmp = new ArrayList<Integer>();
            for(int i=0; i<len; i++){
                tmp.add(path[i]);
            }
            ans.add(tmp);
            return ;
        }

        if(target < 0 || index >= c.length){
            return;
        }

        //use c[index]
        path[len] = c[index];
        len++;
        DFS(index, c, target - c[index]);
        //not use c[index]
        len--;
        DFS(index + 1, c, target);
    }

}
