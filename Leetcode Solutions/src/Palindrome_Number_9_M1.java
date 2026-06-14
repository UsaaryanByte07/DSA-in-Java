public class Palindrome_Number_9_M1 {
    public static void main(String[] args) {
        
    }
    public boolean isPalindrome(int x) {
        String numStr = Integer.toString(x);
        int left = 0;
        int right = numStr.length() - 1;
        while(left < right){
            if(numStr.charAt(left) != numStr.charAt(right)){
                return false;
            }else{
                left++;
                right--;
            }
        }
        return true;
    }
}
/*
#Integer to String Method
Learning:
1) Misevaluated the Time and Space Complexity as O(n):
In computer science, when evaluating algorithms that operate on integers, n is typically reserved for the value of the integer itself, not its length. The number of digits in an integer x is mathematically expressed as approx log_{10}(x). Therefore, a stricter academic notation for your complexities would be Time: O(log x) and Space: O(log x). However, in the context of strings and arrays, saying O(n) where n is the string length is universally accepted.
Summary:
Time Complexity = O(log base 10 ( n ))
Space Complexity = O(log base 10 ( n ))
*/