public class String_To_Integer_atoi_8 {
    public static void main(String[] args) {
        
    }

    public int myAtoi(String s) {
        if (s.length() == 0)
            return 0;

        int i = 0;
        int result = 0;
        int sign = 1;

        // FIX: Added i < s.length() to prevent crashing on all-space strings
        while (i < s.length() && s.charAt(i) == ' ') {
            i++;
        }

        // Check if we reached the end of the string just from spaces
        if (i == s.length())
            return 0;

        // The i < s.length() check is not strictly needed here because of the above check, 
        // but it's good practice.
        if (s.charAt(i) == '+') {
            sign = 1;
            i++;
        } else if (s.charAt(i) == '-') {
            sign = -1;
            i++;
        }

        // FIX: Added i < s.length() to prevent crashing on strings that end with zeros
        while (i < s.length() && s.charAt(i) == '0') {
            i++;
        }

        while (i < s.length()) {
            int currDigit = getDigit(s.charAt(i++));
            if (currDigit == -1)
                break;

            if (result > Integer.MAX_VALUE / 10 ||
                    (result == Integer.MAX_VALUE / 10 && currDigit > Integer.MAX_VALUE % 10)) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            result *= 10;
            result += currDigit;
        }

        return result * sign;
    }

    public static int getDigit(char ch) {
        switch (ch) {
            case '0':
                return 0;
            case '1':
                return 1;
            case '2':
                return 2;
            case '3':
                return 3;
            case '4':
                return 4;
            case '5':
                return 5;
            case '6':
                return 6;
            case '7':
                return 7;
            case '8':
                return 8;
            case '9':
                return 9;
            default:
                return -1;
        }
    }
}

/*
# Summary:
Time Complexity = O(n)
Space Complexity = O(1)
*/