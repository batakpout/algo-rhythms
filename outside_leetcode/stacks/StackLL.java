package outside_leetcode.stacks;

class Node<T> {
    T data;
    Node<T> next;

    Node(T data) {
        this.data = data;
        this.next = null;
    }
}

public class StackLL<T> {

    Node<T> head = null;

    void push(T data) {
        Node<T> n = new Node<T>(data);
        n.next = head;
        head = n;
    }

    boolean isEmpty() {
        return head == null;
    }

    T peek() {
        return head.data;
    }

    void pop() {
        if (!isEmpty()) {
            Node<T> temp = head;
            head = head.next;
            temp.next = null;
        }
    }

    public static void main(String[] args) {
        StackLL<Character> s = new StackLL<>();

        s.push('h');
        s.push('e');
        s.push('l');
        s.push('l');
        s.push('o');

        while(!s.isEmpty()){
            System.out.println(s.peek());
            s.pop();
        }
    }
}
