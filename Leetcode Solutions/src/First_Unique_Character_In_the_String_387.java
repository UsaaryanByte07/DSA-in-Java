public class First_Unique_Character_In_the_String_387 {
    public static void main(String[] args) {
        
    }

    public int firstUniqChar(String s) {
        int[] freq = new int[26];
        for(int i = 0;i < s.length(); i++){
            freq[s.charAt(i) - 'a']++;
        }
        for(int i = 0;i < s.length(); i++){
            if(freq[s.charAt(i) - 'a'] == 1){
                return i;
            }
        }
        return -1;
    }
}

/*
# Frequency Array
Summary:
Time Complexity = O(n)
Space Complexity = O(1) (a constant space array with space 26)
*/