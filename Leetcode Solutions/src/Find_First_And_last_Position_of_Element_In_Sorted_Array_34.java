public class Find_First_And_last_Position_of_Element_In_Sorted_Array_34 {
    public static void main(String[] args) {
        
    }

    public int[] searchRange(int[] nums, int target) {
        return new int[]{searchFirst(nums, target),searchLast(nums, target)};
    }

    public static int searchLast(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        int result = -1;
        int mid = 0;
        while (low <= high) {
            mid = low + (high - low) / 2;
            if(nums[mid] == target){ 
                result = mid;
                low = mid + 1;
            }
            else if(nums[mid] > target){
                high = mid -1;
            }
            else{ 
                low = mid + 1;
            }
        }
        return result;
    }

    public static int searchFirst(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        int result = -1;
        int mid = 0;
        while (low <= high) {
            mid = low + (high - low) / 2;
            if(nums[mid] == target){ 
                result = mid;
                high = mid - 1;
            }
            else if(nums[mid] > target){
                high = mid -1;
            }
            else{ 
                low = mid + 1;
            }
        }
        return result;
    }
}

/*
Learning:
Remember there can be more then 2 dupliactes
Summary:
Time Complexity = O(logn)
Space Complexity = O(1)
*/