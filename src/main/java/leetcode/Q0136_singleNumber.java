package leetcode;

import java.util.Arrays;

/**
 * 136. 只出现一次的数字
 *
 * @AUTHOR PizAn
 * @CREAET 2019-08-20 14:05
 */


//思路：因为不能用额外的辅助结果，所以这里直接排序，然后前后比较一下
//另外，可以用异或，简单粗暴一点，一个数和自己异或，为0，0和其他数异或不变

public class Q0136_singleNumber {
    public int singleNumber(int[] nums) {

        if (nums == null || nums.length == 2) {
            return -1;
        }

        if (nums.length == 1) {
            return nums[0];
        }

        //排序
        Arrays.sort(nums);

        if (nums[0] != nums[1]) {
            return nums[0];
        }

        if (nums[nums.length - 1] != nums[nums.length - 2]) {
            return nums[nums.length - 1];
        }

        for (int i = 1; i < nums.length - 1; i++) {
            if (nums[i] != nums[i - 1] && nums[i] != nums[i + 1]) {
                return nums[i];
            }
        }
        return -1;
    }


    public int singleNumberO(int[] nums) {
        if (nums == null) {
            return -1;
        }

        int res = nums[0];

        if (nums.length > 1) {

            //注意：这里是从1开始的，不要从0开始，不然真的和自身（nums[0])比较了！！！）
            for (int i = 1; i < nums.length; i++) {
                res = res ^ nums[i];
            }
        }
        return res;
    }
}