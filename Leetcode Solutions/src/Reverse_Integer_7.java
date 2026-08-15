public class Reverse_Integer_7 {
    public static void main(String[] args) {
        
    }

    public int reverse(int x) {
        int revX = 0;
        while(x != 0){
            int digit = x%10;
            if ((revX > Integer.MAX_VALUE / 10) || (revX < Integer.MIN_VALUE / 10)) {
                return 0; 
            }
            revX = (revX*10) + digit;
            x /= 10;
        }
        return revX;
    }
}

/*
Summary:
Time Complexity = O(log10(n))
Space Complexity = O(1)
*/