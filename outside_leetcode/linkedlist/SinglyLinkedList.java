package outside_leetcode.linkedlist;

class ListNode {
    int data;
    ListNode next;

    ListNode() {
    }

    ListNode(int data) {
        this.data = data;
    }

    ListNode(int data, ListNode next) {
        this.data = data;
        this.next = next;
    }
}

public class SinglyLinkedList {
    private ListNode head;
    private ListNode tail;

    public SinglyLinkedList() {
        this.head = null;
    }

    public static ListNode pushFrontReturn(ListNode head, int val) {
        ListNode newNode = new ListNode(val);
        newNode.next = head; // Works even if head is null
        head = newNode;
        return newNode;
    }

    public void pushFront(int val) {
        ListNode newNode = new ListNode(val);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
    }

    public void pushBack(int val) {
        ListNode newNode = new ListNode(val);
        if (head == null) {
            head = tail = newNode;
        } else {
            /**
             if we don't have tail then :
             ListNode current = head;
             while (current.next != null) {
             current = current.next;
             }
             current.next = newNode
             */
            tail.next = newNode;
            tail = newNode;
        }
    }

    public void display() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        ListNode current = head;
        System.out.print("List: ");
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public void display(ListNode head) {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        ListNode current = head;
        System.out.print("List: ");
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public void insert(int val, int pos) {
        ListNode newNode = new ListNode(val);
        if (pos == 0) {
            newNode.next = head;
            head = newNode;
        } else {
            int currentIndex = 0;
            ListNode current = head;
            //for pos = 2, this loop should run once only
            while (current != null && currentIndex < pos - 1) {
                current = current.next;
                currentIndex++;
            }
            // If position is invalid (greater than list size)
            if (current == null) {
                System.out.println("Invalid position");
                return;
            }
            newNode.next = current.next;
            current.next = newNode;
        }

    }

    public int search1(int d) {
        int idx = 0;
        ListNode current = head;
        while (current != null) {
            if (current.data == d) return idx;
            current = current.next;
            idx++;
        }
        return -1;
    }

    public int search(int d) {
        return searchRecursive(head, d, 0);
    }

    private int searchRecursive(ListNode node, int d, int idx) {
        if (node == null) return -1;
        if (node.data == d) return idx;
        return searchRecursive(node.next, d, idx + 1);
    }

    public boolean isEmpty() {
        return head == null;
    }

    public int size() {
        int count = 0;
        ListNode current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    /**
     * Since Java has automatic garbage collection, you don’t need to manually free memory like in C or C++.
     * You just need to remove references to all nodes by setting head and tail to null. Optionally, you can also traverse
     * the list and nullify each next pointer, but it’s not strictly necessary.
     */
    public void destroy() {
        ListNode current = head;
        while (current != null) {
            ListNode temp = current;
            current = current.next;
            temp.next = null; // Remove reference to help GC
        }
        head = tail = null;
    }

    public void popFront() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        ListNode temp = head;
        head = head.next;
        temp.next = null;
        if (head == null) {
            tail = null;
        }

    }

    public void deleteLastUsingLast() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        if (head.next == null) {
            head = tail = null;
            return;
        }
        ListNode current = head;
        while (current.next != tail) {
            current = current.next;
        }
        current.next = null;
        tail = current;
    }

