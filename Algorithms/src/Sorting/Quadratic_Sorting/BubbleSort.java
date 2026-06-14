package Sorting.Quadratic_Sorting;

import Sorting.SortingAlgorithm;
import Utility.Arrays;

class BubbleSort implements SortingAlgorithm {
    public static void main(String[] args) {
        int[] arr = Arrays.read();
        SortingAlgorithm bubbleSort = new BubbleSort();
        System.out.println("Before Sorting: " + java.util.Arrays.toString(arr));
        bubbleSort.sort(arr);
        System.out.println("After Sorting: " + java.util.Arrays.toString(arr));
    }

    @Override
    public void sort(int[] arr) {
        int n = arr.length;
        for(int i = 0; i < n - 1; i++){
            for(int j = 0; j < n - i - 1; j++){
                if(arr[j] > arr[j+1]){
                    Arrays.swap(arr, j, j+1);
                }
            }
        }
    }
}
