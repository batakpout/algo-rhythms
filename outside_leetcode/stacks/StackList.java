package outside_leetcode.stacks;

import java.util.ArrayList;

public class StackList<T> {

    private ArrayList<T> arr = new ArrayList<>();

    void push(T data) {
        arr.add(data);
    }

    boolean isEmpty() {
        return arr.isEmpty();
    }

    void pop() {
        arr.remove(arr.size() - 1);
        //can replace with arr.removeLast();
    }

    T peek() {
        return arr.get(arr.size() - 1);
        //can replace with arr.getLast();
    }

    public static void main(String[] args) {
        StackList<Integer> s = new StackList<>();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(5);
        s.push(10);

        while (!s.isEmpty()) {
            System.out.println(s.peek());
            s.pop();
        }
    }
}
