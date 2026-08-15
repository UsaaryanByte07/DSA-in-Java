package Pattern_Printing;

public class Patterns {
    public static void main(String[] args) {
        pattern1(5);
        pattern2(5);
        pattern3(5);
        pattern4(5);
        pattern5(5);
        pattern6(5);
        pattern7(5);
        pattern8(5);
        pattern9(5);
        pattern10(5);
    }

    /*
    Given an integer n. You need to recreate the pattern given below for any value of N.
    Let's say for N = 5, the pattern should look like as below:
    */

    /*
    1.
    *****
    *****
    *****
    *****
    *****
    */
    public static void pattern1(int n) {
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }

    /*
    2.
    *
    **
    ***
    ****
    *****
    */
    public static void pattern2(int n){
        for(int i = 0; i < n; i++){
            for(int j = 0; j <= i; j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }

    /*
    3.
    1
    12
    123
    1234
    12345
    */
    public static void pattern3(int n){
        for(int i = 0; i < n; i++){
            int num = 1;
            for(int j = 0; j <= i; j++){
                System.out.print(num++);
            }
            System.out.println();
        }
    }

    /*
    4.
    1
    22
    333
    4444
    55555
    */
    public static void pattern4(int n){
        int num = 1;
        for(int i = 0; i < n; i++){
            for(int j = 0; j <= i; j++){
                System.out.print(num);
            }
            num++;
            System.out.println();
        }
    }

    /*
    5.
    *****
    ****
    ***
    **
    *
    */
    public static void pattern5(int n){
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n - i; j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }

    /*
    6.
    12345
    1234
    123
    12
    1
    */
    public static void pattern6(int n){
        for(int i = 0; i < n; i++){
            int num = 1;
            for(int j = 0; j < n - i; j++){
                System.out.print(num++);
            }
            System.out.println();
        }
    }

    /*
    7.
        *
       ***
      *****
     *******
    *********
    */
    public static void pattern7(int n){
        for(int i = 0; i < n; i++){
            for(int k = 1; k < n - i; k++){
                System.out.print(" ");
            }
            for(int j = 0; j < (2*i + 1); j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }

    /*
    8.
    *********
     *******
      *****
       ***
        *
    */
    public static void pattern8(int n){
        for(int i = 0; i < n; i++){
            for(int k = 0; k < i; k++){
                System.out.print(" ");
            }
            for(int j = 0; j < (2*(n-i) - 1); j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }

    /*
    9.
        *
       ***
      *****
     *******
    *********
    *********
     *******
      *****
       ***
        *
    */
    public static void pattern9(int n){
        for(int i = 0; i < n; i++){
            for(int k = 1; k < n - i; k++){
                System.out.print(" ");
            }
            for(int j = 0; j < (2*i + 1); j++){
                System.out.print("*");
            }
            System.out.println();
        }
        for(int i = 0; i < n; i++){
            for(int k = 0; k < i; k++){
                System.out.print(" ");
            }
            for(int j = 0; j < (2*(n-i) - 1); j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }

    /*
    10.
    *
    **
    ***
    ****
    *****
    ****
    ***
    **
    *
    */
    public static void pattern10(int n){
        for(int i = 0; i < n; i++){
            for(int j = 0; j <= i; j++){
                System.out.print("*");
            }
            System.out.println();
        }
        for(int i = 0; i < n - 1; i++){
            for(int j = 0; j < (n - 1) - i; j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
