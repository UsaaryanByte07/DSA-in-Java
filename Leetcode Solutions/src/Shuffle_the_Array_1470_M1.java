public class Shuffle_the_Array_1470_M1 {
    public static void main(String[] args) {
        
    }

    public int[] shuffle(int[] nums, int n) {
        int res[] = new int[nums.length];
        int i = 0;
        for(int j = 0; j < n; j++){
            res[i++] = nums[j]; 
            res[i++] = nums[j + n]; 
        }
        return res;
    }
}

/*
# Space Consuming Method
Summary:
Time Complexity = O(n/2)
Space Complexity = O(n)
*/