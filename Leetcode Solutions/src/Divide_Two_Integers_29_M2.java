public class Divide_Two_Integers_29_M2 {
    public static void main(String[] args) {
        
    }

    public int divide(int dividend, int divisor) {
        // Handle the only actual overflow edge case
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        // Determine the sign using bitwise XOR
        int sign = (dividend > 0) ^ (divisor > 0) ? -1 : 1;

        // Convert both to negative to avoid Integer.MIN_VALUE overflow
        dividend = dividend > 0 ? -dividend : dividend;
        divisor = divisor > 0 ? -divisor : divisor;

        int ans = 0;

        // Since both are negative, the logic flips: we check if dividend <= divisor
        while (dividend <= divisor) {
            int tempDivisor = divisor;
            int count = 1;

            // Double the divisor until it would exceed the dividend.
            // We must also prevent tempDivisor from overflowing when shifted.
            while (tempDivisor >= (Integer.MIN_VALUE >> 1) && dividend <= (tempDivisor << 1)) {
                tempDivisor <<= 1; // Multiply by 2
                count <<= 1; // Multiply count by 2
            }

            // Subtract the massive chunk and add the counted multiples
            dividend -= tempDivisor;
            ans += count;
        }
        // Don't use "ans*sign" here as Leetcod will reject the solution due to "*"
        return sign == 1 ? ans : -ans;
    }
}

/*
# Bit Manipulation Method:
Learning:
-> The optimal solution achieves division without multiplication, division, or modulo operators by utilizing bitwise left-shift operations to perform exponential subtraction.
-> Instead of subtracting the divisor one by one, we use the left-shift operator (`<<`), which effectively multiplies a number by 2 for every single shift.
-> During each pass, we continuously double the divisor (and a corresponding multiplier count) until the next doubling would make it larger than our remaining dividend.
-> Once we find this maximum possible chunk, we subtract it entirely from the dividend in one go, and add the corresponding multiplier count to our final answer.
-> We then repeat this process with the newly reduced dividend, continually finding smaller power-of-two chunks until the remaining dividend is smaller than the base divisor.
-> This algorithm must operate entirely within the negative domain, meaning both the dividend and the divisor are converted to strictly negative numbers before the loop begins to safely avoid integer overflow.
-> Using the negative domain is crucial because the 32-bit signed integer limit extends down to -2147483648 but only goes up to positive 2147483647; attempting to double a massive positive number towards the limit will overflow, whereas operating in the negative space perfectly contains the absolute minimum value without crashing.
-> This exponential subtraction method completely avoids the Time Limit Exceeded (TLE) error because it mathematically reduces the time complexity from O(N) to O(log N).
-> Even in the absolute worst-case scenario—dividing the maximum possible 32-bit integer by 1—this bit-shifting approach leaps through the calculation in powers of two, finding the final quotient in a maximum of 31 operations instead of processing over 2 billion individual linear subtractions.

Summary:
Time Complexity = O(logn)
Space Complexity = O(1)
*/