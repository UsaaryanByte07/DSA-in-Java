import java.util.HashSet;
import java.util.Set;

public class Longest_Consecutive_Sequence_128 {
    public static void main(String[] args) {
        
    }

    public int longestConsecutive(int[] nums) {
        if(nums.length == 0) return 0;
        Set<Integer> set = new HashSet<>();
        for(int num : nums) set.add(num);
        int maxStreak = 0;
        for(int num : set){
            if(!set.contains(num - 1)){
                int currStreak = 1;
                int newNum = num;
                while(set.contains(newNum + 1)){
                    newNum++;
                    currStreak++;
                }
                maxStreak = Math.max(maxStreak, currStreak);
            }
        }
        return maxStreak;
    }
}

/*
# HashSet Method

Learning:
-> The first step checks if the input array is empty and returns zero immediately if there are no numbers to process.
-> A HashSet is created and populated with all numbers from the original array which automatically removes any duplicate values.
-> A variable called maxStreak is initialized to zero to keep a running record of the longest sequence found.
-> The code then loops through every unique number directly from the set instead of the original array which is the key change to avoid wasting time processing the same duplicate numbers multiple times.
-> For each number it checks if it acts as the starting point of a sequence by confirming that the number immediately before it is not present in the set.
-> If the previous number does exist the current number is simply ignored because it is already a middle or end piece of a different sequence.
-> When a valid starting number is identified a current streak counter begins at one.
-> A while loop continuously checks if the next consecutive number exists within the set.
-> As long as consecutive numbers keep appearing the checking number moves up by one and the current streak counter increases by one.
-> Once the consecutive chain breaks the code compares the length of this newly found sequence with the overall maxStreak and keeps the highest value.
-> After evaluating all unique numbers in the set the method returns the final maxStreak value.

Summary:
Time Complexity = O(n)
Space Complexity = O(n)
*/