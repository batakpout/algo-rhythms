package leetcode.linkedlist;

/**
 * LC: 83: E:  Remove Duplicates from Sorted List
 * Given the head of a sorted linked list, delete all duplicates such that each element appears only once. Return the linked list sorted as well.
 * Input: head = [1,1,2]
 * Output: [1,2]
 * <p>
 * Input: head = [1,1,2,3,3]
 * Output: [1,2,3]
 * <p>
 * The number of nodes in the list is in the range [0, 300].
 * -100 <= Node.val <= 100
 * The list is guaranteed to be sorted in ascending order.
 */
public class RemoveDuplicates {

    //O(N)
    public static ListNode deleteDuplicates(ListNode head) {
        ListNode curr = head;
        while (curr != null && curr.next != null) {
            if (curr.data == curr.next.data) {
                curr.next = curr.next.next;
            } else {
                curr = curr.next;
            }
        }
        return head;
    }

    public static ListNode deleteDuplicates2(ListNode head) {
        ListNode prev = head;
        ListNode temp = prev.next;
        while (temp != null) {
            if (temp.data == prev.data) {
                temp = temp.next;
                continue;
            }
            prev.next = temp;
            prev = temp;
            temp = temp.next;
        }
        prev.next = null;
        return head;
    }

    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        list.pushBack(1);
        list.pushBack(1);
        list.pushBack(1);
        list.pushBack(1);
        list.pushBack(2);
        list.pushBack(2);

        ListNode head = deleteDuplicates(list.head);
        list.display(head);
    }
}