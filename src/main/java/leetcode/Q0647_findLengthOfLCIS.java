package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * 674.最长连续递增序列
 *
 * @AUTHOR PizAn
 * @CREAET 2019-09-13 18:46
 */

//思路：就是遍历这个数组，同时用一个标记来标记递增序列的大小，如果不是递增，就将这个标记归1，同时，记录最大值
public class Q0647_findLengthOfLCIS {
    public int findLengthOfLCIS(int[] nums) {
        if (nums == null || nums.length <= 0) {
            return 0;
        }
        if (nums.length == 1) {
            return 1;
        }

        int count = 1; //标记初始化为1，因为这个值最小为1，在数组不会空的情况下
        int res = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] < nums[i + 1]) {
                count++;
            } else {
                count = 1;//重置为1
            }
            //记录最大值
            res = res > count ? res : count;

        }
        return res;
    }
}


/*

        if (nums == null || nums.length <= 0) {
                return 0;
                }
                if (nums.length == 1) {
                return 1;
                }

                int count = 1;
                ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length - 1; i++) {

        if (nums[i] < nums[i + 1]) {
        count++;
        } else {
        list.add(count);
        count = 1;
        }
        if(i == nums.length - 2){
        list.add(count);
        }
        }

        if (list.size() == 0) {
        return 0;
        } else {
        Collections.sort(list);
        Collections.reverse(list);
        return list.get(0);
        }


        }
*/

