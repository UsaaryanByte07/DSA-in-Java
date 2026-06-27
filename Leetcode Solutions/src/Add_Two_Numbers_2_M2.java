public class Add_Two_Numbers_2_M2 {
    public static void main(String[] args) {
        
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            int currDigitsSum = carry;
            if(l1 != null){
                currDigitsSum += l1.val;
                l1 = l1.next;
            }
            if(l2 != null){
                currDigitsSum += l2.val;
                l2 = l2.next;
            }
            ListNode newNode = new ListNode(currDigitsSum%10);
            curr.next = newNode;
            carry = currDigitsSum / 10;
            curr = curr.next;
        }
        return dummy.next;
    }
}


/*
# Method 2 (More Readable):
Learning:
Due to the Introduction of Dummy Node the responsibility of handling edge cases was gone, which reduced the number of if-else and made the code cleaner.

Summary:
Time Complexity = O(max(n,m)) (n and m are the sized of Linked list l1 and l2)
Space Complexity = O(max(n,m)) (n and m are the sized of Linked list l1 and l2)
*/