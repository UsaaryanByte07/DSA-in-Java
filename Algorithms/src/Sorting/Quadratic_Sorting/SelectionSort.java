package Sorting.Quadratic_Sorting;

import Sorting.SortingAlgorithm;
import Utility.Arrays;

class SelectionSort implements SortingAlgorithm{
    public static void main(String[] args) {
        int[] arr = Arrays.read();
        SortingAlgorithm selectionSort = new SelectionSort();
        System.out.println("Before Sorting: " + java.util.Arrays.toString(arr));
        selectionSort.sort(arr);
        System.out.println("After Sorting: " + java.util.Arrays.toString(arr));
    }

    @Override
    public void sort(int[] arr) {
        int n = arr.length;
        for(int i = 0; i < n - 1; i++ ){
            int minIdx = i;
            for(int j = i+1; j < n; j++){
                if(arr[minIdx] > arr[j]){
                    minIdx = j;
                }
            }
            if(minIdx != i){
                Arrays.swap(arr, minIdx, i);
            }
        }
    }
    
}
