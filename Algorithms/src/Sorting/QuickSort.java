package Sorting;

import Utility.Arrays;

class QuickSort implements SortingAlgorithm {
    public static void main(String[] args) {
        int[] arr = Arrays.read();
        SortingAlgorithm quickSort = new QuickSort();
        System.out.println("Before Sorting: " + java.util.Arrays.toString(arr));
        quickSort.sort(arr);
        System.out.println("After Sorting: " + java.util.Arrays.toString(arr));
    }

    @Override
    public void sort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    private static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int mid = partition(arr, low, high);
            quickSort(arr, low, mid - 1);
            quickSort(arr, mid + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[low];
        int p = low + 1;
        int q = high;
        while (p < q) {
            while (arr[p] < pivot && p < high) {
                p++;
            }
            while (arr[q] > pivot) {
                q--;
            }
            if(p < q){
                Arrays.swap(arr, p, q);
                //To Avoid Been Trapped in a Infinite Loop in case of duplicate elements
                p++;
                q--;
            }
        }
        // Safety check before final swap:
        // Because we manually decremented q, we must ensure arr[q] is actually <= pivot 
        // before swapping it with the pivot. If not, q needs to step back.
        if (arr[q] > pivot) {
            q--;
        }
        Arrays.swap(arr, q, low);
        return q;
    }

}
