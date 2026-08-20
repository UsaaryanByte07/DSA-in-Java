public class Add_Strings_415 {
    public static void main(String[] args) {
        
    }

    public String addStrings(String num1, String num2) {
        StringBuilder res = new StringBuilder();
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int carry = 0;
        while(i >= 0 && j >= 0){
            int n = toInt(num1.charAt(i));
            int m = toInt(num2.charAt(j));
            int sum = n + m + carry;
            if(sum > 9){
                res.append(sum%10);
                carry = 1;
            }else{
                res.append(sum);
                carry = 0;
            }
            j--;
            i--;
        }
        while( i >= 0){
            int n = toInt(num1.charAt(i--));
            int sum = n + carry;
            if(sum > 9){
                res.append(sum%10);;
                carry = 1;
            }else{
                res.append(sum);
                carry = 0;
            }
        }
        while( j >= 0){
            int m = toInt(num2.charAt(j--));
            int sum = m + carry;
            if(sum > 9){
                res.append(sum%10);
                carry = 1;
            }else{
                res.append(sum);
                carry = 0;
            }
        }
        if(carry == 1) res.append(carry);
        return res.reverse().toString();
    }

    public static int toInt(char ch) {
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
        }
        return -1;
    }
}

/*
Summary:
Time Complexity = O(n)
Space Complexity = O(n) (Including the result String)
*/