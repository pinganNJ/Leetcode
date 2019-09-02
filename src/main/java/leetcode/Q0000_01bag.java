package leetcode;

/**
 * 01背包问题
 *
 * @AUTHOR PizAn
 * @CREAET 2019-09-02 21:54
 */

public class Q0000_01bag {

    public static void main(String[] args) {

        //注意：这里是特意前面补了一个0，不然下面的dp[i][j] = dp[i-1][j] 会数组越界
        int[] w = {0, 2, 3, 4, 5, 9};//重量
        int[] v = {0, 3, 4, 5, 8, 10};//价值

        int maxW = 20; //最大的容量是20
        int N = 6; //5个无物品
        int[][] dp = new int[6][21];
        //dp[i][j],第i个数，剩余j的重量，此时的总价值，比如dp[3][18]，就是放到第三个数的时候，剩余18的总价值

        for (int i = 1; i < 6; i++) {
            for (int j = 0; j < 21; j++) {
                if (w[i] > j) {
                    dp[i][j] = dp[i - 1][j];//如果剩余空间不能再放第i个数了，就不放了
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - w[i]] + v[i]);//放第i个数和不放第i个数的价值那个大就是哪个
                }
            }
        }
        System.out.println(dp[5][20]);//放第5个数，总重量为20
    }
}
