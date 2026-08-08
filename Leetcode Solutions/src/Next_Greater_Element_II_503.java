import java.util.Stack;

public class Next_Greater_Element_II_503 {
    public static void main(String[] args) {
        
    }
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();
        // Loop from (2n - 1) down to 0 to simulate the circular array
        for(int i = 2*n - 1; i >= 0; i--){
            // Use modulo to safely wrap around the index
            int currIdx = i%n;

            // Pop elements from the stack that are smaller than or equal to the current element
            while (!stack.isEmpty() && stack.peek() <= nums[currIdx]) {
                stack.pop();
            }

            // We only need to record the answer during the second pass (when i < n)
            if (i < n) {
                // If stack is empty, there is no greater element. Otherwise, it's the top of the stack.
                result[currIdx] = stack.isEmpty() ? -1 : stack.peek();
            }

            // Add the current element to the stack for the next numbers to evaluate
            stack.push(nums[currIdx]);
        }
        return result;
    }
}

/*
# Monotonic Stack Method:
Learning:
-> Create an empty stack.
-> Traverse the array from right to left.
-> Remove every element from the stack that is smaller than or equal to the                current element.
-> The remaining top of the stack (if any) is the next greater element.
Push the current element into the stack.
-> Repeat the same traversal once more without clearing the stack.
     --> Now the stack already contains elements from the first traversal,  allowing elements near the end of the array to find greater elements at the beginning.

Summary:
Time Complexity = O(n)
Space Complexity = O(n)
*/