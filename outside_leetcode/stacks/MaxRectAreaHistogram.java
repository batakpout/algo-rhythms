package outside_leetcode.stacks;

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

    //O(N) but more passes and space

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

    public static int method1(int[] heights) {
        int[] nsL = nextSmallestLeft(heights);
        int[] nsR = nextSmallestRight(heights);
        int maxArea = 0;
        for (int i = 0; i < heights.length; i++) {
            maxArea = Math.max(maxArea, heights[i] * (nsR[i] - nsL[i] - 1));
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int[] histogram = {6, 2, 5, 4, 5, 1, 6};
        System.out.println(naive(histogram));  // Output: 12
        System.out.println(method1(histogram));

    }
}
