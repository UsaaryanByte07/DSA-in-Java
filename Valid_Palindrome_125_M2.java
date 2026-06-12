public class Valid_Palindrome_125_M2 {
    public static void main(String[] args) {
        
    }
    public boolean isPalindrome(String s) {
        int right = s.length() - 1;
        int left = 0;
        while (left < right) {
            if (!((s.charAt(left) >= 48 && s.charAt(left) <= 57) || (s.charAt(left) >= 65 && s.charAt(left) <= 90)
                    || (s.charAt(left) >= 97 && s.charAt(left) <= 122))) {
                        left++;
            }
            else if (!((s.charAt(right) >= 48 && s.charAt(right) <= 57) || (s.charAt(right) >= 65 && s.charAt(right) <= 90)
                    || (s.charAt(right) >= 97 && s.charAt(right) <= 122))) {
                        right--;
            }
            else{
                if(Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))){
                    return false;
                }
                right--;
                left++;
            }

        }
        return true;
    }
}

/*
#In-Place Two Pointers Method
Summary:
Time Complexity: O(n)
Space Complexity: O(1)
*/