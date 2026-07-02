public class Find_the_Kth_Largest_Element_215_M2 {
    public static void main(String[] args) {
        
    }

    public int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, k, 0, nums.length - 1);
    }

    public static int quickSelect(int[] nums, int k, int low, int high){
        int n = nums.length;
            int mid = partition(nums, low, high);
            if(mid == n - k) return nums[mid];
            else if(mid < n - k) return quickSelect(nums, k, mid + 1, high);
            else return quickSelect(nums, k, low, mid - 1);
    }

    public static int partition(int[] nums, int low, int high){
        int pivot = nums[low];
        int p = low + 1;
        int q = high;
        while(p < q){
            while (nums[p] < pivot && p < high) {
                p++;
            }
            while (nums[q] > pivot) {
                q--;
            }
            if(p < q){
                swap(nums, p, q);
                //To Avoid Been Trapped in a Infinite Loop in case of duplicate elements
                p++;
                q--;
            }
        }

        // Safety check before final swap:
        // Because we manually decremented q, we must ensure arr[q] is actually <= pivot 
        // before swapping it with the pivot. If not, q needs to step back.
        if(nums[q] > pivot){
            q--;
        }
        swap(nums, q, low);
        return q;
    }

     public static void swap(int[] arr, int idx1, int idx2){
        int temp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = temp;
    }
}

/*
# QuickSort Approach
Learning:
* The method translates the problem of finding the K-th largest element into finding the target index, which is the length of the array minus K.
* It uses a recursive QuickSelect algorithm to find this target index without sorting the entire array.
* The partition function deterministically selects the first element of the current sub-array as the pivot.
* Two pointers are initialized: a left pointer starting immediately after the pivot, and a right pointer at the end of the current range.
* The left pointer advances forward as long as it encounters elements smaller than the pivot.
* The right pointer moves backward as long as it encounters elements larger than the pivot.
* When both pointers stop, if the left pointer is still before the right pointer, their values are swapped.
* After a swap, both pointers step inward to prevent infinite loops when encountering duplicate values.
* This partitioning process continues until the left and right pointers cross each other.
* A final safety check ensures the right pointer is pointing to an element less than or equal to the pivot before swapping the pivot into its final, globally sorted position.
* If the pivot's new index exactly matches the target index, the algorithm returns that element as the final solution.
* If the target index is strictly greater than the pivot's index, the algorithm recursively searches the right half.
* If the target index is strictly smaller, the algorithm recursively searches the left half.
* While the average time complexity is O(N), choosing the first element as the pivot results in a worst-case O(N^2) time complexity if the input array is already sorted.

Summary:
Time Complexity:
In Average Case = O(n)
In Worst Case = O(n^2)
Space Complexity = O(n) (Due to Recursion Call Stack)
*/