public class Count_Digits_In_A_Number_1_M1 {
    /*
    Problem Statement: Given an integer N, return the number of digits in N.

    Examples:
    Example 1:
    Input:N = 12345
    Output:5
    Explanation:  The number 12345 has 5 digits.
                            
    Example 2:
    Input:N = 7789              
    Output: 4
    Explanation: The number 7789 has 4 digits. 
    */
    public static void main(String[] args) {
        
    }

    public static int countDigits(int num){
        if (num == 0) return 1;
        int count = 0;
        while(num != 0) {
            count++;
            num /= 10;
        }
        return count;
    }

    /*
    Summary:
    Time Complexity = O(log10(n))
    Space Complexity = O(1)
    */
}
