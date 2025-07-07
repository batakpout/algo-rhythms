package leetcode.linkedlist;


public class SinglyLinkedList {
     ListNode head;

    public void pushBack(int val) {
        ListNode newNode = new ListNode(val);

        if (head == null) {
            head = newNode;
        } else {

            ListNode current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;

        }
    }

    public void display(ListNode head) {
        ListNode curr = head;
        while(curr != null) {
            System.out.print(curr.data + "->");
            curr = curr.next;
        }
        System.out.println("Null");
    }
}
