public class Move_Zeroes_283 {
    public static void main(String[] args) {
        
    }

    public void moveZeroes(int[] nums) {
        int slow = 0;
        int fast = 0;
        for(;fast < nums.length; fast++){
            if(nums[fast] != 0) nums[slow++] = nums[fast];
        }
        for(;slow< nums.length; slow++){
            nums[slow] = 0;
        }
    }
}

/*
# Two - Pointer Approach:
Summary:
Time Complexity = O(n)
Space Complexity = O(1)
*/