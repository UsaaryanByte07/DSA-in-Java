public class Power_Of_Two_231_M4 {
    public static void main(String[] args) {

    }

    public boolean isPowerOfTwo(int n) {
        int i = 0;
        while (Math.pow(2, i) <= n) {
            if (Math.pow(2, i) == n) {
                return true;
            }
            i++;
        }
        return false;
    }
}

/*
 * #Un-Optimized Iterative Approach
 * Summary:
 * Time Complexity = O((logn)^2) (Because the loop will run logn times so power
 * will be calculated logn times and to some languages take logn time to
 * calculate power)
 * Space Complexity = O(1)
 */