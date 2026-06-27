public class Remove_Duplicates_From_A_Sorted_Array_26 {
    public static void main(String[] args) {
        
    }

    public int removeDuplicates(int[] nums) {
        if(nums.length == 0) return 0;
        int slow = 0;
        int fast = 1;
        while(fast < nums.length){
            if(nums[slow] != nums[fast]){
                nums[++slow] = nums[fast];
            }
            fast++;
        }
        return slow + 1;
    }
}

/*
Summary:
Time Complexity = O(n)
Space Complexity = O(1)
*/