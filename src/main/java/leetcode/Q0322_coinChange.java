package leetcode;

import java.util.Arrays;

/**
 * 322.零钱兑换
 *
 * @AUTHOR PizAn
 * @CREAET 2019-09-02 18:28
 */


/*输入: coins = [1, 2, 5], amount = 11
        输出: 3
        解释: 11 = 5 + 5 + 1
        */

public class Q0322_coinChange {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        int max = amount + 1;
        Arrays.fill(dp,max);
        dp[0] = 0;


        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if(i >= coins[j]){
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }

        if(dp[amount] > amount ){
            return -1;
        }

        return dp[amount];



    }
}
