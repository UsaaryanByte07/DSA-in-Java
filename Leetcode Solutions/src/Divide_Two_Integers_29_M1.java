public class Divide_Two_Integers_29_M1 {
    public static void main(String[] args) {
        
    }

    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        int sign = 1;
        if ((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0)) {
            sign = -1;
        }
        // 1. Convert both numbers to negative to safely handle Integer.MIN_VALUE
        int n = dividend > 0 ? -dividend : dividend;
        int d = divisor > 0 ? -divisor : divisor;
        int ans = 0;

        // 2. Since both numbers are negative, the comparison flips. 
        // We keep subtracting as long as n is less than or equal to d.
        while (n <= d) {
            n = n - d;
            ans++;
        }
        return sign == 1 ? ans: -ans;
    }
}

/*
# Subtraction Method
Learning:
-> The primary goal of this division algorithm is to calculate the quotient of two integers using repeated subtraction, strictly avoiding the use of multiplication, division, and mod operators.
-> We first explicitly check for the single edge case where the result would exceed the 32-bit signed integer limit: if the dividend is `Integer.MIN_VALUE` and the divisor is `-1`, we immediately return `Integer.MAX_VALUE`.
-> We determine the final sign of our answer by checking if the original signs of the dividend and divisor differ; if exactly one of them is negative, the final quotient must be negative.
-> To avoid the Integer Overflow Bug you encountered previously, we convert both the dividend and the divisor into strictly negative numbers, rather than positive numbers.
-> he previous bug occurred because `Math.abs(Integer.MIN_VALUE)` attempts to convert -2147483648 to positive 2147483648, which overflows the 32-bit limit and wraps back around to a negative number, breaking the loop logic.
-> By forcing both numbers into the negative domain (e.g., converting 5 to -5), we ensure that `Integer.MIN_VALUE` remains safely unchanged, as every positive 32-bit integer has a valid negative counterpart, but the lowest negative integer does not have a positive counterpart.
-> Because both numbers are now negative, we adjust the `while` loop condition from checking if `n >= d` to checking if `n <= d`. For example, checking if 10 is greater than 3 is mathematically identical to checking if -10 is less than -3.
-> Inside the loop, we subtract the negative divisor from the negative dividend (`n -= d`) which effectively brings the dividend closer to zero (e.g., -10 - (-3) = -7), and we increment our answer counter by 1.
-> Once the loop finishes, we apply the predetermined sign to our answer counter and return the final quotient.
-> Despite being logically and mathematically correct, LeetCode will ultimately reject this solution with a "Time Limit Exceeded" error because subtracting one divisor at a time results in an $O(N)$ time complexity, which is far too slow when dividing `Integer.MAX_VALUE` by 1.

Summary:
Time Complexity = O(n)
Space Complexity = O(1)
*/