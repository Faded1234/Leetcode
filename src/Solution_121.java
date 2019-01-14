/**
 * Created by guoyongwei1 on 2019/1/14
 *
 * @Date: 2019/1/14 14:34
 * @Desc: 买卖股票的最佳时机
 * @Since: 1.0
 *
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 *
 * 如果你最多只允许完成一笔交易（即买入和卖出一支股票），设计一个算法来计算你所能获取的最大利润。
 *
 * 注意你不能在买入股票前卖出股票。
 *
 * 输入: [7,1,5,3,6,4]
 * 输出: 5
 */
public class Solution_121 {
    public static void main(String[] args) {
        int prices[] = new int[]{2,3,100,1,88};
        int i = maxProfit(prices);
        System.out.println(i);
    }
    public static int maxProfit(int[] prices) {
        int result = 0;
        if( prices == null || prices.length == 0){
            return 0;
        }
        int minbuy = prices[0];
        for(int i = 1;i< prices.length ;i++){
            // 最小的购买，最大的卖
            result = Math.max(result,prices[i] - minbuy);
            minbuy = Math.min(minbuy,prices[i]);
        }
        return result;
    }
}
