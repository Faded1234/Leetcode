import java.util.ArrayList;
import java.util.List;

class Solution_46 {
    /**
     * 给定一个没有重复数字的序列，返回其所有可能的全排列。
     *
     * 示例:
     *
     * 输入: [1,2,3]
     * 输出:
     * [
     *   [1,2,3],
     *   [1,3,2],
     *   [2,1,3],
     *   [2,3,1],
     *   [3,1,2],
     *   [3,2,1]
     * ]
     * @param nums
     * @return
     */
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> listList = new ArrayList<>();
        //开始回溯
        backtracking(listList, nums, 0);
        return listList;
    }
    private static void backtracking(List<List<Integer>> listList, int[] nums, int j) {

        if (j == nums.length) {
            List<Integer> list = new ArrayList<>();
            for (int num : nums) list.add(num);
            listList.add(list);
        }
        for (int i = j; i < nums.length; i++) {
            //i、j互换（刚开始自己跟自己换）
            swap(nums, i, j);
            //往上回溯
            backtracking(listList, nums, j+1);
            //回溯完，i、j互换，一个循环结束，回到了最初的1,2,3
            swap(nums, i, j);
        }
    }
    private static void swap(int[] nums, int m, int n) {
        int temp = nums[m];
        nums[m] = nums[n];
        nums[n] = temp;
    }
}
/*
public List<List<Integer>> permute(int[] nums) {
   List<List<Integer>> list = new ArrayList<>();
   // Arrays.sort(nums); // not necessary
   backtrack(list, new ArrayList<>(), nums);
   return list;
}

private void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums){
   if(tempList.size() == nums.length){
      list.add(new ArrayList<>(tempList));
   } else{
      for(int i = 0; i < nums.length; i++){ 
         if(tempList.contains(nums[i])) continue; // element already exists, skip
         tempList.add(nums[i]);
         backtrack(list, tempList, nums);
         tempList.remove(tempList.size() - 1);
      }
   }
} 
*/