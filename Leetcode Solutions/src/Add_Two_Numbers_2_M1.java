public class Add_Two_Numbers_2_M1 {
    public static void main(String[] args) {
        
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode curr1 = l1;
        ListNode curr2 = l2;
        ListNode l3 = null;
        ListNode head = null;
        int carry = 0;
        while (curr1 != null || curr2 != null) {
            ListNode newNode = new ListNode();
            int currDigitsSum;
            if (curr1 != null && curr2 != null) {
                currDigitsSum = curr1.val + curr2.val + carry;
            } else if (curr1 != null) {
                currDigitsSum = curr1.val + carry;
            } else {
                currDigitsSum = curr2.val + carry;
            }
            newNode.val = currDigitsSum % 10;
            if (l3 == null) {
                head = newNode;
                newNode.next = null;
                l3 = newNode;
            } else {
                l3.next = newNode;
                l3 = newNode;
            }
            carry = currDigitsSum / 10;
            if (curr1 != null) {
                curr1 = curr1.next;
            }
            if (curr2 != null) {
                curr2 = curr2.next;
            }
        }
        if (carry != 0) {
            ListNode newNode = new ListNode(carry);
            l3.next = newNode;
            l3 = newNode;
        }
        return head;
    }
}

/*
# Method 1 (Less Readable):
Learning:
Too Many If Else Statement which degrades Readability

Summary:
Time Complexity = O(max(n,m)) (n and m are the sized of Linked list l1 and l2)
Space Complexity = O(max(n,m)) (n and m are the sized of Linked list l1 and l2)
*/