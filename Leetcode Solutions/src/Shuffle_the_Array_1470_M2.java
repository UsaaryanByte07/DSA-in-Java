public class Shuffle_the_Array_1470_M2 {
    public static void main(String[] args) {
        
    }

    public int[] shuffle(int[] nums, int n) {
        int j = 0;
        int k = n;
        for (int i = 0; i < 2 * n; i++) {
            if (i % 2 == 0) {
                nums[i] = 10000 * (nums[j++] % 10000) + nums[i];
            } else {
                nums[i] = 10000 * (nums[k++] % 10000) + nums[i];
            }
        }
         for (int i = 0; i < 2 * n; i++) {
            nums[i] /= 10000;
        }
        return nums;
    }
}

/*
# Space Efficient Solution
Summary:
Time Complexity = O(n)
Space Complexity = O(1)
*/