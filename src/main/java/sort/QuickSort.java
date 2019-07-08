package sort;

import javax.sound.midi.SysexMessage;

/**
 * 快速排序：最终进化版-三项切分的随机快排(荷兰国旗问题)
 *
 * @AUTHOR PizAn
 * @CREAET 2019-07-08 14:35
 */

public class QuickSort {

    public void quickSort(int[] arr) {
        quickSortIn(arr, 0, arr.length - 1);
    }

    private void quickSortIn(int[] arr, int lo, int hi) {
        //递归终止条件
        if (lo >= hi) {
            return;
        }
        //以最后一个数为切分点，这里做一个随机处理,这里的duble转int，比如10.9转了就变成10了
        swap(arr, lo + (int) ((hi - lo + 1) * Math.random()), hi);

        int[] p = partition(arr, lo, hi);

        quickSortIn(arr, lo, p[0] - 1);
        quickSortIn(arr, p[1] + 1, hi);
    }

    //partition过程
    private int[] partition(int[] arr, int lo, int hi) {
        int less = lo - 1;
        int more = hi;
        while (lo < more) {
            if (arr[lo] > arr[hi]) {
                swap(arr, lo, --more);
            } else if (arr[lo] < arr[hi]) {
                swap(arr, ++less, lo++);
            } else {
                lo++;
            }
        }
        //将hi和more最后一个数呼唤，使得中间的全是和hi相等的
        swap(arr, more, hi);
        //返回相等的数的集合的前后
        return new int[]{less + 1, more};


    }

    private void swap(int[] arr, int i, int hi) {
    }

}
