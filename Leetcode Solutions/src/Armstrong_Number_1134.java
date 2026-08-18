public class Armstrong_Number_1134 {
    /*
    Problem Statement: Given an integer N, return true it is an Armstrong number otherwise return false.
    An Amrstrong number is a number that is equal to the sum of its own digits each raised to the power of the number of digits.

    Examples:
    Example 1:
    Input:N = 153
    Output:True
    Explanation: 1^3+5^3+3^3 = 1 + 125 + 27 = 153
                                        
    Example 2:
    Input:N = 371                
    Output: True
    Explanation: 3^3+7^3+1^3 = 27 + 343 + 1 = 371

    Constraints:
    -> N will be positive integer and non - zero
    */
    public static void main(String[] args) {
        int num1 = 121;
        int num2 = 153;
        int num3 = 371;
        System.out.println(isArmstrong(num1));
        System.out.println(isArmstrong(num2));
        System.out.println(isArmstrong(num3));
    }

    public static boolean isArmstrong(int num){
        int numOfDigits = (int) Math.log10(num) + 1;

        int sum = 0;
        int temp = num;
        while(temp != 0){
            int digit = temp%10;
            sum += Math.pow(digit, numOfDigits);
            temp /= 10;
        }
        
        if(sum == num) return true;
        else return false;
    }
}


/*
Summary:
Time Complexity = O(log10(n))
Space Complexity = O(1)
*/