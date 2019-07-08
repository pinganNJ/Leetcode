package sort;

/**
 * 希尔排序:插入排序得变体，使数组中任意间隔为h的元素都是有序的
 *
 * @AUTHOR PizAn
 * @CREAET 2019-07-08 13:46
 */

public class ShellSort {

    public void shellSort(int[] arr) {

        //数组长度
        int num = arr.length;
        //初始化标签
        int h = 1;

        //获得最大的h
        while (h < num / 3) {
            h = h * 3 + 1;
        }

        //每隔h排序：使数组中任意间隔为h的元素都是有序的
        while (h >= 1) {
            for (int i = h; i < num; i++) {
                for (int j = i; j >= h; j -= h) {
                    if (arr[j] < arr[j - h]) {
                        swap(arr, j, j - h);
                    }

                }

            }
            h = h / 3;

        }


    }

    private void swap(int[] arr, int j, int i) {
    }
}
