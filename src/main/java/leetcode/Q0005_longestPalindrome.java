package leetcode;

/**
 * 5.最长回文子串
 *
 * @AUTHOR PizAn
 * @CREAET 2019-08-18 23:10
 */


//思路：中心扩散法，就是遍历，然后从每个节点向左右扩展（这里要分为奇数和偶数的扩散），然后s.substring求出这个子串
//难点在边界不好做

public class Q0005_longestPalindrome {
    public String longestPalindrome(String s) {

        //判空
        if (s.length() < 1 || s == null) {
            return "";
        }

        int start = 0;
        int end = 0;


        for (int i = 0; i < s.length(); i++) {

            //注意：这里是每次循环都要创建的局部变量
            int len1 = split(s, i, i);
            int len2 = split(s, i, i + 1);

            //上面是奇数偶数的长度，这里取最大值
            int len = Math.max(len1, len2);

            //这个地方判断边界挺难的，最好画个图
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    //中心扩散
    private int split(String s, int left, int right) {

        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {

            left--;
            right++;
        }
        return right - left - 1;
    }
}

