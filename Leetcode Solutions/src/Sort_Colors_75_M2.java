public class Sort_Colors_75_M2 {
    public static void main(String[] args) {
        
    }

    public void sortColors(int[] nums) {
        int low = 0;
        int mid = 0;
        int high = nums.length - 1;
        while( mid <= high){
            if(nums[mid] == 0){
                int temp = nums[low];
                nums[low] = nums[mid];
                nums[mid] = temp;
                low++;
                mid++;
            }else if(nums[mid] == 1){
                mid++;
            }else{
                int temp = nums[high];
                nums[high] = nums[mid];
                nums[mid] = temp;
                high--;
            }
        }
    }
}

/*
# 1 - Pass  Method / Three - Pointer Method

Summary:
Time Complexity = O(n)
Space Complexity = O(1)
*/