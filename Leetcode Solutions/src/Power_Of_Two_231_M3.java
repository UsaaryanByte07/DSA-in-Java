public class Power_Of_Two_231_M3 {
    public static void main(String[] args) {
        
    }

    public boolean isPowerOfTwo(int n) {
        if(n>0 && (n & (n - 1)) == 0) return true;
        else return false;
    }
}


/*
# Bit Manipulation Method
Learning:
The absolute best way to solve this problem is by using Bit Manipulation. This is the solution interviewers are looking for when they ask this question. 
In binary representation, every power of two has exactly one 1 bit, followed by zeros.
2 is 0010
4 is 0100
8 is 1000
If you subtract 1 from a power of two, all the bits flip.
8 - 1 = 7, which is 0111 in binary. 
If you perform a bitwise AND (&) operation between n and n-1 for a power of two, the result will always be 0.
1000 & 0111 = 0000

Summary:
Time Complexity = O(1)
Space Complexity = O(1)
*/