package sort;

/**
 * 插入排序
 *
 * @AUTHOR PizAn
 * @CREAET 2019-07-08 13:37
 */

public class InsertSort {

    public void insertSort(int[] arr) {
        //第一张牌不需要排序 ，所以从第一张牌开始
        for (int i = 1; i < arr.length; i++) {
            //从手头上这张牌往前检查，一张一张地对比
            for (int j = i; j > 0; j--) {
                if (arr[j] < arr[j - 1]) {
                    swap(arr, i, j - 1);

                }

            }


        }


    }

    private void swap(int[] arr, int i, int j) {
    }

}
