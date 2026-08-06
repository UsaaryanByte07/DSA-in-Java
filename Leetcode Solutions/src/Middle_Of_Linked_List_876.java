public class Middle_Of_Linked_List_876 {
 public static void main(String[] args) {
    
 }  
 
 public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return fast.next == null ? slow : slow.next; //For Odd and Even number of Nodes Edge Cases
    }
}

/*
# Tortoise Hare Method:
Learning:
-> The Tortoise and Hare algorithm is an efficient method to find the middle of a linked list in a single pass, utilizing two pointers moving at different speeds.
-> We initialize two pointers, typically named `slow` (the tortoise) and `fast` (the hare), and both start at the `head` of the linked list.
-> During each iteration of the traversal, the `slow` pointer advances by exactly one node (`slow = slow.next`), while the `fast` pointer advances by exactly two nodes (`fast = fast.next.next`).
-> The loop continues running based on the condition `while (fast != null && fast.next != null)`, which ensures that the `fast` pointer has enough track left to make its two-step jump without throwing a NullPointerException.
-> For a list with an odd number of nodes (e.g., 5 nodes), the `fast` pointer will eventually land perfectly on the very last node. Because `fast.next` is now null, the loop terminates, and the `slow` pointer is left sitting squarely on the exact middle node (the 3rd node).
-> For a list with an even number of nodes (e.g., 6 nodes), the `fast` pointer will jump completely past the last node, becoming `null` itself. This causes the loop to terminate immediately, leaving the `slow` pointer resting on the second of the two middle nodes (the 4th node), which satisfies the problem's specific requirement.
-> The mathematical proof of why this works relies on the relative speeds of the pointers: if the `fast` pointer travels exactly twice as fast as the `slow` pointer, the `slow` pointer will have covered exactly half the distance by the time the `fast` pointer reaches the end.
-> Let N represent the total number of nodes in the list, and let k represent the total number of iterations (or steps) the loop executes. After k iterations, the `slow` pointer is at node index k, and the `fast` pointer is at node index 2k (assuming a zero-indexed system for distance).
-> Proof for Odd length: If N is odd, it can be written as N = 2k + 1. The `fast` pointer stops at the last node, which is at distance 2k. Since the `fast` pointer moved 2k steps, the `slow` pointer moved exactly k steps. The node at distance k in a list of size 2k + 1 is the exact mathematical median.
-> Proof for Even length: If N is even, it can be written as N = 2k. The `fast` pointer stops when it falls off the end of the list, meaning it covers a distance of 2k. The `slow` pointer therefore covers a distance of k. In a list of length 2k, the nodes at distance k-1 and k are the two middle nodes. Because the `slow` pointer sits at distance k, it flawlessly returns the second middle node as requested.

Summary:
Time Complexity = O(n)
Space Complexity = O(1)
*/