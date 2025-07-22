package outside_leetcode.stacks;

import java.util.Stack;

public class RecursiveReverseStack {

    public static void insertAtBottom(Stack<Integer> stk, int item) {
        if(stk.isEmpty()) {
            stk.push(item);
            return;
        }
        int s = stk.peek();
        stk.pop();
        insertAtBottom(stk, item);
        stk.push(s);
        return;
    }

    //O(N^2)
    public static void reverse(Stack<Integer> stk) {
        if(stk.isEmpty()) {
            return;
        }
        int t = stk.peek();
        stk.pop();
        reverse(stk);
        insertAtBottom(stk, t);
    }

    public static void main(String[] args) {
        Stack<Integer> stk = new Stack<>();
        stk.push(1);
        stk.push(2);
        stk.push(3);
        stk.push(4);

        System.out.println(stk);
        reverse(stk);
        System.out.println(stk);
    }
}