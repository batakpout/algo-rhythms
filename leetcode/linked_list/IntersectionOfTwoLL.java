package leetcode.linkedlist;

import java.util.*;

/**
 LC: E: 160. Intersection of Two Linked Lists
 Given the heads of two singly linked-lists headA and headB, return the node at which the two lists intersect. If the
 two linked lists have no intersection at all, return null.

 Input: intersectVal = 8, listA = [4,1,8,4,5], listB = [5,6,1,8,4,5], skipA = 2, skipB = 3

 */
public class IntersectionOfTwoLL {

    //TC: O(N+M) and SC: O(N)
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> s = new HashSet<>();
        ListNode curr = headA;
        while (curr != null) {
            s.add(curr);
            curr = curr.next;
        }

        curr = headB;
        while (curr != null) {
            if (s.contains(curr)) return curr;
            curr = curr.next;
        }
        return null;
    }

    private static int len(ListNode head) {
        int c = 0;
        while(head != null) {
            c++;
            head = head.next;
        }
        return c;
    }

    //TC: O(N+M) and SC: O(1)
    public static ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        int l1 = len(headA);
        int l2 = len(headB);
        while(l1 > l2) {
            headA = headA.next;
            l1--;
        }
        while(l2 > l1) {
            headB = headB.next;
            l2--;
        }

        while(headA != headB) {
          headA = headA.next;
          headB = headB.next;
        }

        return headA;


    }

    public static void main(String[] args) {
        ListNode intersection = new ListNode(8, new ListNode(4, new ListNode(5)));
        ListNode headA = new ListNode(4, new ListNode(1, intersection));
        ListNode headB = new ListNode(5, new ListNode(6, new ListNode(1, intersection)));
        System.out.print("List A: ");
        new SinglyLinkedList().display(headA);

        System.out.print("List B: ");
        new SinglyLinkedList().display(headB);
        ListNode result = getIntersectionNode2(headA, headB);
        if (result != null) {
            System.out.println("Intersection at node with value: " + result.data);
        } else {
            System.out.println("No intersection found.");
        }
    }
}
