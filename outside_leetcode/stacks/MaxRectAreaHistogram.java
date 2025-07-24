package outside_leetcode.stacks;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.Stack;

class Pair {
    public int item;
    public int index;

    Pair(int item, int index) {
        this.item = item;
        this.index = index;
    }


}

public class MaxRectAreaHistogram {


    //O(N^2)
    public static int naive(int[] heights) {
        int n = heights.length;
        int maxArea = 0;

        for (int i = 0; i < n; i++) {
            int minHeight = heights[i];

            // Expand to the right of i
            for (int j = i; j < n; j++) {
                minHeight = Math.min(minHeight, heights[j]);
                int width = j - i + 1;
                int area = minHeight * width;
                maxArea = Math.max(maxArea, area);
            }
        }

        return maxArea;
    }


    public static int[] nextSmallestLeft(int[] heights) {
        Stack<Pair> stk = new Stack<>();
        int n = heights.length;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            if (stk.isEmpty()) {
                stk.push(new Pair(heights[i], i));
                arr[i] = -1;
            } else if (heights[i] > stk.peek().item) {
                arr[i] = stk.peek().index;
                stk.push(new Pair(heights[i], i));
            } else {
                while (!stk.isEmpty() && heights[i] <= stk.peek().item) {
                    stk.pop();
                }

                if (stk.isEmpty()) {
                    stk.push(new Pair(heights[i], i));
                    arr[i] = -1;
                } else {
                    arr[i] = stk.peek().index;
                    stk.push(new Pair(heights[i], i));
                }
            }
        }
        return arr;
    }

    public static int[] nextSmallestRight(int[] heights) {
        int n = heights.length;
        Stack<Pair> stk = new Stack<>();
        int[] arr = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            if (stk.isEmpty()) {
                arr[i] = n;
                stk.push(new Pair(heights[i], i));
            } else if (stk.peek().item < heights[i]) {
                arr[i] = stk.peek().index;
                stk.push(new Pair(heights[i], i));
            } else {
                while (!stk.isEmpty() && heights[i] <= stk.peek().item) {
                    stk.pop();
                }
                if (stk.isEmpty()) {
                    stk.push(new Pair(heights[i], i));
                    arr[i] = n;
                } else {
                    arr[i] = stk.peek().index;
                    stk.push(new Pair(heights[i], i));

                }
            }
        }
        return arr;
    }

    //O(N) but more passes and space
    public static int method1(int[] heights) {
        int[] nsL = nextSmallestLeft(heights);
        int[] nsR = nextSmallestRight(heights);
        int maxArea = 0;
        for (int i = 0; i < heights.length; i++) {
            maxArea = Math.max(maxArea, heights[i] * (nsR[i] - nsL[i] - 1));
        }
        return maxArea;
    }

    //beats 42% on leetcode why, check comment inside
    //In a single-threaded environment (like typical competitive programming problems on LeetCode),
    // this synchronization overhead is unnecessary and adds a performance penalty. It takes extra CPU cycles to acquire
    // and release the lock, even if no other thread is contending {struggling, fighting} for it.
    public static int optimized(int[] heights) {
        /**
         While push, pop, peek, isEmpty are O(1) operations, the underlying implementation might involve some overhead.
         java.util.Stack is synchronized (thread-safe), which adds a slight performance penalty compared to an
         ArrayDeque (which is generally preferred for stack-like behavior in single-threaded contexts in Java competitive programming for this reason)
         */
        Stack<Integer> stk = new Stack<>();
        int n = heights.length;
        int maxArea = 0;
        int i = 0;
        int top;
        while (i < n) {
            /**
             The methods peekLast(), addLast(), and removeLast() when used with an ArrayDeque are indeed typically faster
             than peek(), push(), and pop() from java.util.Stack.
             */
            if (stk.isEmpty() || heights[i] >= heights[stk.peek()]) {
                stk.push(i);
                i++; //just here
            } else {
                top = stk.peek();
                stk.pop();
                int width = stk.isEmpty() ? i : i - stk.peek() - 1;
                maxArea = Math.max(maxArea, heights[top] * width);
            }
        }

        while (!stk.isEmpty()) {
            top = stk.peek();
            stk.pop();
            int width = stk.isEmpty() ? i : i - stk.peek() - 1;
            maxArea = Math.max(maxArea, heights[top] * width);
        }
        return maxArea;
    }

    //more optimized beats 92% on leetcode
    public static int largestRectangleArea(int[] heights) {
        Deque<Integer> stk = new ArrayDeque<>();
        int n = heights.length;
        int maxArea = 0;
        int i = 0;
        int top;
        while (i < n) {
            if (stk.isEmpty() || heights[i] >= heights[stk.peekLast()]) {
                stk.addLast(i);
                i++;
            } else {
                top = stk.removeLast();
                int width = stk.isEmpty() ? i : i - stk.peekLast() - 1;
                maxArea = Math.max(maxArea, heights[top] * width);
            }
        }

        while (!stk.isEmpty()) {
            top = stk.removeLast();
            int width = stk.isEmpty() ? i : i - stk.peekLast() - 1;
            maxArea = Math.max(maxArea, heights[top] * width);
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int[] histogram = {6, 2, 5, 4, 5, 1, 6};
        System.out.println(naive(histogram));  // Output: 12
        System.out.println(method1(histogram));
        System.out.println(optimized(histogram));

    }
}
