package solutionPage1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution_47 {
    /**
     * 输入: [1,1,2]
     * 输出:
     * [
     *   [1,1,2],
     *   [1,2,1],
     *   [2,1,1]
     * ]
     */
    private List<List<Integer>> anslist = new ArrayList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        int[] used = new int[nums.length];
        List<Integer> list = new ArrayList<>();
        getPermution(list, used, nums);
        return anslist;
    }

    public void getPermution(List<Integer> list, int[] used, int[] nums) {
        if (list.size() == nums.length - 1) {
            List<Integer> tmp = new ArrayList<>(list);
            for (int i = 0; i < nums.length; i++) {
                if (used[i] == 0) tmp.add(nums[i]);
            }
            anslist.add(tmp);
            return;
        }
        int lastUsed = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            // 如果nums[i] == lastUsed，则跳过本次循环
            if (used[i] == 0 && nums[i] != lastUsed) {
                used[i] = 1;
                list.add(nums[i]);
                getPermution(list, used, nums);
                lastUsed = nums[i];
                used[i] = 0;
                list.remove(list.size() - 1);
            }
        }
    }
}
