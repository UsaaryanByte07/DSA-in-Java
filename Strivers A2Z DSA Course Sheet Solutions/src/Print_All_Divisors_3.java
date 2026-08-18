import java.util.ArrayList;
import java.util.List;

public class Print_All_Divisors_3 {
    /*
     * Problem Statement: Given an integer N, return all divisors of N.
     * A divisor of an integer N is a positive integer that divides N without
     * leaving a remainder. In other words, if N is divisible by another integer
     * without any remainder, then that integer is considered a divisor of N.
     * 
     * Examples:
     * Example 1:
     * Input: N = 36
     * Output: [1, 2, 3, 4, 6, 9, 12, 18, 36]
     * Explanation: The divisors of 36 are 1, 2, 3, 4, 6, 9, 12, 18, 36.
     * 
     * Example 1:
     * Input: N = 12
     * Output: [1, 2, 3, 4, 6, 12]
     * Explanation: The divisors of 12 are 1, 2, 3, 4, 6, 12.
     */

    public static List<Integer> getDivisors(int n) {
        List<Integer> divisors = new ArrayList<>();
        for (int i = 1; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                divisors.add(i);
                if (i != n / i) {
                    divisors.add(n / i);
                }
            }
        }
        return divisors;
    }
}

/*
 * Summary:
 * Time Complexity = O(sqrt(n))
 * Space Complexity = O(sqrt(n))
 */