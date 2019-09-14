package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 46. 全排列
 *
 * @AUTHOR PizAn
 * @CREAET 2019-09-14 10:34
 */

public class Q0047_permuteII {
    List<List<Integer>> list = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }
        perm(nums, 0, nums.length);

        List<List<Integer>> list = this.list.stream().distinct().collect(Collectors.toList());
        return list;


    }

    private void perm(int[] nums, int p, int q) {

        if (p == q) {
            List<Integer> listN = new ArrayList<>();
            for (int i = 0; i < q; i++) {
                listN.add(nums[i]);
            }
            list.add(listN);
        }
        for (int i = p; i < q; i++) {
            swap(nums, i, p);
            perm(nums, p + 1, q);
            swap(nums, i, p);
        }
    }

    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}