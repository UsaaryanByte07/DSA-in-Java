public class Sort_Colors_75_M1 {
    public static void main(String[] args) {
        
    }

    public void sortColors(int[] nums) {
        int countR = 0;
        int countW = 0;
        int countB = 0;
        for(int num : nums){
            if(num == 0) countR++;
            else if(num == 1) countW++;
            else countB++;
        }
        int i;
        for(i = 0; i < countR; i++){
            nums[i] = 0;
        }
        for(; i < countR + countW; i++){
            nums[i] = 1;
        }
        for(; i < countR + countW + countB; i++){
            nums[i] = 2;
        }
    }
}

/*
# 2 - Pass Solution

Summary:
Time Complexity = O(n)
Space Complexity = O(1)
*/