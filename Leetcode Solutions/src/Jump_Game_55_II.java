public class Jump_Game_55_II {
    public static void main(String[] args) {
        
    }
     public int jump(int[] nums) {
        if(nums.length <= 1) return 0;

        int lastIdx = nums.length - 1;
        int farthestIdx = 0;
        int jumps = 0;
        int currentJumpEnd = 0;
        for(int i = 0; i < nums.length - 1; i++){
            farthestIdx = Math.max(farthestIdx, i + nums[i]);

            if(i == currentJumpEnd){
                jumps++;
                currentJumpEnd = farthestIdx;

                if(currentJumpEnd >= lastIdx) break;
            }
        }
        return jumps;
    }
}

/*
Learning:
-> The method uses a greedy approach to keep track of the maximum reach at each step to find the minimum number of jumps.
-> It first checks if the array has one or fewer elements, and if so, it immediately returns zero because no jumps are required to reach the end.
-> Three main variables are set up: jumps to count the total jumps made, currentJumpEnd to mark the boundary of the current jump, and farthestIdx to store the absolute furthest index reachable so far.
-> A loop iterates through the array but stops exactly one element before the end, because standing on the last element requires no further jumps.
-> At every single position, the algorithm calculates how far it can reach by adding the current index to the number at that index.
-> It compares this new reach with the farthestIdx and keeps the larger of the two values to ensure it always knows the best possible move.
-> As the loop progresses, it eventually reaches the currentJumpEnd, which means it has evaluated every possible takeoff spot for the current jump window.
-> Once it hits this boundary, the algorithm commits to making a jump, so the jumps counter is increased by one.
-> The currentJumpEnd is then updated to equal the farthestIdx, effectively establishing the limit of the next jump window.
-> An optimization check is performed right after updating the boundary; if the new boundary reaches or exceeds the last index of the array, the loop breaks early to save processing time.
-> After the loop finishes or breaks, the method returns the final count of jumps.

Summary:
Time Complexity = O(n)
Space Complexity = O(1)
*/