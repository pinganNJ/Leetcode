package leetcode;

/**
 * 198. 打家劫舍
 *
 * @AUTHOR PizAn
 * @CREAET 2019-08-20 17:39
 */

//思路：和爬楼梯一样，用动态规划/迭代，用一个数组来保存上一次的状态
// arr[i] = Math.max(arr[i - 2] + nums[i], arr[i - 1]);

public class Q0198_rob {
    public int rob(int[] nums) {
        //一些健壮性判断
        if (nums == null || nums.length < 1) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }

        int[] arr = new int[nums.length];

        arr[0] = nums[0];
        arr[1] = Math.max(nums[0], nums[1]);


        for (int i = 2; i < arr.length; i++) {

            arr[i] = Math.max(arr[i - 2] + nums[i], arr[i - 1]);
        }

        return arr[nums.length - 1];


    }
}