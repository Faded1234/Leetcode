package solutionPage1;

public class Solution_45 {
    /**
     * 给定一个非负整数数组，你最初位于数组的第一个位置。
     *
     * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
     *
     * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
     *
     * 示例:
     *
     * 输入: [2,3,1,1,4]
     * 输出: 2
     * 解释: 跳到最后一个位置的最小跳跃数是 2。
     *      从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
     * @param nums
     * @return
     */
    public int jump(int[] nums) {
        if(nums.length<2)return 0;
        int level=0,currentMax=0,nextMax=0;
        int i=0;
        while(currentMax-i+1>0){
            level++;
            for(;i<=currentMax;i++){
                nextMax=Math.max(nextMax,nums[i]+i);
                if(nextMax >= nums.length-1){
                    return level;
                }
            }
            currentMax=nextMax;
        }
        return 0;
    }
}
