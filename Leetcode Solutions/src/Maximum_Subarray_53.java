public class Maximum_Subarray_53 {
    public static void main(String[] args) {
        
    }

    public int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int currSum = 0;
        for(int i = 0; i < nums.length; i++){
            currSum += nums[i];
            if(currSum > maxSum) maxSum = currSum;
            if(currSum < 0) currSum = 0;
        }

        return maxSum;
    }
}

/*
# Kadane's Algorithm:

Learning:
1) A negative running sum can never help build a larger future subarray.
    So,
    -> Keep adding elements to the current sum.
    -> Update the maximum sum whenever the current sum becomes larger.
    -> If the current sum becomes negative, discard it and start a new subarray.
    -> This greedy observation leads to Kadane's Algorithm.
2) Algorithm:
    -> Initialize currSum = 0 and maxSum = Integer.MIN_VALUE.
    -> Traverse the array.
    -> Add the current element to currSum.
    -> Update maxSum.
    -> If currSum becomes negative, reset it to 0.

Summary:
Time Complexity = O(n)
Space Complexity = O(1)
*/