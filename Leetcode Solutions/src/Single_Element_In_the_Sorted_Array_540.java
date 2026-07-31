public class Single_Element_In_the_Sorted_Array_540 {
    public static void main(String[] args) {
        
    }

    public int singleNonDuplicate(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        int result = 0;
        while(high >= low){
            int mid = low + (high - low)/2;
            if(mid > 0 && nums[mid] == nums[mid - 1]){
                if((mid - low + 1)%2 == 0){
                    low = mid + 1;
                }else{
                    high = mid - 2;
                }
            }else if(mid < nums.length - 1 && nums[mid] == nums[mid + 1]){
                if((high - mid + 1)%2 == 0){
                    high = mid - 1;
                }else{
                    low = mid + 2;
                }
            }else{
                result = nums[mid];
                break;
            }
        }
        return result;
    }
}

/* 
Learning:
-> The core idea is to divide the array into a left and right partition around the midpoint and count the number of elements in those partitions
-> Because the array is made of duplicate pairs and exactly one single element any valid partition containing the single element must mathematically have an odd number of total elements
-> The loop starts with pointers at the beginning and end of the array to continually shrink the search space
-> The midpoint is calculated and we first check if the element matches its left neighbor
-> If it matches the left neighbor we consider the left partition from the low pointer up to and including the midpoint
-> If this left partition has an even number of elements the single element cannot be in it so we search the right side by moving low past the midpoint
-> If the left partition has an odd number of elements the single element must be hiding there so we shrink our search to the left side and jump our high pointer over the current pair
-> If the midpoint element instead matches its right neighbor we analyze the right partition from the midpoint up to the high pointer
-> If this right partition has an even number of elements the single element is not there so we move our high pointer to search the left side
-> If the right partition has an odd number of elements the single element is there so we move our low pointer to search the right side while skipping the current pair
-> The boundary checks strictly ensure we never try to compare the midpoint with an index that is outside the array bounds
-> If the midpoint matches neither its left nor right neighbor or if it safely lands on an extreme boundary we have successfully found our single non duplicate element and the loop breaks out to return the result

Summary:
Time Complexity = O(logn)
Space Complexity = O(1)
*/