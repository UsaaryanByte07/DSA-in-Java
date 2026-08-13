public class Remove_K_Digits_402 {
    public static void main(String[] args) {
        
    }

    public String removeKdigits(String num, int k) {
        // Edge case: if we have to remove all digits
        if (k >= num.length()) return "0";
        
        // We use a StringBuilder as a stack to easily manipulate the characters
        StringBuilder stack = new StringBuilder();
        
        for (char digit : num.toCharArray()) {
            // While stack is not empty, AND we still have removals left,
            // AND the current digit is smaller than the last digit in our stack
            while (stack.length() > 0 && k > 0 && stack.charAt(stack.length() - 1) > digit) {
                // Pop the larger digit
                stack.deleteCharAt(stack.length() - 1);
                k--;
            }
            // Push the current digit onto the stack
            stack.append(digit);
        }
        
        // If we still have removals left (e.g., the number was "1234"), 
        // remove the largest remaining digits from the end.
        while (k > 0) {
            stack.deleteCharAt(stack.length() - 1);
            k--;
        }
        
        // Strip leading zeros
        int startIndex = 0;
        while (startIndex < stack.length() && stack.charAt(startIndex) == '0') {
            startIndex++;
        }
        
        // If we stripped all characters (e.g., result was "000"), return "0"
        if (startIndex == stack.length()) {
            return "0";
        }
        
        return stack.substring(startIndex);
    }
}

/*
# Monotonic Stack Method
Learning:
-> The core objective of the Remove K Digits problem is to find the smallest possible integer by removing exactly 'k' digits from a given string representation of a number.
-> Because the most significant digits (the ones on the left) have the highest impact on the overall value, we use a greedy approach combined with a Monotonic Stack to evaluate digits from left to right.
-> As we iterate through the number, the stack acts as a container for the digits we intend to keep, aiming to maintain a monotonically increasing order from bottom to top.
-> When we encounter a new digit that is strictly smaller than the digit currently sitting at the top of our stack, we pop the top digit and decrease our 'k' removal count by 1. This is because replacing a larger left-most digit with a smaller one guarantees a smaller overall number.
-> We repeat this popping process continuously as long as the stack is not empty, we still have removals left to make, and the current digit remains smaller than the stack's top digit.
-> Once the stack is safe (or 'k' reaches 0), we push the current digit onto the stack and move on to the next character in the original string.
-> If we finish processing all digits and 'k' is still greater than 0 (which happens if the original number's digits were already in increasing order, like "1234"), we simply delete the largest digits by popping the remaining 'k' elements from the very end of the stack.
-> After all necessary digits are removed, we must strip any leading zeros from the remaining sequence to ensure the final answer is a valid integer representation.
-> As an example, with num = "1432219" and k = 3, we push 1, then push 4. When we reach 3, we pop 4 (k=2) and push 3. When we reach 2, we pop 3 (k=1) and push 2. We push the next 2. When we reach 1, we pop the top 2 (k=0) and push 1. The 9 is kept, leaving us with a final sequence of "1219".
-> Finally, if removing digits and stripping leading zeros leaves our stack completely empty (for example, num = "10" and k = 1), the problem strictly dictates that we must return "0" as the default answer.

Summary:
Time Complexity = O(n)
Space Complexity = O(n)
*/