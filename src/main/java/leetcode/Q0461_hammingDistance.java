package leetcode;

import java.util.Stack;

/**
 * 461.汉明距离
 *
 * @AUTHOR PizAn
 * @CREAET 2019-08-20 12:58
 */


//思路：先异或得到一个数（异或：相同为0，不同为1），然后右移和1异或，为1则num++

public class Q0461_hammingDistance {
    public int hammingDistance(int x, int y) {

        //x和y异或之后，相同的位是0，不同的位是1
        int a = x ^ y;
        int num = 0;
        //然后a和1与，如果是1，就代表那个位是1，然后右移一位
        while (a != 0) {
            if ((a & 1) == 1) {
                num++;
            }
            a = a >> 1;
        }
        return num;
    }
}
