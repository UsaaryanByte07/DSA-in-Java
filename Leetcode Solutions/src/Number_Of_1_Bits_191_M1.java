public class Number_Of_1_Bits_191_M1 {
    public static void main(String[] args) {

    }

    public int hammingWeight(int n) {
        int numOfOnes = 0;
        while (n != 0) {
            numOfOnes += n % 2;
            n = n >> 1;
        }
        return numOfOnes;
    }
}
/*
 * # Not So Robust Method
 * Learning:
 * fails For Negative Numbers:
 * 1. The Arithmetic Shift (>>) vs. Logical Shift (>>>)
 * In Java, the >> operator is an arithmetic right shift. This means it
 * preserves the sign bit (the leftmost bit).
 * ->If n s positive, it pads the left side with 0s.
 * ->If n is negative, it pads the left side with 1s to keep the number
 * negative.
 * ->The Bug: If you pass a negative number, the left side keeps filling with
 * 1s. The number will eventually become -1 (which is represented as all 1s in
 * binary). Because -1 >> 1 is still -1, your while(n != 0) condition will never
 * be met, causing a Time Limit Exceeded (infinite loop) error.
 * 2. The Modulo Operator (%) on Negative Numbers
 * In Java, if n is negative, n % 2 yields -1, not 1. This means you would end
 * up subtracting from numOfOnes instead of adding to it.
 * 
 * Summary:
 * Time Complexity = O(1) (Technically O(32) since an integer is always 32 bits,
 * meaning the loop runs exactly 32 times in the worst case)
 * Space Complexity = O(1)
 */