public class Concatenation_Of_Array_1929 {
    public static void main(String[] args) {
        
    }

    public int[] getConcatenation(int[] nums) {
        int[] res = new int[nums.length*2];
        int i = 0;
        for(; i < nums.length; i++){
            res[i] = nums[i];
            res[i + nums.length] = nums[i];
        }
        return res;
    }
}

/*
Summary:
Time Complexity = O(n/2)
Space Complexity = O(1)  (Excluding the result Array)
*/