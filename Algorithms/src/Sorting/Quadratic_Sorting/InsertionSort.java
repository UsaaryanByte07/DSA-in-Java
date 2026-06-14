package Sorting.Quadratic_Sorting;

import Sorting.SortingAlgorithm;
import Utility.Arrays;

class InsertionSort implements SortingAlgorithm{
    public static void main(String[] args) {
        int[] arr = Arrays.read();
        SortingAlgorithm insertionSort = new InsertionSort();
        System.out.println("Before Sorting: " + java.util.Arrays.toString(arr));
        insertionSort.sort(arr);
        System.out.println("After Sorting: " + java.util.Arrays.toString(arr));
    }

    @Override
    public void sort(int[] arr) {
        int n = arr.length;
        for(int i = 1; i < n; i++){
            int key = arr[i];
            int j = i - 1;
            while(j >= 0 && arr[j] > key){
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = key;
        }
    }
}
