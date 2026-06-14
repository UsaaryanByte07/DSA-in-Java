public class Add_Digits_258 {
    public static void main(String[] args) {
        
    }
    public int addDigits(int num) {
        if(num == 0){
            return 0;
        }
        if(num%9 == 0){
            return 9;
        }
        return num%9;
    }
}

/*
#Magic Maths for finding Digital Roots
Learning:
Didn't Knew About digital Root and Maths Shortcut to find it. (Refer Ref #3)
Summary:
Time Complexity = O(1)
Space Complexity = O(1)
*/