import java.util.Arrays;

public class Frequency_Of_the_Most_Frequent_Element_1838 {
    public static void main(String[] args) {
        
    }

    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int left = 0;
        long windowSum = 0;
        int maxFreq = 0;
        for(int right = 0; right < nums.length ; right++){
            windowSum += nums[right];
            while((long)(right - left + 1)*nums[right] - windowSum > k){
                windowSum -= nums[left++];
            }
            maxFreq = Math.max(maxFreq, right - left + 1);
        }
        return maxFreq;
    }
}

/*
# Sliding Window and Sorting:
Learning:
To solve this problem efficiently, we combine sorting with a sliding window technique. The goal is to find the longest possible window of numbers that can be made identical to the largest number in that window, using at most `k` increments.
-> Sort the Input: First, sort the array in ascending order. This guarantees that elements closest in value are placed next to each other. If you want to increase numbers to match a specific target, it is always cheaper to increment numbers that are already close to that target.
-> Define the Window: Create a sliding window with a left boundary and a right boundary, both starting at the very beginning of the array. The element at the right boundary will always act as our current target number, because the array is sorted and it is the largest number in the current window.
-> Expand and Accumulate: Move the right boundary forward one step at a time. As you include a new number in your window, add its value to a running total of the window's elements.
-> Calculate Operations Needed: Determine if it is actually possible to make all numbers in the current window equal to the target number. You do this by multiplying the total number of elements in the window by the target number, and then subtracting your running total. This mathematical shortcut gives you the exact number of +1 increments required.
-> Shrink if Invalid: Check if the required increments exceed your allowed operations (`k`). If they do, the current window is too large and invalid. You must shrink it by moving the left boundary forward. As you move the left boundary, subtract the number you leave behind from your running total.
-> Record the Maximum: Every time you have a valid window (where operations needed are less than or equal to `k`), calculate the number of elements inside it. Compare this size to the largest window size you have recorded so far, and keep the highest value. The highest value at the end of the array is your maximum frequency.

Summary:
Time Complexity = O(nlogn)
Space Complexity = O(1)
*/