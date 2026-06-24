public class Valid_Parentheses_20 {
    public static void main(String[] args) {
        
    }

    public boolean isValid(String s) {
        int size = s.length();
        char[]  stack = new char[size];
        int i = 0;
        int top = -1;
        while(i < size){
            if(s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '['){
                stack[++top] = s.charAt(i);
            }else{
                if(top == -1) return false;
                if((s.charAt(i) == ')' && stack[top] == '(') || (s.charAt(i) == '}' && stack[top] == '{') || (s.charAt(i) == ']' && stack[top] == '[')){
                    top--;
                }else{
                    return false;
                }
            }
            i++;
        }
        if(top == -1) return true;
        else return false;
    }
}

/*
Summary:
Time Complexity = O(n)
Space Complexity = O(n)
*/