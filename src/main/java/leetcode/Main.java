package leetcode;

/**
 * @AUTHOR PizAn
 * @CREAET 2019-08-18 22:35
 */

public class Main {

    public static void main(String[] args) {
        int[] num1 = new int[]{1,3,4};
        int[] num2 = new int[]{2,2,5};

        Q0004_findMedianSortedArrays sortedArrays = new Q0004_findMedianSortedArrays();
        double w = sortedArrays.findMedianSortedArrays(num1, num2);
        System.out.println(w);
    }
}
