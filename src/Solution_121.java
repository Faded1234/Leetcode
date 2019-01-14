/**
 * Created by guoyongwei1 on 2019/1/14
 *
 * @Date: 2019/1/14 14:34
 * @Desc: ������Ʊ�����ʱ��
 * @Since: 1.0
 *
 * ����һ�����飬���ĵ� i ��Ԫ����һ֧������Ʊ�� i ��ļ۸�
 *
 * ��������ֻ�������һ�ʽ��ף������������һ֧��Ʊ�������һ���㷨�����������ܻ�ȡ���������
 *
 * ע���㲻���������Ʊǰ������Ʊ��
 *
 * ����: [7,1,5,3,6,4]
 * ���: 5
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
            // ��С�Ĺ���������
            result = Math.max(result,prices[i] - minbuy);
            minbuy = Math.min(minbuy,prices[i]);
        }
        return result;
    }
}
