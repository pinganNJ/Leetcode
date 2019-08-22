package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 448.找到所有数组中消失的数字
 *
 * @AUTHOR PizAn
 * @CREAET 2019-08-22 9:35
 */

//思路：采取众神归位的方法，如果num[i] = 3,那么就把它放到第2位上（因为数字是从1开始的，要放在从0开始的下标上）

public class Q0448_findDisappearedNumbers {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();
        if (nums == null || nums.length < 1) {
            return list;
        }

        //注意：这个上面没有i++
        for (int i = 0; i < nums.length; ) {

            //前面是自己等于自己本身，后面是重复的那个数
            if (nums[i] == i + 1 || nums[i] == nums[nums[i] - 1]) {
                i++;
            } else {

                swap(nums, i, nums[i] - 1);

            }
        }

        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != j + 1) {
                list.add(j + 1);
            }

        }

        return list;


    }

    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}