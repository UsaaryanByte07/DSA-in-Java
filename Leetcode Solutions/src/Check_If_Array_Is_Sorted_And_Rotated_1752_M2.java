public class Check_If_Array_Is_Sorted_And_Rotated_1752_M2 {
    public static void main(String[] args) {
        
    }

    public boolean check(int[] nums) {
        int drops = 0;
        int n = nums.length;
        for(int i = 0; i < n; i++){
            if(nums[i] > nums[(i+1)%n]) drops++;
            if(drops > 1) return false;
        }
        return true;
    }
}

/*
# Cleaner Solution:
Learning:
-> In rotated sorted Array there can be max 1 drop (Decrement in value when moving from one element to other while moving from left to right)
-> We use % to travel a rotated Array efficiently

Summary:
Time Complexity = O(n)
Space Complexity = O(1)
*/