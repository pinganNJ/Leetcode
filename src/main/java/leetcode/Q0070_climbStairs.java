package leetcode;

/**
 * 70. 爬楼梯
 *
 * @AUTHOR PizAn
 * @CREAET 2019-08-19 14:08
 */


//思路：其实就是斐波拉契数列，f(n) = f(n-1)+f(n-2),这里如果用直接递归空间会爆，所以可以用数组来保存一下数据，或者用迭代也行

public class Q0070_climbStairs {
    public int climbStairs(int n) {

        if (n == 1) {
            return 1;
        }

        if (n == 2) {
            return 2;
        }

        //用数组保存数据
        int[] dp = new int[n + 1];

        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];

        }
        return dp[n];

    }
}