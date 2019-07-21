
package sort;

public class HeapSort {

    public static void heapSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            heapInsert(arr, i);
        }

        int size = arr.length;
        swap(arr, 0, --size);
        while (size > 0) {
            heapify(arr, 0, size);
            swap(arr, 0, --size);
        }
    }
    // 将index上浮到最大，將数组变成大根堆形式
    private static void heapInsert(int[] arr, int index) {
        while (arr[index] > arr[(index - 1) / 2]) {
            swap(arr, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }

    }

    // 将index下沉到最小，在交换了0和最后一个元素后，重新调整，变成 大根堆
    private static void heapify(int[] arr, int index, int size) {
        int left = 2 * index + 1;
        //在index、index的左右子节点中找到最大的那个
        while (left < size) {

            // 在index的左右节点比出大小
            int largest = left + 1 < size && arr[left + 1] > arr[left] ? left + 1 : left;// 左右孩子哪个大，谁的下标就是largest

            // 左右子节点的胜者再和index比较，如果还是index大，那么就不要下沉，直接退出，如果比index大，那么下沉，
            // 在这个堆排序中，0与最后一个元素交换后，index初始化为0，将0处的元素下沉
            largest = arr[index] > arr[largest] ? index : largest;

            if (largest == index) {
                break;
            }

            // 将index和largest交换，也就是将小的下沉了
            swap(arr, index, largest);
            // index指向最大的，这里肯定是之前的index的子节点了
            index = largest;

            left = 2 * index + 1;
        }

    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;

    }
}