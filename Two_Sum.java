public class Two_Sum {
    public static void main(String[] args){
        
    }

    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        for(int i = 0 ; i < nums.length ; i++){
            for(int j = i + 1 ; j < nums.length ; j++){
                if(nums[i] + nums[j] == target){
                    result[0] = i;
                    result[1] = j;
                    break;
                }
            }
        }
        return result;
    }
}

/*
Learning:
Always Read the Question and the Code Space Carefully this avoids doing extra work.
Summary:
Time Complexity = O(n^2)
Space Complexity = O(1)
Note:
Solved using nested loops O(n^2). Need to revisit and optimize to O(n) after completing Module 2.1.14 (Hashing).
*/