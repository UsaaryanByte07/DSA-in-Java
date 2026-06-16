public class Sort_An_Array_912_M2 {
    public static void main(String[] args) {

    }

    public int[] sortArray(int[] nums) {
        int[] temp = new int[nums.length];
        mergeSort(nums, temp, 0, nums.length - 1);
        return nums;
    }

    public static void mergeSort(int[] nums, int[] temp, int low, int high) {
        if (low < high) {
            int mid = low + (high - low) / 2;
            mergeSort(nums, temp, low, mid);
            mergeSort(nums, temp, mid + 1, high);
            merge(nums, temp, low, mid, high);
        }
    }

    public static void merge(int[] arr, int[] temp, int low, int mid, int high) {
        for (int i = low; i <= high; i++) {
            temp[i] = arr[i];
        }
        int i = low;
        int j = mid + 1;
        int k = low;
        while (i <= mid && j <= high) {
            if (temp[i] <= temp[j]) {
                arr[k++] = temp[i++];
            } else {
                arr[k++] = temp[j++];
            }
        }
        while (i <= mid) {
            arr[k++] = temp[i++];
        }
    }
}

/*
 * #Global Auxiliary Array Merge Sort Method
 * Learning:
 * 1) Prevents Memory Thrashing: Local allocation calls new int[] at every
 * recursive step. This forces Java's Garbage Collector to constantly pause the
 * program to clean up thousands of discarded arrays, killing real-world
 * execution speed. The global approach allocates memory exactly once.
 * 2) Restores Sorting Stability: Using < instead of <= during the merge causes
 * identical elements to swap their original relative order. Merge Sort is
 * strictly supposed to be a stable sort.
 * 3) Eliminates Redundant Index Math: Local allocation requires calculating
 * complex relative offsets (e.g., (mid + 1) + j). The global approach maps
 * everything directly to the absolute indices of the original array, saving CPU
 * cycles.
 * 4) Skips Unnecessary Copying: In the global approach, elements left over in
 * the right half of the split do not need a while loop to be copied back at the
 * end of the merge. Because you are overwriting the main array directly from
 * the global temp array, untouched right-side elements are already sitting in
 * their exact correct final positions.
 * Summary:
 * Time Complexity = O(nlogn)
 * Space Complexity = O(n)
 * 
 * Note:
 * -> Can Also use QuickSort at the Cost of Stable Time Complexity of O(nlogn)
 * but O (n) Space Complexity.
 * -> After Learning Heapsort and Countsort Revisit this Problem.
 */