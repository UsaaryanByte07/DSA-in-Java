public class Odd_Even_Linked_List_328 {
    public static void main(String[] args) {
        
    }

    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = head.next;
        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }
}

/*
Learning:
-> The core objective of the Odd Even Linked List problem is to rearrange the list in place by grouping all odd-indexed nodes together first, followed directly by all even-indexed nodes.
-> We must achieve this with an O(1) space complexity and O(n) time complexity, meaning we rewire the existing nodes rather than creating any new ones in memory.
-> We initialize three pointers: an 'odd' pointer starting at the head (node 1), an 'even' pointer starting at the second node (head.next), and an 'even_head' pointer also starting at the second node.
-> The 'even_head' pointer acts as a crucial anchor; we must keep it safe because we will need it to attach the entire even sequence to the end of the odd sequence once we finish traversing.
-> We run a while loop that continues strictly as long as both 'even' and 'even.next' exist, which prevents the code from crashing when it reaches the end of lists with odd or even lengths.
-> Inside the loop, we leapfrog the odd pointer by setting 'odd.next = even.next' to skip the even node, and then we advance the 'odd' pointer forward to its new position.
-> We immediately do the exact same leapfrog motion for the even pointer by setting 'even.next = odd.next', and then we advance the 'even' pointer forward.
-> Once the loop terminates, the two chains are fully separated, so we execute 'odd.next = even_head' to merge the head of the even chain onto the tail of the odd chain.
-> As an example, if your initial input list is 1 -> 2 -> 3 -> 4 -> 5 -> NULL, the odd pointer traces the path to isolate 1 -> 3 -> 5, while the even pointer traces the path to isolate 2 -> 4.
-> When we connect the saved 'even_head' to the end of the odd group, the final linked list successfully becomes 1 -> 3 -> 5 -> 2 -> 4 -> NULL.

Summary:
Time Complexity = O(n)
Space Complexity = O(1)
*/