public class Delete_Node_In_the_Linked_LIst_237 {
    public static void main(String[] args) {
        
    }

    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}

/*
Summary:
Time Complexity = O(1)
Space Complexity = O(1)
*/