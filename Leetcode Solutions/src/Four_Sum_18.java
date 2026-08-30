import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Four_Sum_18{
    public static void main(String[] args) {
        
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        // Stop at length - 3 because we need at least 4 elements
        for (int i = 0; i < nums.length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue;

            for (int j = i + 1; j < nums.length - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1])
                    continue;

                int k = j + 1;
                int h = nums.length - 1;

                while (k < h) {
                    long sum = (long) nums[i] + nums[j] + nums[k] + nums[h];

                    if (sum == target) {
                        result.add(Arrays.asList(nums[i], nums[j], nums[k], nums[h]));
                        k++;
                        h--;

                        // Safely bounds-checked duplicate skipping
                        while (k < h && nums[k] == nums[k - 1])
                            k++;
                        while (k < h && nums[h] == nums[h + 1])
                            h--;
                    } else if (sum > target) {
                        h--;
                    } else {
                        k++;
                    }
                }
            }
        }
        return result;
    }
}

/*
# 3 - Pointer Approach:
Learning:
-> **Sort the Array:** Arrange the numbers in ascending order. This naturally groups identical numbers together and allows you to systematically adjust your running total by moving pointers left or right.
-> **Set the First Anchor:** Loop through the array to pick your first number. If it is identical to the number you checked in the previous step, skip it entirely to prevent duplicate combinations in your final answer.
-> **Set the Second Anchor:** Start a second loop to pick another number immediately following your first anchor. Just like before, skip this number if it matches the one you just checked in this inner sequence.
-> **Deploy the Pointers:** Place a "left" pointer immediately after your second anchor, and a "right" pointer at the very end of the array.
-> **Calculate Safely:** Add all four numbers together. Because adding four large numbers can exceed standard memory limits (integer overflow), calculate this total using a larger data format to prevent math errors.
-> **Squeeze the Pointers:** Compare your safe sum to the target. If the sum is smaller than the target, move the left pointer one step right to increase the total. If it is larger than the target, move the right pointer one step left to decrease the total.
-> **Record and Skip:** When the sum exactly matches your target, record the four numbers. Then, move both pointers inward, actively skipping over any identical consecutive numbers to ensure you never log the exact same combination twice.

Summary:
Time Complexity = O(n^3)
Space Complexity = O(n) or O(1) (Depending on the Sorting Algorithm)
*/