package leetcode;

import java.util.Arrays;

/**
 * 581. 最短无序连续子数组
 *
 * @AUTHOR PizAn
 * @CREAET 2019-08-22 13:58
 */


//思路：先排序，然后比较两个数组在什么地方值不一样
public class Q0581_findUnsortedSubarray {
    public int findUnsortedSubarray(int[] nums) {

        if (nums == null || nums.length < 1) {
            return -1;
        }

        int[] ints = nums.clone();
        Arrays.sort(ints);

        int start = nums.length;
        int end = 0;

        for (int i = 0; i < nums.length; i++) {
            if (ints[i] != nums[i]) {
                start = Math.min(start, i);
                end = Math.max(end, i);
            }
        }

        return end - start >= 0 ? end - start + 1 : 0;


    }
}
