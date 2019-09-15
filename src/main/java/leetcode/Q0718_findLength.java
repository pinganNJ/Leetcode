package leetcode;

/**
 * 718.最长重复子数组
 *
 * @AUTHOR PizAn
 * @CREAET 2019-09-15 11:02
 */

public class Q0718_findLength {

/*  输入:
    A: [1,2,3,2,1]
    B: [3,2,1,4,7]
    输出: 3
    解释:
    长度最长的公共子数组是 [3, 2, 1]*/


    //思路：这里采用动态规划做，构建一个[A.length][B.length]的二维数组，每个节点表示A和B走到哪一步了，然后这个时候最长
    public int findLength(int[] A, int[] B) {
        //先搞个dp数组来保存每个子问题的值
        int[][] dp = new int[A.length][B.length];
        //用来保存最后的结果
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                if (A[i] == B[j]) {
                    //这里有个边界条件，就是初始化的时候，i=0,或者j=0的时候，这个时候dp[i][j] = 1,其他情况可以通过 dp[i][j] = dp[i - 1][j - 1] + 1;得到结果
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    }
                }
                res = Math.max(dp[i][j], res);
            }
        }
        return res;
    }
}
