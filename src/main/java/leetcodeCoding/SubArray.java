package leetcodeCoding;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * 求一个数组所有的子数组
 * <p>
 * 思路：用递归，数组的每一个索引下都有true/false这两个选项，
 *
 * @AUTHOR PizAn
 * @CREAET 2019-07-05 23:51
 */

public class SubArray {


    public static Set<List<Integer>> set = new HashSet<>();


    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        boolean[] booleans = new boolean[arr.length];

        find(arr, 0, booleans);
        System.out.println("set：" + set);

    }

    //创建一个递归算法
    private static void find(int[] arr, int pos, boolean[] booleans) {

        if (pos == arr.length) {
            List<Integer> list = new LinkedList<>();
            for (int i = 0; i < arr.length; i++) {
                if (booleans[i] == true) {
                    list.add(arr[i]);
                }
            }
            set.add(list);
        } else {
            //这个位置变成true，表示加入
            booleans[pos] = true;
            find(arr, pos + 1, booleans);

            ////这个位置变成false，表示不加入
            booleans[pos] = false;
            find(arr, pos + 1, booleans);
        }

    }


}
