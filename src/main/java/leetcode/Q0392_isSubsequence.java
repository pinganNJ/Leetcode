package leetcode;

import java.util.Collections;

/**
 * 392. 判断子序列
 *
 * @AUTHOR PizAn
 * @CREAET 2019-09-13 16:56
 */

public class Q0392_isSubsequence {
    //给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
    public static boolean isSubsequence(String s, String t) {
        if (s.length() > t.length()) {
            return false;
        }
        //哎，这个边界条件有毒吧，这里s是空的字符串（注意这里是equals），空串是所有串的子串
        if (s.equals("")) {
            return true;
        }
        int index = 0;
        //遍历一遍长字符串，如果匹配子串的一个元素，子串的指针往后走，直到全部找到
        for (int i = 0; i < t.length(); i++) {
            if (t.charAt(i) == s.charAt(index)) {
                index++;
            }
            //这里判断一下，如果子串的指针越界了，说明全部找到了，直接返回true
            if (index >= s.length()) {
                return true;
            }
        }
        //长串走完子串也没有走完，返回false
        return false;
    }


}
