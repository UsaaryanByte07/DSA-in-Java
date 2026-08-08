import java.util.HashMap;
import java.util.Stack;

public class Next_Greater_Element_I_496 {
    public static void main(String[] args) {
        
    }

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> nextGreaterMap = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < nums2.length; i++){
            // While the stack isn't empty AND the current number is greater 
            // than the top of the stack, we've found the answer for the top element!
            while(!stack.isEmpty() && nums2[i] > stack.peek()){
                nextGreaterMap.put(stack.pop(), nums2[i]);
            }
            // Push the current number onto the stack to wait for a greater element
            stack.push(nums2[i]);
        }

        // Elements still on the stack have no greater element to their right
        while (!stack.isEmpty()) {
            nextGreaterMap.put(stack.pop(), -1);
        }

        int[] result = new int[nums1.length];
        for(int i = 0; i < nums1.length; i++){
            result[i] = nextGreaterMap.get(nums1[i]);
        }
        return result;
    }
}

/*
# Monotonic Stack Method
Learning:
1) What is Monotonic Stack ?
-> A Monotonic Stack is just a regular stack data structure with one strict, unbreakable rule: its elements must always stay sorted (either strictly increasing or strictly decreasing) from the bottom of the stack to the top.
-> You don't sort the stack after adding elements. Instead, you enforce the rule before pushing a new element. If adding the new element would break the sorted order, you pop elements off the top of the stack until the rule is safe again, and then you push the new element.

2) Concept:
-> Instead of taking an element and scanning the rest of the array to find something bigger (which causes the $O(n^2)$ nested loop), we do the opposite: we iterate through the array once and use a Stack as a waiting room for numbers that haven't found their "next greater element" yet.

3) Algorithm:
-> The Iteration: We walk through the main array (nums2) one number at a time.
-> The Resolution: For each new number, we check the top of our stack. If the new number is greater than the number sitting at the top of the stack, congratulations—this new number is the "next greater element" for that stacked number!
-> The Record-Keeping: We pop that smaller number off the stack, and record the answer in a HashMap (key = popped number, value = new greater number). We keep popping until the top of the stack is no longer smaller than our new number.
-> The Waiting: We then push our new number onto the stack, so it can wait for an even larger number to come along.

4) Why the Time Complexity is not O(n^2) Even after a while loop inside a for loop ?
-> Even though there is a while loop inside a for loop, look closely at how the elements behave: every single element is pushed onto the stack exactly once, and popped off the stack exactly once.
-> Therefore, for an array of size n, the stack operations happen at most 2n times. O(2n) simplifies to an overall Time Complexity of O(n).

Summary:
Time Complexity = O(n)
Space Complexity = O(n)
*/