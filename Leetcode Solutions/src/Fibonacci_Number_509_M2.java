public class Fibonacci_Number_509_M2 {
    public static void main(String[] args) {

    }

    public int fib(int n) {
        if (n <= 1) {
            return n;
        }
        int firstTerm = 0;
        int secondTerm = 1;
        int i = 2;
        while (i <= n) {
            int temp = firstTerm + secondTerm;
            firstTerm = secondTerm;
            secondTerm = temp;
            i++;
        }
        return secondTerm;
    }
}

/*
 * Iterative Approach:
 * Summary:
 * Time Complexity = O(n)
 * Space Complexity = O(1)
 */