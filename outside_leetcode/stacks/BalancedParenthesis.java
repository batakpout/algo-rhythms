package outside_leetcode.stacks;

import java.util.Scanner;
import java.util.Stack;

public class BalancedParenthesis {

    public static boolean isMatching(char c1, char c2) {
        return (c1 == '{' && c2 == '}') ||
                (c1 == '[' && c2 == ']') ||
                c1 == '(' && c2 == ')';
    }

    /*
     Inside loop all ops are O(1)
     so TC: O(N) and SC: O(N)
     */
    public static boolean isBalanced(String str) {
        Stack<Character> stk = new Stack<>();
        for (char ch : str.toCharArray()) {
            if (ch == '[' || ch == '{' || ch == '(') {
                stk.push(ch);
            } else {
                if (stk.isEmpty()) return false;
                else if (!isMatching(stk.peek(), ch)) return false;
                else stk.pop();
            }
        }
        return stk.isEmpty();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine().trim();
        boolean res = isBalanced(input);
        System.out.println(res);
    }
}
