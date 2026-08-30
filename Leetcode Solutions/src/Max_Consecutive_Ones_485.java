public class Max_Consecutive_Ones_485 {
    public static void main(String[] args) {
        
    }

    public int findMaxConsecutiveOnes(int[] nums) {
        int currCount = 0;
        int maxCount = 0;
        for (int num : nums) {
            if (num == 1) {
                currCount++;
            } else {
                currCount = 0;
            }
            maxCount = Math.max(currCount, maxCount);
        }
        return maxCount;
    }
}

/*
Summary:
Time Complexity = O(n)
Space Complexity = O(1)
*/
