public class Search_In_Rotated_Sorted_Array_33 {
    public static void main(String[] args) {
        
    }

    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while (high >= low) {
            int mid = low + ((high - low) / 2);
            if (nums[mid] == target) {
                return mid;
            } 
            // Check if left part is sorted
            else if (nums[mid] >= nums[high]) {
                if (target >= nums[low] && target < nums[mid]) {
                    high = mid - 1; // move left
                } else {
                    low = mid + 1; // move right
                }
            } 
             // Right part is sorted
            else {
                if (target > nums[mid] && target <= nums[high]) {
                    low = mid + 1; // move right
                } else {
                    high = mid - 1; // move left

                }
            }
        }
        return -1;
    }
}

/*
Learning:
1) Explanation:
When an array is rotated and sorted, one part of the array is always sorted, and the other part contains the pivot (the rotated part).
Using this observation, we can decide which side to eliminate using binary search.
At any index mid:
Either the left half is sorted
Or the right half is sorted
If the target lies inside the sorted half, we move towards that half.
Otherwise, we move towards the unsorted half.

2) Algorithm:
-> Use two pointers: start and end.
-> Calculate mid.
-> If nums[mid] == target, return the index directly.
-> Determine which half is sorted:
     -> If nums[mid] > nums[end], left half is sorted.
     -> Else, right half is sorted.
-> Check if the target lies inside the sorted half:
     -> If yes → move towards that side.
     -> Else → move towards the other side.
-> Continue until start > end.

If not found, return -1.

Summary:
Time Complexity = O(logn)
Space Complexity = O(1)
*/