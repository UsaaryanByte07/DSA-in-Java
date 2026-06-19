public class Fibonacci_Number_509_M1 {
    public static void main(String[] args) {

    }

    public int fib(int n) {
        if (n <= 1) {
            return n;
        }
        return fib(n - 1) + fib(n - 2);
    }
}

/*
Recursive Approach:
1) Miscalculated the Time complexity as O(n):
 -> Because the function calls both fib(n-1) and fib(n-2) without storing previously computed results (overlapping subproblems), the number of operations grows exponentially, forming a massive binary tree of redundant calculations.
Summary:
Time Complexity = O(2^n)
Space Complexity = O(1) (Due to Memory Consumed By Call Stack)
*/