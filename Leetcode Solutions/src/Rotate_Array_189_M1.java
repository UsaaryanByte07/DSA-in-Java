public class Rotate_Array_189_M1 {
    public static void main(String[] args) {
        
    }

    public void rotate(int[] nums, int k) {
        int n = nums.length;
        for (int j = 0; j < k; j++) {
            int next = nums[0];
            for (int i = 1; i <= n; i++) {
                int temp = nums[i % n];
                nums[i % n] = next;
                next = temp;
            }
        }
    }
}

/*
# Brute Force
Summary:
Time Complexity = O(n^2)
Space Complexity = O(1)
*/