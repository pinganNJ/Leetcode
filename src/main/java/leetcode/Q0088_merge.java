package leetcode;

import java.util.Arrays;

/**
 * 88. 合并两个有序数组
 *
 * @AUTHOR PizAn
 * @CREAET 2019-09-13 19:57
 */

public class Q0088_merge {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] arr = new int[m + n];
        int i = 0;
        int j = 0;
        for (int k = 0; k < m + n; k++) {
            if (i > m - 1) {
                arr[k] = nums2[j++];
            } else if (j > n - 1) {
                arr[k] = nums1[i++];
            } else if (nums1[i] > nums2[j]) {
                arr[k] = nums2[j++];
            } else {
                arr[k] = nums1[i++];
            }
        }

        for (int k = 0; k < m + n; k++) {
            nums1[k] = arr[k];
        }

        // System.arraycopy(nums2, 0, nums1, m, n);
        //num2 是要copy的数组，从nums的0位开始复制，复制到num1里面，从m位开始复制，复制n个长度
        //num2复制到num1里面


    }
}
