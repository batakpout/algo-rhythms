package leetcode.linkedlist;

public class RemoveLinkedListElements {

    //uses extra memory
    public static ListNode removeElements(ListNode head, int val) {
        ListNode curr = head;
        SinglyLinkedList list = new SinglyLinkedList();
        while(curr != null) {
            if(curr.data != val) {
               list.pushBack(curr.data);
            }
            curr = curr.next;
        }
        return list.head;
    }

    //O(N) time and O(1) space
    public static ListNode removeElements2(ListNode head, int val) {
        ListNode curr = head;
        ListNode dummy = new ListNode(-1);
        dummy.next = curr;
        ListNode prev = dummy;
        ListNode nxt = null;
        while(curr != null) {
           nxt = curr.next;
           if(curr.data == val) {
               prev.next = nxt;
           } else {
               prev = curr;
           }
           curr = nxt;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(6, new ListNode(3,new ListNode(4,new ListNode(5,new ListNode(6)))))));
        //ListNode head = new ListNode(7, new ListNode(7, new ListNode(7, new ListNode(7,new ListNode(7,new ListNode(7,new ListNode(7)))))));
        new SinglyLinkedList().display(head);
        head = removeElements2(head, 6);
        new SinglyLinkedList().display(head);
    }
}
