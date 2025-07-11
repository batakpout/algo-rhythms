package leetcode.linkedlist;

/**
 LC: E: 203. Remove Linked List Elements
 Solved
 Easy
 Topics
 premium lock iconCompanies

 Given the head of a linked list and an integer val, remove all the nodes of the linked list that has Node.val == val, and return the new head.

 Input: head = [1,2,6,3,4,5,6], val = 6
 Output: [1,2,3,4,5]

 Example 2:

 Input: head = [], val = 1
 Output: []

 Example 3:

 Input: head = [7,7,7,7], val = 7
 Output: []

 */
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
