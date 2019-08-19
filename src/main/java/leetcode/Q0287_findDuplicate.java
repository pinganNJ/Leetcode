package leetcode;

import java.util.Arrays;

/**
 * 287.寻找重复数
 *
 * @AUTHOR PizAn
 * @CREAET 2019-08-19 17:31
 */


//思路：这个直接排序，或者用set,还有一个循环，但是好像挺难的，不想看了，过了就行==

public class Q0287_findDuplicate {

    public int findDuplicate(int[] nums) {

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 1; i++) {

            if (nums[i] == nums[i + 1]) {
                return nums[i];
            }
        }
        return -1;
    }
}
