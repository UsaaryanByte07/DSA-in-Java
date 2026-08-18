public class Longest_Common_Prefix_14 {
    public static void main(String[] args) {
        
    }

    public String longestCommonPrefix(String[] strs) {
        for (int i = 0; i < strs[0].length(); i++) {
            for (int j = 1; j < strs.length; j++) {
                if (i >= strs[j].length() || strs[0].charAt(i) != strs[j].charAt(i)) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }
}

/*
Summary:
Time Complexity = O(S) (S is the Sum of all the characters in all the strings)
Space Complexity = O(1)
*/