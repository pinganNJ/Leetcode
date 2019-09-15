package leetcode;

/**
 * 213.打家劫舍 II
 *
 * @AUTHOR PizAn
 * @CREAET 2019-09-15 16:50
 */


//思路：这是之前rob的进阶版，其实就是将屋子首位相连了一下，导致如果偷了第一家就不能偷最后一家了，所有这个地方将原来的问题分成两个子问题
//就是我不偷第一家，就能偷[1,n-1]家，偷第一家，就能偷[0,n-2]家，然后放在一个函数里面计算，得出二者最大值

public class Q0213_rob {
    public int rob(int[] nums) {
        //边界条件，能写多少就写多少！
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }

        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }

        int len = nums.length;
        //这里将原来的问题分成了两个部分，用同一个函数来计算
        int m = method(nums, 0, len - 2);
        int n = method(nums, 1, len - 1);
        return Math.max(m, n);

    }
    //这个就是原来的rob函数，只不过是加了两个头尾参数
    private int method(int[] nums, int m, int n) {
        int[] dp = new int[nums.length];
        dp[m] = nums[m];
        dp[m + 1] = Math.max(nums[m], nums[m + 1]);
        for (int i = m + 2; i <= n; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[n];
    }
}
