public class Reverse_Words_In_The_String_151 {
    public static void main(String[] args) {
        
    }

    public String reverseWords(String s) {
        StringBuilder result = new StringBuilder();
        int st = s.length() - 1;
        while(st >= 0){
            if(s.charAt(st) == ' '){
                st--;
                continue;
            }
            int end = st + 1;
            while(st >= 0 && s.charAt(st) != ' '){
                st--;
            }

            if(result.length() > 0){
                result.append(" ");
            }
            result.append(s.substring(st+1, end));
        }
        return result.toString();
    }
}

/* 
# Two Pointer Method
Summary:
Time Complexity = O(n)
Space Complexity = O(1)
*/