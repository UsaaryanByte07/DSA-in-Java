public class Palindrome_Number_9_M2 {
    public static void main(String[] args) {
        
    }
    public boolean isPalindrome(int x) {
        int revX = 0;
        if(x < 0 || (x % 10 == 0 && x != 0)){
            return false;
        }
        while(x > revX){
            revX = (revX*10) + (x%10);
            x /= 10;
        }
        if(revX == x || x == revX/10){
            return true;
        }else{
            return false;
        }
    }
}
/*

*/