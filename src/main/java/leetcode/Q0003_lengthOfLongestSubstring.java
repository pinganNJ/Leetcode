package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/**
 * 3. 无重复字符的最长子串
 *
 * @AUTHOR PizAn
 * @CREAET 2019-08-18 17:40
 */


//思路：我这个是最复杂的，就是从头开始遍历，然后将每次遍历的数放在一个set中计算长度，然后用list保存size，最好取出最大的size

public class Q0003_lengthOfLongestSubstring {

    public int lengthOfLongestSubstring(String s) {

        char[] chars = s.toCharArray();


        ArrayList<Integer> list = new ArrayList<>();

        int flag = 0;

        //遍历
        while (flag < chars.length) {
            HashSet<Character> set = new HashSet<>();
            for (int i = flag; i < chars.length; i++) {
                if (set.contains(chars[i])) {
                    break;
                }
                set.add(chars[i]);
            }
            list.add(set.size());
            flag++;
        }

        int max = 0;

        //遍历取出最大值
        for (int i = 0; i < list.size(); i++) {
            int cur = list.get(i);
            max = cur > max ? cur : max;
        }
        return max;
    }
}

