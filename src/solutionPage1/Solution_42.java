package solutionPage1;

import static java.lang.Integer.sum;

/**
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 */
public class Solution_42 {
    public static void main(String[] args) {
        int[] a = new int[]{1,1,3};
        int trap = trap(a);
        System.out.println(trap);
    }

    public static int trap(int[] height) {
        /*
        思路：定义两个指针left、right，初始指向左右两端，如果左边的值较小从左往右扫描，如果右边的值较小从右往左扫描，在扫描的过程中如果当前值比较大那么
        重新定义区间，如果当前值比较小将差值添加到结果中，一直扫描到left、right重合为止
         */
        if (height.length==0)
        {
            return 0;
        }
        int left=0;
        int leftCur=0;
        int rightCur=height.length-1;
        int right=height.length-1;
        int res=0;
        while (left!=right)
        {
            if (height[left] <= height[right])
            {
                leftCur++;
                if (height[leftCur]>=height[left])
                {
                    left=leftCur;
                }else {
                    res+=height[left]-height[leftCur];
                }
            }else {
                rightCur--;
                if (height[rightCur]>=height[right])
                {
                    right=rightCur;
                }else {
                    res+=height[right]-height[rightCur];
                }
            }
        }
        return res;
    }

}
