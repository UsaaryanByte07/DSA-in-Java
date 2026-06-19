public class Power_Of_Two_231_M1 {
    public static void main(String[] args) {
        
    }

    public boolean isPowerOfTwo(int n) {
        if(n <= 0) return false;
        if(n == 1) return true;
        if(n%2 != 0) return false;

        return isPowerOfTwo(n/2);
    }
}

/*
#Recursive Approach:
Summary:
Time Complexity = O(logn)
Space Complexity = O(logn) (due to the recursive call stack)
*/
