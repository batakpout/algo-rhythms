package outside_leetcode.stacks;

import java.util.Stack;

public class InbuildStack {
    public static void main(String[] args) {
        Stack<String> stk = new Stack<>();
        stk.push("Can't hurt me");
        stk.add("Atomic habits");
        stk.add("Ikigai");

        while(!stk.isEmpty()) {
            System.out.println(stk.peek());
            stk.pop();
        }
    }
}
