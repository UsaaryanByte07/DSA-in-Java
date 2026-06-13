public class Reverse_String_344_M2 {
    public static void main(String[] args) {
        
    }
    public void reverseString(char[] s) {
        int left = 0;
        int right = s.length - 1;
        
        while (left < right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            
            left++;
            right--;
        }
    }
}
/*
#Explicit Two-Pointer Method
Learning:
Based on Two Pointer Approach
Summary:
Time Complexity = O(n)
Space Complexity = O(1)
*/
