import java.util.Stack;

public class Basic_Calculator_224 {
    public static void main(String[] args) {
        
    }

    public int calculate(String s) {
      Stack<Integer> stack = new Stack<>();
        int result = 0;
        int number = 0;
        int sign = 1; // 1 represents '+', -1 represents '-'

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                // Build the multi-digit number
                number = number * 10 + (c - '0');
            } else if (c == '+') {
                // Evaluate the left side and reset number/sign
                result += sign * number;
                number = 0;
                sign = 1;
            } else if (c == '-') {
                // Evaluate the left side and reset number/sign
                result += sign * number;
                number = 0;
                sign = -1;
            } else if (c == '(') {
                // Push current result and sign onto stack to calculate expression inside ()
                stack.push(result);
                stack.push(sign);
                
                // Reset result and sign for the new sub-expression
                sign = 1;
                result = 0;
            } else if (c == ')') {
                // Finish the sub-expression calculation
                result += sign * number;
                number = 0;
                
                // Multiply by the sign before the parenthesis
                result *= stack.pop();
                
                // Add the result from before the parenthesis
                result += stack.pop();
            }
        }
        
        // Add any remaining number to the result
        if (number != 0) {
            result += sign * number;
        }
        
        return result;
    }
}

/*
Summary:
Time Complexity = O(n)
Space Complexity = O(n)
*/