public class Remove_Nth_Node_From_the_End_Of_List_19 {
    public static void main(String[] args) {
        
    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head.next == null) return null;
        int gap = n;
        ListNode fast = head;
        ListNode slow = head;
        for(int i = 0; i < gap; i++){
            fast = fast.next;
        }
        if (fast == null) return head.next;
        while(fast.next != null){
            slow = slow.next;
            fast = fast.next;
        }
        if(slow.next != null) slow.next = slow.next.next;
        return head;
    }
}

/*
# One - Pass Solution
Learning:
The strategy used here is the Two-Pointer (Fast & Slow) approach. By moving a "fast" pointer steps ahead, we create a gap of size between it and a "slow" pointer . When the fast pointer reaches the end of the list, the slow pointer will be sitting exactly one node before the node that needs to be deleted.

Summary:
Time Complexity = O(n)
Space Complexity = O(1)
*/