public class Build_Array_From_Permutation_1920_M1 {
    public static void main(String[] args){
            
    }

    public int[] buildArray(int[] nums) {
        int[] ans = new int[nums.length];
        for(int i = 0; i < nums.length ; i++){
            ans[i] = nums[nums[i]];
        }
        return ans;
    }
}

/*
#Creating New Array Method
Summary:
Time Complexity = O(n)
Space Complexity = O(n)
*/