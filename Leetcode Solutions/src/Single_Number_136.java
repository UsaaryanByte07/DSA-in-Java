public class Single_Number_136 {
    public static void main(String[] args) {

    }

    public int singleNumber(int[] nums) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            result ^= nums[i];
        }
        return result;
    }
}

/*
Summary:
Time Complexity = O(n)
Space Complexity = O(1)
*/