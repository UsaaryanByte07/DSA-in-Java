import java.util.ArrayList;
import java.util.List;

public class Subsets_78 {
    public static void main(String[] args) {
        
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        helper(nums, 0, subsets, curr);
        return subsets;
    }
    public static void helper(int[] nums, int idx, List<List<Integer>> subsets, List<Integer> curr){
        if(idx == nums.length){
            subsets.add(new ArrayList<>(curr));
            return;
        }

        //Choice 1: Take the Current Number
        curr.add(nums[idx]); // Put it in the bucket
        helper(nums, idx + 1, subsets, curr); // Move to the next number

        // BACKTRACK: Take it out of the bucket before we try Choice 2
        curr.remove(curr.size() - 1);

        //Choice 2: Don't Take the Current Number
        helper(nums, idx + 1, subsets, curr); // Move to the next number
    }
}

/*
Learning:
The easiest way to understand LeetCode #78 (Subsets) is to stop trying to think about "building" subsets, and instead think about it as a series of Yes/No decisions.
# The Approach: The "Include / Exclude" Tree
Imagine you are holding an empty bucket, and you are walking past a line of numbers. For every single number you walk past, you have exactly two choices:

Include it: Pick it up and put it in your bucket.

Exclude it: Leave it on the ground and walk past it.

Let's look at the array [1, 2, 3].

Step 1: You stand in front of 1.

Branch A (Include): Your bucket has [1].

Branch B (Exclude): Your bucket has [].

Step 2: You stand in front of 2.

From Branch A, you can include 2 [1, 2] or exclude it [1].

From Branch B, you can include 2 [2] or exclude it [].

Step 3: You stand in front of 3. You make the same Yes/No choice for all current timelines.

When do we stop? You stop when you have walked past all the numbers (when your index reaches the length of the array). At that exact moment, whatever is currently inside your bucket is a valid subset. You take a snapshot of your bucket, save it to your results, and then step backward in time (backtrack) to try the other choice.

Summary:
Time Complexity = O(n*(2^n)) (For an array of length n, there are exactly 2^n possible subsets (because you make 2 choices for each of the n numbers). For each subset, copying it into the result list takes O(n) time.)
Space Complexity = O(n) ( This is the memory used by the recursion call stack and our temporary currentSubset bucket. The recursion will only ever go as deep as the length of the array before it hits the base case and returns. (Note: We do not count the output array in space complexity analysis).)
*/