package sort;

/**
 * 冒泡排序
 *
 * @AUTHOR PizAn
 * @CREAET 2019-07-08 14:21
 */

public class BubbleSort {

    public void bubbleSort(int[] arr) {
        //最后一个不要排序
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }
    }

    //bubble改进版，当循环到某一时刻，数组已经有序了，就不用再比较排序了，直接跳出循环
    public void buSRevolution(int[] arr) {
        //最后一个不要排序
        for (int i = 0; i < arr.length - 1; i++) {
            //每次循环的时候，我这里都加一个记录数
            int count = 0;
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                    count++;
                }
            }
            //如果测试数没有变化，就直接跳出循环
            if (count == 0) {
                System.out.println("attention：" + "已经排好序了，可以结束了");
                break;
            }

        }

    }


    private void swap(int[] arr, int j, int i) {
    }

}
