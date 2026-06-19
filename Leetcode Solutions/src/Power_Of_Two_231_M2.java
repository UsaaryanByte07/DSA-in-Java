public class Power_Of_Two_231_M2 {
    public static void main(String[] args) {
        
    }

    public boolean isPowerOfTwo(int n) {
        if(n <= 0) return false;

        while(n%2 == 0) n/= 2;

        return n == 1;
    }
}


/*
#Optimized Iterative Approach
Summary:
Time Complexity = O(logn) (Bacause the loop will run logn times) 
Space Complexity = O(1)
*/