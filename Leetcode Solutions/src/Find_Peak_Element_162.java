public class Find_Peak_Element_162 {
    public static void main(String[] args) {
        
    }

    public int findPeakElement(int[] nums) {
        int n = nums.length;
        if (n == 1) return 0;
        if (nums[0] > nums[1]) return 0;
        if (nums[n - 1] > nums[n - 2]) return n - 1;
        int left = 1;
        int right = n - 2;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[mid - 1] &&
                    nums[mid] > nums[mid + 1]) {
                return mid;
            }else if (nums[mid] > nums[mid - 1]) {
                left = mid + 1;
            }else {
                right = mid - 1;
            }
        }

        return -1;
    }
}

/*
Learning:
-> Binary search does not only work on sorted arrays but on any problem where you can definitively eliminate half of the search space based on a single condition
-> The hidden trick in this problem is that both ends of the array fall off a cliff into negative infinity
-> Imagine you are blindfolded and dropped onto a random spot in a mountain range which represents finding the middle index of the array
-> Your only goal is to find any peak so you take one step to your right to compare your current spot with the next spot
-> If the step to the right goes up you are currently climbing an ascending slope
-> Because the right side of the mountain eventually falls off a cliff keeping walking up to the right mathematically guarantees you will eventually hit a peak
-> In this upward case you can safely ignore the entire left half of the mountain because you know for a fact a peak exists on the right
-> If the step to the right goes down you are on a descending slope which means the peak you just fell from is to your left
-> Because the left side also falls off a cliff turning around and walking left guarantees you will hit a peak so you eliminate the entire right half
-> By always moving towards higher ground a greedy climber will always find a peak without needing the entire mountain to be perfectly sorted
-> To put this into code logic we start by setting our low pointer to the very first index of the array and our high pointer to the very last index
-> A loop runs as long as the low pointer is strictly less than the high pointer because if they meet we have found our peak
-> Inside the loop we calculate the middle index to be the midpoint between our current low and high pointers
-> We then check if the value at the middle index is less than the value immediately to its right
-> If it is smaller we are on an ascending slope so we eliminate the left half by moving the low pointer to the index just after the middle
-> If the middle value is greater than or equal to the value to its right we are on a descending slope
-> In this descending case we eliminate the right half by pulling the high pointer exactly to the middle index because the middle itself could be the peak
-> The loop continues to chop the search space in half based on the slope direction until only one element is left
-> When the loop finally finishes the low and high pointers will be pointing at the exact same index
-> We then simply return the low pointer because it now perfectly marks the index of the peak element

Summary:
Time Complexity = O(logn)
Space Complexity = O(1)
*/