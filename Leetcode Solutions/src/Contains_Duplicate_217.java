import java.util.HashSet;

public class Contains_Duplicate_217 {
    public static void main(String[] args) {
        
    }
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> map = new HashSet<>();
        for(int i = 0; i < nums.length ; i++){
            // HashSet.add() returns false if the element is already in the set
            if(!map.add(nums[i])){
                return true;
            }
        }
        return false;
    }
}

/*
Learning:
Don't Try to Make a Hash Map from scratch as handling all collision cases is very complex and interview has very less time. So it is recommended to use HashSet from Scratch until and un-else asked.

Summary:
Time Complexity = O(n)
Space Complexity = O(n)
*/