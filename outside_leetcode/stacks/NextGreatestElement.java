package outside_leetcode.stacks;

import java.util.Stack;
/*

Next Greater Element

Given an array, return the Next Greater Element for every element. The Next greater Element for an element x is the
 first greater element on the right side of x in the array. Elements for which no greater element exist,
 consider the next greater element as -1.

Input:
{2, 7, 3, 5, 4, 6, 8, 1}

Output:
{7, 8, 5, 6, 6, 8, -1, -1}

Return an integer vector containing the next greater element for each element
 */
public class NextGreatestElement {

    public static int[] naive(int[] arr) {
        int n = arr.length;
        int[] res = new int[n];
        int j;
        for (int i = 0; i < n; i++) {
            for (j = i + 1; j < n; j++) {
                if (arr[j] > arr[i]) {
                    res[i] = arr[j];
                    break;
                }
            }
            if (j == n) {
                res[i] = -1;
            }
        }
        return res;
    }

    //O(N) time and space
    public static int[] optimized(int[] arr) {
        int n = arr.length;
        Stack<Integer> stk = new Stack<>();
        int[] res = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            while (!stk.isEmpty() && arr[i] > stk.peek()) {
                stk.pop();
            }
            if (stk.isEmpty()) {
                res[i] = -1;
            } else {
                res[i] = stk.peek();
            }
            stk.push(arr[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {2, 7, 3, 5, 4, 6, 8, 1};
        int[] res1 = naive(arr);
        int[] res2 = optimized(arr);
        for (int num : res1) {
            System.out.print(num + " ");
        }
        System.out.println();
        for (int num : res2) {
            System.out.print(num + " ");
        }
    }
}