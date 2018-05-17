package suanfa.TwoPointers;

/**
 * Created with IntelliJ IDEA.
 * User：by gyw
 * Date：2018-04-01 17:08
 * 欢迎关注github https://github.com/Faded1234/Leetcode
 */
/*给定 n 个正整数 a1，a2，...，an，其中每个点的坐标用（i, ai）表示。
        画 n 条直线，使得线 i 的两个端点处于（i，ai）和（i，0）处。
        请找出其中的两条直线，使得他们与 X 轴形成的容器能够装最多的水。

        注意：你不能倾斜容器，n 至少是2。*/
public class Solution_11 {
    public static void main(String[] args) {
        int[] a =new int[]{1,1};

        System.out.println(maxArea( a));
    }
    public static int maxArea(int[] height) {
        //从两边向中间，比较两线高度，每次都舍弃最短的并向中心移动一位，同时根据两边距离和最短边高度得到面积。
        // 由于最短边是每个长方形面积的决定因素，因而每次只挪动短边的一端，直到两端相遇。
        int maxArea=0;
        int left=0;
        int right=height.length-1;
        while (left<right){
            maxArea=Math.max(maxArea,(right-left)*Math.min(height[left],height[right]));
            if (height[left]<height[right]){
                left++;
            }else {
                right--;
            }
        }
        return maxArea;
    }
}
