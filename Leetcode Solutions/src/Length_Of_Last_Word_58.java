public class Length_Of_Last_Word_58 {
    public static void main(String[] args) {
        
    }

    public int lengthOfLastWord(String s) {
        int count = 0;
        for(int i = s.length() - 1; i >= 0; i--){
            if(s.charAt(i) != ' ') count++;
            else if (count > 0) break;
        }
        return count;
    }
}

/*
Summary:
Time Complexity = O(n)
Space Complexity = O(1)
*/