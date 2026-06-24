public class Find_Duplicate_Number_287_M1 {
    public static void main(String[] args) {
        
    }

    public int findDuplicate(int[] nums) {
        int len = nums.length;
        for (int num : nums) {
            int idx = Math.abs(num);
            if (nums[idx] < 0) {
                return idx;
            }
            nums[idx] = -nums[idx];
        }
        return len;
    }
}

/*
#Marking Visited Elements with in Array Method:
Learning:
1) This Method is Not the Correct Solution for the problem as the problem asked that the original array should not be modified, But Still the Approach is Worth Understanding.
2) Logic Behind the Solution:
-> The Core Concept (Index Mapping): 
The problem states that there are n + 1 integers, and each integer is in the range [1, n]. Because every number in the array is strictly less than the length of the array, every number can perfectly act as a valid index for the array itself. This allows us to treat the array like a sequence of connected rooms. The value inside the room tells us which room to visit next.
-> Step-by-Step Logic:
=> The algorithm iterates through the array and uses the sign of the numbers (positive or negative) as a memory tool to track whether an index has been visited.
=> Extract the Pointer: As you loop through the array, you look at the current number. You take its absolute value idx = Math.abs(num) because the number might have been made negative in a previous step.
=> Check the Target Room: You go to the index that matches that number (nums[idx]).
=> Is it Positive? (First Visit): If nums[idx] is positive, it means we have never seen the number idx before. We "mark" this index as visited by making the value inside it negative: nums[idx] = -nums[idx].
=> Is it Negative? (Duplicate Found): If nums[idx] is already negative, it means we have already been to this index. How did we get here before? We must have seen the number idx earlier in the array! Therefore, idx is our duplicate number.
3) Example Dry Run:
Let's trace the array nums = [1, 3, 4, 2, 2].
Note: Since numbers are in the range [1, n], we never use index 0 as a destination, which prevents the first element from accidentally marking itself.
-> Iteration 0 (Current num = 1):
=> idx = Math.abs(1) = 1
=> Check nums[1], which is 3 (Positive).
=> Make it negative: nums[1] = -3. Array becomes [1, -3, 4, 2, 2].
-> Iteration 1 (Current num = -3):
=> idx = Math.abs(-3) = 3
=> Check nums[3], which is 2 (Positive).
=> Make it negative: nums[3] = -2. Array becomes [1, -3, 4, -2, 2].
-> Iteration 2 (Current num = 4):
=> idx = Math.abs(4) = 4
=> Check nums[4], which is 2 (Positive).
=> Make it negative: nums[4] = -2. Array becomes [1, -3, 4, -2, -2].
-> Iteration 3 (Current num = -2):
=> idx = Math.abs(-2) = 2
=> Check nums[2], which is 4 (Positive).
=> Make it negative: nums[2] = -4. Array becomes [1, -3, -4, -2, -2].
-> Iteration 4 (Current num = -2):
=> idx = Math.abs(-2) = 2
=> Check nums[2], which is -4 (Negative!).
=> Result: Since nums[2] is already negative, we know we have seen the number 2 before. Return 2.

Summary:
Time Complexity = O(n)
Space Complexity = O(1)
*/