package leetcode;

/**
 * 1.两数之和
 *
 * @AUTHOR PizAn
 * @CREAET 2019-08-18 15:29
 */


//思路：其实很简单，就是两层循环遍历，第二层的时候不要让i==j(当然这是最复杂的，因为套了两个循环)

class Q0001_TwoSum {
    public int[] twoSum(int[] nums, int target) {

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length && j != i; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }
}