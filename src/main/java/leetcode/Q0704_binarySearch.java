package leetcode;

/**
 * 704. 二分查找
 *
 * @AUTHOR PizAn
 * @CREAET 2019-09-02 22:10
 */

public class Q0704_binarySearch {
    public int search(int[] nums, int target) {
        int low = 0;
        int hi = nums.length;
        int mid;

        //注意：下面这个地方不是连续的if，而是单独判断！
        while (low <= hi) {
            mid = (low + hi) / 2;
            if (nums[mid] < target) {
                low = mid + 1;
            }
            if (nums[mid] > target) {
                hi = mid - 1;
            }
            if (nums[mid] == target) {
                return mid;
            }
        }

        return -1;


    }
}
