package outside_leetcode.stacks;

import java.util.Scanner;
import java.util.Stack;
/*
Given a string s, composed of different combinations of '(' , ')', '{', '}', '[', ']', verify the validity of the arrangement.
An input string is valid if:

         1. Open brackets must be closed by the same type of brackets.
         2. Open brackets must be closed in the correct order.

Examples :

Input: s = "[{()}]"
Output: true
Explanation: All the brackets are well-formed.

Input: s = "[()()]{}"
Output: true
Explanation: All the brackets are well-formed.

Input: s = "([]"
Output: False
Explanation: The expression is not balanced as there is a missing ')' at the end.

Input: s = "([{]})"
Output: False
Explanation: The expression is not balanced as there is a closing ']' before the closing '}'.
*/
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
