package sort;

/**
 * 归并排序
 *
 * @AUTHOR PizAn
 * @CREAET 2019-07-08 14:05
 */

public class MergeSort {
    private int[] arrSup;
    public void mergeSort(int[] arr) {
        //需要一个辅助数组
        arrSup = new int[arr.length];
        //排序函数
        sort(arr, 0, arr.length - 1);
    }

    //递归
    private void sort(int[] arr, int lo, int hi) {
        //递归结束条件
        if (lo >= hi) {
            return;
        }
        //取中点
        int mid = (lo + hi) / 2;
        //将lo~mid排序
        sort(arr, lo, mid);
        //将mid+1~hi排序
        sort(arr, mid + 1, hi);
        //merge函数
        merge(arr, lo, mid, hi);
    }

    private void merge(int[] arr, int lo, int mid, int hi) {
        //这两个是起点
        int i = lo;
        int j = mid + 1;

        //将两个排好序的小数组复制到我们的辅助数组中来
        for (int k = lo; k <= hi ; k++) {
            arrSup[k] = arr[k];
        }
        //将辅助数组中的数再复制到原数组中，只不过这次是带条件的复制
        for (int k = lo; k <= hi ; k++) {
            //一顿操作猛如虎
            if(i > mid){
                arr[k] = arrSup[j++];
            }else if (j > hi){
                arr[k] = arrSup[i++];
            }else if (arrSup[i] > arrSup[j]){
                arr[k] = arrSup[j++];
            }else {
                arr[k] = arrSup[i++];
            }
        }
    }
}
