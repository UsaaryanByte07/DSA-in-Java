public class Sort_An_Array_912_M1 {
    public static void main(String[] args) {

    }

    public int[] sortArray(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
        return nums;
    }

    public static void mergeSort(int[] nums, int low, int high) {
        if (low < high) {
            int mid = low + (high - low) / 2;
            mergeSort(nums, low, mid);
            mergeSort(nums, mid + 1, high);
            merge(nums, low, mid, high);
        }
    }

    public static void merge(int[] arr, int low, int mid, int high) {
        int i, j, k;
        int n1 = mid - low + 1;
        int n2 = high - mid;
        int[] left = new int[n1];
        int[] right = new int[n2];
        for (i = 0; i < n1; i++) {
            left[i] = arr[low + i];
        }
        for (j = 0; j < n2; j++) {
            right[j] = arr[(mid + 1) + j];
        }
        i = 0;
        j = 0;
        k = low;
        while (i < n1 && j < n2) {
            if (left[i] <= right[j]) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
            }
        }
        while (i < n1) {
            arr[k++] = left[i++];
        }
        while (j < n2) {
            arr[k++] = right[j++];
        }
    }
}

/*
 * #Local Allocation Merge Sort Method
 * Learning:
 * Less Optimized then Global Auxiliary Array Merge Sort Method
 * Summary:
 * Time Complexity = O(nlogn)
 * Space Complexity = O(n)
 * Note:
 * -> Can Also use QuickSort at the Cost of Stable Time Complexity of O(nlogn)
 * but O (n) Space Complexity.
 * -> After Learning Heapsort and Countsort Revisit this Problem.
 */