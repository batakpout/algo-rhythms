package outside_leetcode.arrays;

public class LargestElement {
    public static int largestElement(int[] arr) {
        int max = arr[0];
        for (int j : arr) {
            if (j > max) {
                max = j;
            }
        }
        return max;
    }
}
