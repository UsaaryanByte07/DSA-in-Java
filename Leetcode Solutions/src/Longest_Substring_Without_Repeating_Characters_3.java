public class Longest_Substring_Without_Repeating_Characters_3 {
    public static void main(String[] args) {
        
    }

    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int rear = 0;
        int front = 0;
        int maxLen = 0;
        boolean[] seen = new boolean[256];
        while(front < s.length()){
            char currentChar = s.charAt(front);

            while(seen[currentChar]){
                seen[s.charAt(rear)] = false;
                rear++;
            }

            seen[currentChar] = true;

            maxLen = Math.max(maxLen, front - rear + 1);
            front++;
        }
        return maxLen;
    }
}

/*
Summary
Time Complexity = O(n)
Space Complexity = O(1)
*/