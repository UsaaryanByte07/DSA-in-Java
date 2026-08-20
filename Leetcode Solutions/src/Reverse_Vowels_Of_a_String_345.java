public class Reverse_Vowels_Of_a_String_345 {
    public static void main(String[] args) {
        
    }

    public String reverseVowels(String s) {
        int left = 0;
        int right = s.length() - 1;
        StringBuilder res = new StringBuilder(s);
        while (right > left) {
            while (right > left && !isVowel(res.charAt(left))) left++;
            while (right > left && !isVowel(res.charAt(right))) right--;
            char temp = res.charAt(left);
            res.setCharAt(left, res.charAt(right));
            res.setCharAt(right, temp);
            left++;
            right--;
        }
        return res.toString();
    }

    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' ||
                c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
    }
}

/*
Summary:
Time Complexity = O(n)
Space Complexity = O(n) (Including the Result String)
*/