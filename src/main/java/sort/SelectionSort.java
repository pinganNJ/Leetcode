package sort;

/**
 * 选择排序
 *
 * @AUTHOR PizAn
 * @CREAET 2019-07-08 13:33
 */

public class SelectionSort {

    public void selectionSort(int[] arr){

        for (int i = 0; i < arr.length ; i++) {
            for (int j = i; j < arr.length ; j++) {
                if(arr[i] < arr[j]){
                    swap(arr,i,j);
                }
                
            }
            
        }
        
    }

    private void swap(int[] arr, int i, int j) {
    }

}
