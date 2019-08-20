package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 169.求众数
 *
 * @AUTHOR PizAn
 * @CREAET 2019-08-20 14:52
 */

//思路：这个我就想直接用个map表存储一下的了,最重要的是复习了map怎么遍历的，用forEach，然后是Map.Entry<Integer,Integer>

public class Q0169_majorityElement {
    public int majorityElement(int[] nums) {

        if (nums == null || nums.length < 1) {
            return -1;
        }
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], 1);
            } else {
                map.put(nums[i], map.get(nums[i]) + 1);
            }
        }


        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > nums.length / 2) {
                return entry.getKey();
            }
        }

        return -1;

    }
}
