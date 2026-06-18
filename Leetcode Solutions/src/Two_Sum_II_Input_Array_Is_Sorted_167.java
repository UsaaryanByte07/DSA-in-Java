public class Two_Sum_II_Input_Array_Is_Sorted_167 {
    public static void main(String[] args) {
        
    }

    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        while(left < right){
            if((numbers[left] + numbers[right]) == target){
                return new int[]{left + 1, right + 1}; //One Indexed Array
            }else if((numbers[left] + numbers[right]) > target){
                right--;
            }else{
                left++;
            }
        }
        return null;
    }
}

/*
Summary:
Time Complexity = O(n)
Space Complexity = O(1)
*/
