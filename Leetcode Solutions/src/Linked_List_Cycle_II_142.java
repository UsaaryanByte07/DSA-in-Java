public class Linked_List_Cycle_II_142 {
    public static void main(String[] args) {
        
    }

    public ListNode detectCycle(ListNode head) {
        // 1. Immediately eliminate lists that are too small to have a cycle
        if (head == null || head.next == null) {
            return null;
        }

        // 2. Initialize pointers already one step in motion
        ListNode slow = head.next;
        ListNode fast = head.next.next;

        // Phase 1: The First While Loop (Cycle Detection)
        // Run as long as the path is safe AND the pointers haven't met
        while (fast != null && fast.next != null && slow != fast) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // If the loop finished because fast hit the end, there is no cycle
        if (fast == null || fast.next == null) {
            return null;
        }

        // Phase 2: The Second While Loop (Find Entrance)
        slow = head;

        // Run until they collide at the exact cycle entrance
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }
}

/*
# Two Pointer Approach:
Learning:
3) So In our solution the while loop determines if a cycle exists:
You can Refer the Problem #141 Linked list Cycle to understand this do-while loop. here similar to Problem a two pointer approach of slow and fast Pointer is used. the Slow pointer here also moves 1 step at a time, while the fast pointer moves 2 steps at a time
4) The second while loop find the entrance of the loop formed in the linked list:
When the fast pointer and slow pointer meet for the first time inside the cycle, they are at an arbitrary intersection point, not necessarily the start of the cycle.
The genius of this algorithm relies on a mathematical coincidence regarding the distances traveled. If you reset one pointer to the very beginning of the array and leave the other pointer at the intersection point, and then move both of them exactly one step at a time, they will always collide exactly at the entrance of the cycle. for Mathematical Proof visit the ref #5

Summary:
Time Complexity = O(n)
Space Complexity = O(1)
*/