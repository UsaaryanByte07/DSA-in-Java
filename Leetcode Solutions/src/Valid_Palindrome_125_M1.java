public class Valid_Palindrome_125_M1 {
    public static void main(String[] args) {
        
    }

    public boolean isPalindrome(String s) {
        String str = "";
        for (int i = 0; i < s.length(); i++) {
            if ((s.charAt(i) >= 48 && s.charAt(i) <= 57) || (s.charAt(i) >= 65 && s.charAt(i) <= 90)
                    || (s.charAt(i) >= 97 && s.charAt(i) <= 122)) {
                        str += s.charAt(i);
            }
        }
        str = str.toLowerCase();
        boolean isPalindrome = true;
        for (int i = 0; i < (str.length()/2); i++) {
            if(str.charAt(i) != str.charAt(str.length() - i - 1)){
                isPalindrome = false;
                break;
            }
        }
        return isPalindrome;
    }
}

/*
#Filter and Check Method
Learning:
1) Misevaluated the Time Complexity as O(n), but the actual Time Complexity of this Code is O(n^2).
Explanationn:
In Java, String objects are immutable, meaning they cannot be changed once created. When you use += to append a character, Java does not just add it to the end. Instead, it creates an entirely new string in the computer's memory, copies the old string over, and adds the new character.If your input string has 100,000 characters, the first iteration copies 1 character, the second copies 2, the third copies 3... resulting in 1 + 2 + 3 + ... + n operations. This is the classic arithmetic progression formula, which results in an O(n^2) Time Complexity.
2) Semi-Two Pointer Approach Flaw.
Explanation:
My Approach: Semi-Two Pointer (Clean & Compare)
I successfully derived the Two-Pointer logic on my own to compare the front and back characters! However, I only went "halfway" by allocating O(n) extra space to build a cleaned-up string first.
How to Optimize:
To achieve the gold-standard O(1) space complexity, I need to use the In-Place Two Pointers pattern. Instead of building a new string, I must place the pointers directly on the raw input string and dynamically skip over non-alphanumeric characters. Will revisit after completing 2.1.9 Two Pointers!

Summary:
Time Complexity = O(n^2)
Space Complexity = O(n)
*/