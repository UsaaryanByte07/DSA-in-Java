public class Check_If_Array_Is_Sorted_And_Rotated_1752_M1 {
    public static void main(String[] args) {
        
    }

    public boolean check(int[] nums) {
        int drops = 0;
        for(int i = 0; i < nums.length - 1; i++){
            if(nums[i] > nums[i+1]){
                if(drops == 0) drops++;
                else return false;
            }
        }
        if(drops == 1 && nums[nums.length - 1] > nums[0]) return false;
        return true;
    }
}

/*
# Not So Clean Solution
Summary:
Time Complexity = O(n)
Space Complexity = O(1)
*/