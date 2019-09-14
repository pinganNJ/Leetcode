package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 46. 全排列
 *
 * @AUTHOR PizAn
 * @CREAET 2019-09-14 10:34
 */


//思路：用递归，请直接看大神的视频，15分钟给你讲懂
//如果数组里面有重复怎么办？我这里是直接用 list.stream().distinct().collect(Collectors.toList());对结果去个重，不过这个时间和空间复杂度都挺高的
public class Q0046_permute {
    List<List<Integer>> list = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }
        //递归函数
        perm(nums, 0, nums.length);
        return list;
    }

    private void perm(int[] nums, int p, int q) {
        //终结条件，如果p == q也就是到了最后了，要么打印出来，要么就放在list里面
        if (p == q) {
            //这里是放在了一个集合里面
            List<Integer> listN = new ArrayList<>();
            for (int i = 0; i < q; i++) {
                listN.add(nums[i]);
            }
            list.add(listN);
        }
        for (int i = p; i < q; i++) {
            //每个数都有可以作为头节点的机会
            swap(nums, i, p);
            //递归后面的节点
            perm(nums, p + 1, q);
            //最后还要再换回来
            swap(nums, i, p);
        }
    }

    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }


}