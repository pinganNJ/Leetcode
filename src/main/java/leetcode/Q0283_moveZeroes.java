package leetcode;

/**
 * 283. 移动零
 *
 * @AUTHOR PizAn
 * @CREAET 2019-08-20 15:40
 */

public class Q0283_moveZeroes {
    public void moveZeroes(int[] nums) {
        if (nums == null) {
            return;
        }
        int k = 0;
        for (int i = 0; i < nums.length; i++) {

            if (nums[i] != 0) {
                swap(nums, i, k++);
            }
        }
    }
    private void swap(int[] nums, int a, int b) {

        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
