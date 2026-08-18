public class Find_the_Index_Of_the_First_Occurence_in_a_String_28 {
    public static void main(String[] args) {
        
    }

    public int strStr(String haystack, String needle) {
        for(int i = 0;i < haystack.length(); i++){
            int j = 0;
            int temp = i;
            while(temp < haystack.length() && haystack.charAt(temp) == needle.charAt(j)){
                if(j == needle.length() - 1) return i;
                temp++;
                j++;
            }
        }
        return -1;
    }
}

/*
Summary:
Time Complexity = O(n)
Space Complexity = O(1)
*/