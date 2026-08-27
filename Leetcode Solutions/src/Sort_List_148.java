public class Sort_List_148 {
    public static void main(String[] args) {
        
    }

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode mid = getMid(head);
        ListNode rightHead = mid.next;
        mid.next = null;
        ListNode leftSortedList = sortList(head);
        ListNode rightSortedList = sortList(rightHead);

        return merge(leftSortedList, rightSortedList);
    }

    public static ListNode merge(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;

        // Standard merge logic for two independent lists
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                current.next = list1;
                list1 = list1.next;
            } else {
                current.next = list2;
                list2 = list2.next;
            }
            current = current.next;
        }

        // Attach any remaining nodes
        if (list1 != null) {
            current.next = list1;
        } else {
            current.next = list2;
        }

        return dummy.next;
    }

    public static ListNode getMid(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;
        // fast starts one step ahead so slow lands on the first middle

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
}

/*
# Recursive Merge Sort Method:
Learning:
-> the Logic of merging uses the same logic as the Leetcode Question 21 of Merging two sorted list.
-> and the Logic of finding the middle element uses the same logic as the Leetcode Question 876 of Middle of the Linked List.
-> inn each recursive call of function sortList() we find the mid and then break the list from middle using  mid.next = null that creates two separate left and right list.. and then we recursively call the sortList() on the left and right list.. and at last we merge the left and right sorted list and return..

Summary:
Time Complexity = O(nlogn)
Space Complexity = O(logn) (Due to Recursion Stack)
*/