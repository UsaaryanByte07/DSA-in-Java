public class Remove_Element_27 {
    public static void main(String[] args) {
        
    }

    public int removeElement(int[] nums, int val) {
        int i = 0;
        for(int num : nums){
            if(num != val){
                nums[i] = num;
                i++;
            }
        }
        return i;
    }
}

/*
Summary:
Time Complexity = O(n)
Space Complexity = O(1)
*/