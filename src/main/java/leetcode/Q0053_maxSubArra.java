package leetcode;

/**
 * 53.最大子序和
 *
 * @AUTHOR PizAn
 * @CREAET 2019-08-22 12:59
 */

//思路：动态规划的一种

public class Q0053_maxSubArra {
    public int maxSubArray(int[] nums) {

        if (nums == null || nums.length < 1) {
            return -1;
        }

        int sum = 0;
        int res = nums[0];

        for (int num : nums) {
            //如果这个sum已经是小于0了，就抛弃它，然后从下一个接着走
            if (sum > 0) {
                sum += num;
            } else {
                sum = num;
            }

            //记录此刻的最大值
            res = Math.max(sum, res);
        }

        return res;


    }
}
