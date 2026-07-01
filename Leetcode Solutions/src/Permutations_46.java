import java.util.ArrayList;
import java.util.List;

public class Permutations_46 {
    public static void main(String[] args) {
        
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> visited = new ArrayList<>();
        helper(nums, result, visited);
        return result;
    }

    public static void helper(int[] nums, List<List<Integer>> result, List<Integer> visited) {
        if(visited.size() == nums.length) {
            result.add(new ArrayList<>(visited));
            return;
        }
        for (int j = 0; j < nums.length; j++) {
            if (!visited.contains(nums[j])) {
                visited.addLast(nums[j]);
                helper(nums, result, visited);
                visited.removeLast();
            }
        }
    }
}

/*
Learning:
Wrong Code:
Java
```
 public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();

        List<Integer> visited = new ArrayList<>();

        helper(nums, result, visited);

        return result;

    }



    public static void helper(int[] nums, List<List<Integer>> result, List<Integer> visited) {

        if(visited.size() == nums.length) {

            result.add(visited);

            visited.removeLast();

            return;

        }

        for (int j = 0; j < nums.length; j++) {

            if (!visited.contains(nums[j])) {

                visited.addLast(nums[j]);

                helper(nums, result, visited);

            }

        }

    }
```
Here are the 3 Flaws in the above Solution
1. The Reference Trap (Object vs. Copy)
In Java, objects (like ArrayList) are passed by reference.

Java
```
if(visited.size() == nums.length) {
    result.add(visited); // CRITICAL BUG
}
```
Because there is only one visited list in your entire program, result.add(visited) just adds a pointer to that exact same list. As your program continues to add and remove numbers from visited, it modifies the data inside your result list as well. By the end of the program, your result will just be a collection of pointers pointing to a single, empty list.

The Fix: You must make a deep copy of the list at the exact moment it is complete: result.add(new ArrayList<>(visited));.
2. Missing Backtracking in the Loop
Backtracking requires three steps: Choose an option, Explore that option recursively, and then Un-choose (backtrack) so you can try the next option.

Java
```
if (!visited.contains(nums[j])) {
    visited.addLast(nums[j]);     // 1. Choose
    helper(nums, result, visited); // 2. Explore
    // 3. UN-CHOOSE IS MISSING HERE
}
```
Because you never remove the number after the helper function returns, your list stays full, and the loop cannot try the other permutations.
3. Incorrect Backtracking in the Base Case
You placed visited.removeLast(); inside your base case (if(visited.size() == nums.length)). The base case's only job is to record the completed permutation and stop the current recursive branch. Backtracking must happen immediately after a recursive call inside the for loop, not in the base case.

Summary:
Time Complexity = O(n*n!) (There are n! (n factorial) possible permutations. For each permutation, creating the deep copy takes O(n) time.)
Space Complexity = O(n) (The depth of the recursion tree is n, and the currentPermutation list holds at most n elements at a time. (This does not count the output array result, which takes O(n * n!) space).)
*/