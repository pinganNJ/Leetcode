package leetcode;

/**
 * 62.不同路径
 *
 * @AUTHOR PizAn
 * @CREAET 2019-09-15 21:12
 */


//思路：也是简单的dp，这里只要画个二维图就行了，注意边界条件，最后一个节点的值就是上面和左边值的相加
public class Q0062_uniquePaths {
    public int uniquePaths(int m, int n) {
        if (m < 0 || n < 0) {
            return 0;
        }
        if (m == 0 || n == 0) {
            return 1;
        }

        int[][] dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            dp[i][0] = 1;
        }
        for (int j = 0; j < m; j++) {
            dp[0][j] = 1;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[n - 1][m - 1];
    }
}
