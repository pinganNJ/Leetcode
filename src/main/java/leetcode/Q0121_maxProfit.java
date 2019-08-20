package leetcode;

/**
 * 121. 买卖股票的最佳时机
 *
 * @AUTHOR PizAn
 * @CREAET 2019-08-20 16:01
 */


//思路：就用两个遍历，暴力破解

public class Q0121_maxProfit {
    public int maxProfit(int[] prices) {

        if (prices == null) {
            return -1;
        }

        int max = 0;

        for (int i = 0; i < prices.length; i++) {
            for (int j = 0; j < i; j++) {
                int cha = prices[i] - prices[j];
                max = cha > max ? cha : max;
            }
        }
        return max;
    }
}







