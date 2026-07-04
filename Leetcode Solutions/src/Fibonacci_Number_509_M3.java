public class Fibonacci_Number_509_M3 {
    public static void main(String[] args) {
        
    }

    public int fib(int n) {
        if( n<= 1) return n;
        int[] m = new int[n + 1];
        return helper(n, m);
    }

    public static int helper(int n , int[] m){
        if(n <= 1) return n;

        if(m[n] != 0) return m[n];

        m[n] = helper(n - 1, m) + helper(n-2, m);
        return m[n];
    }
}

/*
# Dynamic Programming Approach:

Summary:
Time Complexity = O(n)
Space  Complexity = O(n)
*/