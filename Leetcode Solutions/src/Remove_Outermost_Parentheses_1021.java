public class Remove_Outermost_Parentheses_1021 {
    public static void main(String[] args) {
        
    }

    public String removeOuterParentheses(String s) {
        int count = 1;
        StringBuilder result = new StringBuilder();
        for(int i = 1; i < s.length(); i++){
            if(count > 1) result.append(s.charAt(i));
            else if(count == 1 && s.charAt(i) != ')') result.append(s.charAt(i));

            if(s.charAt(i) == '(') count++;
            else count--;

        }
        return result.toString();
    }
}

/*
Summary:
Time Complexity = O(n)
Space Complexity = O(n)
*/