public class Find_Duplicate_Number_287_M2 {
    public static void main(String[] args) {
        
    }

    public int findDuplicate(int[] nums) {
        int slow = 0;
        int fast = 0;
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        slow = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        
        return slow;
    }
}

/*
# Two Pointer Linked List Approach:
Learning:
1) Array as a Linked List:
Take the array [1,3,4,2] as an example, the index of this array is [0,1,2,3], we can map the index to the nums[n].
0→1→3→2→4→3→2
2) How Duplicates form Cycle in this Linked List:
If there are a repeated numbers in the array, take the array [1,3,4,2,2] as an example,
0→1→3→2→4→2→4→2..(A Cycle of 2 and 4 is formed)
3) So In our solution the do-while loop determines if a cycle exists:
You can Refer the Problem #141 Linked list Cycle to understand this do-while loop. here similar to Problem a two pointer approach of slow and fast Pointer is used. the Slow pointer here also moves 1 step at a time( slow = nums[slow]), while the fast pointer moves 2 steps at a time( fast = nums[nums[fast]]). (if it is pointer = nums[nums[nums[pointer]]] it would be 3 steps, if it is pointer = nums[nums[nums[nums[pointer]]]] it would be 4 steps and so on..).
4) The second while loop find the entrance of the loop formed in the linked list as it would be our result as the entrance of the linked list will be the duplicate element we are trying to find:
When the fast pointer and slow pointer meet for the first time inside the cycle, they are at an arbitrary intersection point, not necessarily the start of the cycle.
The genius of this algorithm relies on a mathematical coincidence regarding the distances traveled. If you reset one pointer to the very beginning of the array and leave the other pointer at the intersection point, and then move both of them exactly one step at a time, they will always collide exactly at the entrance of the cycle. for Mathematical Proof visit the ref #5

Summary:
Time Complexity = O(n)
Space Complexity = O(1)
*/