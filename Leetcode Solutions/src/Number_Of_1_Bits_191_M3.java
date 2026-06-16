public class Number_Of_1_Bits_191_M3 {
    public static void main(String[] args) {

    }

    public int hammingWeight(int n) {
        int numOfOnes = 0;
        while (n != 0) {
            n &= (n - 1);
            numOfOnes++;
        }
        return numOfOnes;
    }
}

/*
 * # Brian Kernighan’s Algorithm
 * Learning:
 * The Trick: When you subtract 1 from a number n, all the bits from the
 * rightmost 1 to the end are flipped. If you then do a bitwise AND between n
 * and n - 1 (n & (n - 1)), it completely erases the rightmost 1.
 * Summary:
 * Time Complexity = O(k), where k is the number of 1 bits in the integer. If a
 * number only has two 1s, the loop only runs 2 times instead of 32 times. This
 * is as fast as theoretically possible.
 * Space Complexity = O(1)
 */