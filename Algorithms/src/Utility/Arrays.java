package Utility;
import java.util.Scanner;

public class Arrays {
    public static void swap(int[] arr, int idx1, int idx2){
        int temp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = temp;
    }

    public static int[] read(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the Size of the Array: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the Elements of the Array:");
        for (int idx = 0; idx < arr.length; idx++) {
            arr[idx] = sc.nextInt();
        }
        sc.close();
        return arr;
    }
}
