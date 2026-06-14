public class Build_Array_From_Permutation_1920_M2 {
    public static void main(String[] args){
        
    }

    
    public int[] buildArray(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            nums[i] += 1000 * (nums[nums[i]]%1000);
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] /= 1000;
        }
        return nums;
    }
}

/*
#In-Place Method
Learning:
1. The Logic of Two Values in One (Encoding)
Concept: You can store two distinct numbers in a single integer using the formula: New = Current + (Target x 1000).
Why it works: Because the problem constraints state all numbers are less than 1000, multiplying the target by 1000 safely pushes it into the thousands place. The original current value sits safely in the last three digits.


2. The Use of Modulo (`%`)
The Problem: Because you are modifying the array in place, you might need to read an index that has already been altered earlier in the loop.
The Fix: Using `nums[i] % 1000` mathematically strips away the newly added thousands place, perfectly retrieving the original, unmodified value of that element.


3. The Importance of the Second Iteration (Extraction)
The Problem: After the first loop, the array is full of combined numbers (like `9004`).
The Fix: You must loop a second time using `nums[i] = nums[i] / 1000`. Because Java integer division drops decimals, this completely destroys the original values and leaves only the desired target values behind.


4. The Overall Flow
Pass 1 (Encode): Loop through the array. Calculate the combined value for each element and overwrite `nums[i]`.
Pass 2 (Decode): Loop through the array again. Divide every element by 1000 to finalize the in-place modification.
Summary:
O(n) Time Complexity, O(1) Space Complexity.
*/