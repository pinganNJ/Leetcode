package leetcode;

import leetcodeCoding.LRUCache;

import javax.print.DocFlavor;
import javax.swing.plaf.multi.MultiMenuItemUI;

/**
 * 4. 寻找两个有序数组的中位数
 *
 * @AUTHOR PizAn
 * @CREAET 2019-08-18 20:58
 */


//思路：其实就是归并排序的思想，将两个排好序的数组排成一个数组，时间复杂度O(m+n)

public class Q0004_findMedianSortedArrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int m = nums1.length, n = nums2.length;

        int[] arr = new int[m + n];


        int left = 0, right = 0;

        //这个是归并排序的思想
        for (int i = 0; i < m + n; i++) {
            if (m == 0 && n != 0) {
                arr[i] = nums2[right++];
            } else if (n == 0 && m != 0) {
                arr[i] = nums1[left++];
            } else {
                if (left >= m) {
                    arr[i] = nums2[right++];
                } else if (right >= n) {
                    arr[i] = nums1[left++];
                } else if (nums1[left] < nums2[right]) { //这个地方不要写错！！！！！，是num1和num2不是arr
                    arr[i] = nums1[left++];
                } else {
                    arr[i] = nums2[right++];
                }
            }
        }

        int middle = arr.length / 2;

        //这个地方也不要写错
        return arr.length % 2 == 0 ? (arr[middle] + arr[middle - 1]) / 2.0 : arr[middle];


    }
}