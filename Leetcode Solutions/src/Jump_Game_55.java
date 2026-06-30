public class Jump_Game_55 {
    public static void main(String[] args) {
        
    }
    public boolean canJump(int[] nums) {
        int lastIdx = nums.length - 1;
        int currIdx = 0;
        int farthestIdx = nums[0];
        while(currIdx <= farthestIdx){
            if(farthestIdx < nums[currIdx] + currIdx){
                farthestIdx = nums[currIdx] + currIdx;
            }
            if(farthestIdx >= lastIdx) return true;
            currIdx++;
        }
        return false;
    }
}

/*
Learning:
How this Solution uses Greedy Approach:
1. The algorithm tracks a single variable representing the absolute farthest index reachable at any given moment.
2. It iterates through the array one step at a time, but strictly only up to that farthest reachable index.
3. At each step, it makes a greedy choice by calculating if the current position plus its jump length goes further than the known farthest reach.
4. If it does go further, it immediately overwrites the farthest reach with this new maximum value, securing the best local option.
5. It never looks back to reconsider previous jumps, relying entirely on constantly pushing the maximum boundary forward.
6. If the boundary ever reaches or passes the final index, it immediately succeeds and stops.
7. If the loop gets stuck because the current step exceeds the farthest reach, it means a zero trapped the path, and it fails.

Summary:
Time Complexity = O(n)
Space Complexity = O(1)
*/