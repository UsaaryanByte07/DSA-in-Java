public class Number_Of_1_Bits_191_M2 {
    public static void main(String[] args) {

    }

    public int hammingWeight(int n) {
        int numOfOnes = 0;
        while (n != 0) {
            numOfOnes += n & 1;
            n >>>= 1;
        }
        return numOfOnes;
    }
}

/*
# Robust Method
Summary:
Time Complexity = O(1) (Technically O(32) since an integer is always 32 bits, meaning the loop runs exactly 32 times in the worst case)
Space Complexity = O(1)
*/
