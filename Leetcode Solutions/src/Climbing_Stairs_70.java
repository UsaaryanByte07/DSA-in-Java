public class Climbing_Stairs_70 {
    public static void main(String[] args) {
        
    }

    public int climbStairs(int n) {
        if( n<= 2) return n;
        int[] ways = new int[n+ 1];
        return helper(n, ways);
    }

    public static int helper(int n, int[] ways){
        if(n <= 2) return n;
        
        if(ways[n] != 0) return ways[n];

        ways[n] = helper(n-1, ways) + helper(n-2, ways);
        return ways[n];
    }
}

/* 
#Dyanamic Programming Approach:

Summary:
Time Complexity = O(n)
Space Complexity = O(n)
*/
