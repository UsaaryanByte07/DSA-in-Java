public class Palindrome_LInked_List_234 {
    public static void main(String[] args) {
        
    }

    public boolean isPalindrome(ListNode head) {
        ListNode slow = head, fast = head, prev, temp;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        prev = slow;
        slow = slow.next;
        prev.next = null;
        while (slow != null) {
            temp = slow.next;
            slow.next = prev;
            prev = slow;
            slow = temp;
        }
        fast = head;
        slow = prev;
        while (slow != null) {
            if (fast.val != slow.val) return false;
            fast = fast.next;
            slow = slow.next;
        }
        return true;
    }
}

/*
Learning:
he answer is to reverse the back half of the linked list to have the next attribute point to the previous node instead of the next node. (Note: we could instead add a prev attribute as we iterate through the linked list, rather than overwriting next on the back half, but that would technically use O(N) extra space, just as if we'd created an external array of node values.)

The first challenge then becomes finding the middle of the linked list in order to start our reversing process there. For that, we can look to Floyd's Cycle Detection Algorithm.

With Floyd's, we'll travel through the linked list with two pointers, one of which is moving twice as fast as the other. When the fast pointer reaches the end of the list, the slow pointer must then be in the middle.

With slow now at the middle, we can reverse the back half of the list with the help of another variable to contain a reference to the previous node (prev) and a three-way swap. Before we do this, however, we'll want to set prev.next = null, so that we break the reverse cycle and avoid an endless loop.

Once the back half is properly reversed and slow is once again at the end of the list, we can now start fast back over again at the head and compare the two halves simultaneously, with no extra space required.

If the two pointers ever disagree in value, we can return false, otherwise we can return true if both pointers reach the middle successfully.

Summary:
Time Complexity = O(n)
Space Complexity = O(1)
*/