    public void deleteLast() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        if (head.next == null) {
            head = null;
            return;
        }
        ListNode current = head;
        while (current.next.next != null) {
            current = current.next;
        }
        current.next = null;
    }

    /*
     Swapping is expensive op. what if we have songs of MBs in each node, so swaps will be expensive
     moving addresses is quick as we are assigning references which is number of 4 bytes only
     */
    public void reverse() {
        ListNode current = head;
        ListNode temp;
        ListNode prev = null;
        //tail = current; ?
        while (current != null) {
            temp = current.next;
            current.next = prev;
            prev = current;
            current = temp;
        }
        head = prev;

    }

    public ListNode recursiveReverseHelper(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode newHead = recursiveReverseHelper(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    public void recursiveReverse() {
        if (head == null || head.next == null) return;
        tail = head;
        head = recursiveReverseHelper(head);
    }

    public void kReverse(int k) {
        head = kReverseRecursive(head, k);
    }

    public ListNode kReverseRecursive(ListNode head, int k) {
        if (head == null || k <= 1) return head;

        ListNode temp = null;
        ListNode curr = head;
        ListNode prev = null;
        int cnt = 1;

        while (curr != null && cnt <= k) {
            temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
            cnt++;
        }

        if (temp != null) {
            head.next = kReverseRecursive(temp, k);
        }

        return prev;
    }

    public SinglyLinkedList mergeSortedNodes(SinglyLinkedList list1, SinglyLinkedList list2) {

        ListNode head1 = list1.head;
        ListNode head2 = list2.head;
        SinglyLinkedList newList = new SinglyLinkedList();
        while (head1 != null && head2 != null) {
            if (head1.data < head2.data) {
                newList.pushBack(head1.data);
                head1 = head1.next;
            } else {
                newList.pushBack(head2.data);
                head2 = head2.next;
            }
        }
        while (head1 != null) {
            newList.pushBack(head1.data);
            head1 = head1.next;
        }

        while (head2 != null) {
            newList.pushBack(head2.data);
            head2 = head2.next;
        }
        return newList;
    }

    public ListNode mergeSortedNodesRecursive(ListNode node1, ListNode node2) {
        if (node1 == null) return node2;
        if (node2 == null) return node1;

        ListNode res;
        if (node1.data < node2.data) {
            res = node1;
            res.next = mergeSortedNodesRecursive(node1.next, node2);
        } else {
            res = node2;
            res.next = mergeSortedNodesRecursive(node1, node2.next);
        }
        return res;
    }

    //using runner technique
    //1->2->3->4->5->6->7->8
    //1->2->3->4->5->6->7->8->9
    public int middleElement() {
        ListNode slowPointer = head;
        ListNode fastPointer = head;
        while (fastPointer.next != null && fastPointer.next.next != null) {
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
        }
        System.out.println(slowPointer.data);

        return -1;
    }

    // Kth Last Element (Single Pass)
    // Return the Kth last element of a linked list using two pointers.
    // Assumption: K ≤ length of the list.
    // Example: For 1→2→3→4→5→6→7 and K=3 → Output: 5
    //using runner technique
    int kthLastElement(int k) {
        ListNode slowPointer = head;
        ListNode fastPointer = head;
        int count = 0;
        //keep k step gap between the slow and fast pointe
        while (count < k) {
            fastPointer = fastPointer.next;
            count++;
        }

        //now move fast and slow pointer, once fast reaches null, slower will
        // be k steps away from fast pointer
        while (fastPointer != null) {
            fastPointer = fastPointer.next;
            slowPointer = slowPointer.next;
        }

        assert slowPointer != null;
        return slowPointer.data;
    }

    int kthLastElementNaive(int k) {
        int cnt = 0;
        ListNode curr = head;
        while (curr != null) {
            cnt++;
            curr = curr.next;
        }
        curr = head;
        for (int i = 0; i < cnt - k; i++) {
            curr = curr.next;
        }
        return curr.data;
    }

    public SinglyLinkedList alternativeMerge(SinglyLinkedList list1, SinglyLinkedList list2) {

        ListNode head1 = list1.head;
        ListNode head2 = list2.head;
        SinglyLinkedList newList = new SinglyLinkedList();
        int c = 0;
        while (head1 != null && head2 != null) {
            if (c % 2 == 0) {
                newList.pushBack(head1.data);
                head1 = head1.next;
            } else {
                newList.pushBack(head2.data);
                head2 = head2.next;
            }
            c++;
        }

        while (head1 != null) {
            newList.pushBack(head1.data);
            head1 = head1.next;
        }

        while (head2 != null) {
            newList.pushBack(head2.data);
            head2 = head2.next;
        }
        return newList;

    }


    public static void print(ListNode head) {
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.data + "-->");
            curr = curr.next;
        }
        System.out.println("NULL");
    }

    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();

        System.out.println("Initial list:");
        list.display();
        System.out.println("Is empty: " + list.isEmpty());

        // Add elements to the front
        list.pushFront(40);
        System.out.println("\nAfter adding 10:");
        list.display();

        list.pushFront(20);
        System.out.println("\nAfter adding 20:");
        list.display();

        list.pushFront(10);
        System.out.println("\nAfter adding 30:");
        list.display();

        System.out.println("\nList size: " + list.size());
        System.out.println("Is empty: " + list.isEmpty());

        System.out.println("\nAfter appending 50, 60: ");
        list.pushBack(50);
        list.pushBack(60);
        System.out.println("\nAfter inserting 40 at pos 2: ");
        list.insert(30, 2);
        list.pushBack(70);
        list.pushBack(80);
        list.display();

        int searchIndex = list.search(40);
        System.out.println("50 is found at index: " + searchIndex);


        //list.destroy();
        //System.out.println("Popping front of the list:");
        // list.popFront();
        // list.popFront();
        // list.display();

        //list.reverse();
        //list.recursiveReverse();
        //System.out.println("Reversed list:");
        list.kReverse(3);
        list.display();

        SinglyLinkedList list1 = new SinglyLinkedList();
        list1.pushBack(1);
        list1.pushBack(5);
        list1.pushBack(7);
        list1.pushBack(10);

        SinglyLinkedList list2 = new SinglyLinkedList();
        list2.pushBack(2);
        list2.pushBack(3);
        list2.pushBack(6);
        list1.display();
        list2.display();

        //SinglyLinkedList list3 = list.mergeSortedNodes(list1, list2);
        System.out.println("Merging two lists output: ");
        ListNode merged = list.mergeSortedNodesRecursive(list1.head, list2.head);
        print(merged);

        System.out.println("Middle element of list: ");
        SinglyLinkedList newList = new SinglyLinkedList();
        newList.pushBack(1);
        newList.pushBack(2);
        newList.pushBack(3);
        newList.pushBack(4);
        newList.pushBack(5);
        newList.pushBack(6);
        newList.pushBack(7);
        newList.pushBack(8);
        newList.pushBack(9);
        newList.display();
        //1->2->3->4->5->6->7->8
        newList.middleElement();
        System.out.println("kth element of list:");
        int r = newList.kthLastElement(4);
        System.out.println(r);

        SinglyLinkedList mList1 = new SinglyLinkedList();
        mList1.pushBack(5);
        mList1.pushBack(7);
        mList1.pushBack(17);
        mList1.pushBack(13);
        mList1.pushBack(11);
        SinglyLinkedList mList2 = new SinglyLinkedList();
        mList2.pushBack(12);
        mList2.pushBack(10);
        mList2.pushBack(2);
        mList2.pushBack(4);
        mList2.pushBack(6);
        System.out.println("Displaying list1, list2:");
        mList1.display();
        mList2.display();
        System.out.println("Alternative merge");
        SinglyLinkedList altMerged = list.alternativeMerge(mList1, mList2);
        altMerged.display();
    }
}
