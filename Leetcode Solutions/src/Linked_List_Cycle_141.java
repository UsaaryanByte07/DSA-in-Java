public class Linked_List_Cycle_141 {
    public static void main(String[] args) {

    }

    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {

            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true;
            }
        }

        return false;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}

/*
#Floyd's algorithm:
Learning:
1) Remember the Fast Runner and Slow Runner running in a loop. they both will eventually meet at some point in the loop due to there speed difference.
Here is the precise, point-wise breakdown of the logic and time complexity for your notes:
2) Why `slow = 1` and `fast = 2` steps?
->Relative Speed of 1: When the fast pointer moves 2 steps and the slow pointer moves 1 step, the fast pointer closes the gap by exactly 1 node per iteration (2 - 1 = 1).
->Guaranteed Meeting: Because the distance decreases by exactly 1 at a time, it is mathematically impossible for the fast pointer to "jump over" or skip the slow pointer. They are guaranteed to land on the exact same node.
->The Leapfrog Problem: If you used `fast = 3` and `slow = 1` (a relative speed of 2), the fast pointer could skip over the slow pointer if the cycle length is an odd number. This would force them to run extra laps before finally meeting.
->Minimal Null Checks: Moving 2 steps keeps the code clean. You only need to verify two nodes ahead (`fast != null && fast.next != null`) to prevent a `NullPointerException`.
->Code Overhead: Moving 4 or 5 steps would require a long, messy chain of `if` conditions to check every single node for `null` before making the jump, which adds unnecessary code complexity for zero performance gain.
3) How to Calculate the O(n) Time Complexity
->Defining the List Parts:** Let `N` be the number of nodes in the straight line before the cycle, and `K` be the number of nodes inside the cycle itself.
->Phase 1 (Entering the Cycle):** It takes the slow pointer exactly `N` steps to travel down the straight line and enter the cycle.
->Phase 2 (The Chase): By the time the slow pointer enters the cycle, the fast pointer is already running laps inside it.
->Maximum Distance: The maximum possible gap between the two pointers at this exact moment is the total length of the cycle (`K` nodes).
->Phase 3 (Catching Up): Since the fast pointer catches up at a rate of 1 node per step, it will take a maximum of `K` steps to close the gap.
->Final Calculation: Total maximum steps = `N` (to reach the loop) + `K` (to catch up). Since `N + K` represents the total nodes in the list, the operations scale linearly with the input, proving the time complexity is strictly bounded to O(n).

Summary:
Time Complexity = O(n)
Space Complexity = O(1)
*/