package outside_leetcode.stacks;

import java.util.Stack;

/*
 The stock span problem is a financial problem where we have a series of daily price quotes for a stock and we need to
  calculate the span of stock price for all days. The span arr[i] of the stocks price on a given day i is defined as
   the maximum number of consecutive days just before the given day, for which the price of the stock on the given
   day is less than or equal to its price on the current day.

Examples:

Input: arr[] = [100, 80, 60, 70, 60, 75, 85]
Output: [1, 1, 1, 2, 1, 4, 6]
 */
public class StockSpan {

    public static void naive(int[] arr) {
        int span;
        for (int i = 0; i < arr.length; i++) {
            span = 1;
            for (int j = i - 1; j >= 0 && arr[j] <= arr[i]; j--) { //arr[j] <= arr[i]
                span++;
            }
            System.out.print(span + " ");
        }
    }

    //O(N) time and space complexity
    public static int[] optimized(int[] arr) {
        Stack<Integer> stk = new Stack<>();
        stk.push(0);
        int[] res = new int[arr.length];
        res[0] = 1;
        for (int i = 1; i < arr.length; i++) {
            while (!stk.isEmpty() && arr[stk.peek()] <= arr[i]) { //<=
                stk.pop();
            }
            if (stk.isEmpty()) {
                res[i] = i + 1;
            } else {
                res[i] = i - stk.peek();
            }
            stk.push(i);
        }
        return res;
    }

    public static void main(String[] args) {
       // int[] arr = {100, 80, 60, 70, 60, 75, 85};
        int[] arr = {60, 30, 70,40,40, 50};
        naive(arr);
        System.out.println();
        int[] res = optimized(arr);
        for (int i : res) {
            System.out.print(i + " ");
        }
    }
}