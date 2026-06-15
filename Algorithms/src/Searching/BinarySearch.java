package Searching;

public class BinarySearch implements SearchingAlgorithm{
    
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9,10};
        SearchingAlgorithm binarySearch = new BinarySearch();
        int result = binarySearch.search(arr, 9, 0, arr.length - 1);
        if(result == -1){
            System.out.println("Not Found");
        }else{
            System.out.println("9 Found at Array Index: " + result);
        }
    }

    @Override
    public int search(int[] arr, int target, int low, int high) {
        if(low <= high){
            int mid = low + (high - low)/2;
            if(arr[mid] == target){
                return mid;
            }else if(arr[mid] > target){
                return search(arr, target, low, mid - 1);
            }else{
                return search(arr, target, mid + 1, high);
            }
        }else{
            return -1;
        }
    }
}
