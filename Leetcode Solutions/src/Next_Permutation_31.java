public class Next_Permutation_31 {
    public static void main(String[] args) {
        
    }
    public void nextPermutation(int[] nums) {
        int pivot = -1;
        for(int i = nums.length - 2; i >= 0; i--){
            if(nums[i] < nums[i+1]){
                pivot = i;
                break;
            }
        }
        if(pivot == -1){
            reverse(nums, 0, nums.length - 1);
            return;
        }
        int replacer = -1;

        for(int i = nums.length - 1; i > pivot; i--){
            if(nums[i] > nums[pivot]){
                replacer = i;
                break;
            }
        }

        int temp = nums[pivot];
        nums[pivot] = nums[replacer];
        nums[replacer] = temp;

        reverse(nums, pivot + 1, nums.length - 1);
    }

    public static void reverse(int[] array, int start, int end) {
        while (start < end) {
            int temp = array[start];
            array[start] = array[end];
            array[end] = temp;
            start++;
            end--;
        }
    }
}

/*
Learning:
1) What the Question Says ?
-> if you have the digits 1, 2, and 3, a permutation is just one specific way to arrange them. If we write out all possible combinations and sort them from lowest to highest.
-> The question gives you one of these arrangements and asks you to find the one immediately below it on that sorted list. You are finding the smallest possible arrangement that is strictly larger than the current one.
2) Algorithm:
-> Find the first index from the right where the order is increasing (nums[i] < nums[i+1]). This index is called the pivot.
-> Find the smallest element greater than the pivot element on its right side.
-> Swap the pivot and that element.
-> Reverse the suffix after the pivot to make it as small as possible.
-> If no pivot exists, the array is in descending order, so we simply reverse the entire array to get the smallest permutation.

Summary:
Time Complexity = O(n)
Space Complexity = O(1)

*/