import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Three_Sum_15{
    public static void main(String[] args) {
        
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            /*
            Because the array is sorted, if your current nums[i] is greater than zero, it is mathematically impossible for any combination of the remaining numbers to sum to zero.
            */
            if (nums[i] > 0) break;

            if (i > 0 && nums[i] == nums[i - 1])
                continue;

            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    k--;

                    while (j < k && nums[j] == nums[j - 1]) {
                        j++;
                    }
                    while (j < k && nums[k] == nums[k + 1]) {
                        k--;
                    }
                } else if (sum > 0) {
                    k--;
                } else {
                    j++;
                }
            }
        }
        return result;
    }
}

/*
# 2 Pointer Approach:
Learning:
-> Sort the Numbers: First, sort the entire array in ascending order. This is the foundation of the strategy because it naturally groups identical numbers together and organizes the data so we can logically predict how to adjust our sums.
-> Pick an Anchor: Loop through the array one number at a time. This current number acts as the first fixed piece of our triplet. We will look for two other numbers to complete it.
-> The Impossible Sum (Early Exit): Before doing any math, look at your anchor number. Because the array is sorted, if your anchor is greater than zero, every number to its right is also positive. Since three positive numbers can never add up to zero, you can immediately stop the entire search and finalize your results.
-> Skip Anchor Duplicates: If your current anchor number is identical to the one you just checked in the previous loop iteration, skip it entirely. This guarantees you will never construct duplicate triplets in your final answer.
-> Set the Two Pointers: To find the remaining two numbers, place a "left" pointer immediately after your anchor, and a "right" pointer at the very end of the array.
-> Squeeze to Find Zero: Add the numbers at your anchor, left, and right positions together and check the result:
-> If the sum is greater than zero: The total is too big. Because the array is sorted, you can make the sum smaller by moving your right pointer one step to the left.
-> If the sum is less than zero: The total is too small. You can make it bigger by moving your left pointer one step to the right.
-> If the sum is exactly zero: You found a valid triplet! Record it.
-> Skip Pointer Duplicates: After finding a valid triplet, you must move both pointers inward to look for the next combination. To save time and avoid duplicate work, keep sliding the left pointer forward if it points to a number it just used, and do the same for the right pointer. Repeat the squeezing process until the two pointers meet.

Summary :
Time Complexity = O(n^2)
Space Complexity = O(n) or O(1) (Depends on Sorting Algorithm)
*/