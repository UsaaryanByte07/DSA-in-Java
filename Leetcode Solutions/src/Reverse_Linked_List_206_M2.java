public class Reverse_Linked_List_206_M2 {
    public static void main(String[] args) {
        
    }

    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode reversedHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return reversedHead;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

/*
#Recursive Method:
Learning:
1) Revise it Regularly
2) Misevaluated the Time Complexity as forgot to acknowledge the System Stack in the Case of Recursion.
Summary:
Time Complexity = O(n)
Space Complexity = O(1)
*/