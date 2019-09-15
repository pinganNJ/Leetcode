package leetcode;

/**
 * 64.最小路径和
 *
 * @AUTHOR PizAn
 * @CREAET 2019-09-15 14:04
 */


//思路：依然是动态规划，构建一个dp[i][j]的二维数组，然后最后一个节点的值等于上面下来和左边过来的最小值+本值
//这里的边界条件（发现要是做了动态规划，就尽可能多的把边界提前做出来），就是在边上的时候要提前循环地做一下
public class Q0064_minPathSum {

    /*    输入:
                [
                [1,3,1],
                [1,5,1],
                [4,2,1]
                ]
        输出: 7
        解释: 因为路径 1→3→1→1→1 的总和最小*/
    public int minPathSum(int[][] grid) {
        int hang = grid.length;
        int lie = grid[0].length;

        int[][] dp = new int[hang][lie];
        dp[0][0] = grid[0][0];

        //列为0的左边界
        for (int i = 1; i < hang; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }

        //行为0的上边界
        for (int j = 1; j < lie; j++) {
            dp[0][j] = dp[0][j - 1] + grid[0][j];
        }

        //除了边界之外的子问题，节点，这里写一下
        for (int i = 1; i < hang; i++) {
            for (int j = 1; j < lie; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        return dp[hang - 1][lie - 1];
    }
}