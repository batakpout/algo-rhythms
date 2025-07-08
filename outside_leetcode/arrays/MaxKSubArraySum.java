package outside_leetcode.arrays;

public class MaxKSubArraySum {

        public static int naive(int[] arr, int k) {
            int maxSum = Integer.MIN_VALUE;
            int currSum = 0;
            int n = arr.length;
            for (int i = 0; i < n - k; i++) {
                currSum = 0;
                for (int j = i; j < k + i; j++) {
                    currSum += arr[j];
                }
                maxSum = Math.max(maxSum, currSum);
            }
            return maxSum;
        }

        public static int slidingWindow(int[] arr, int k) {
            int windowSum = 0;
            int maxSum = 0;
            for (int i = 0; i < k; i++) {
                windowSum += arr[i];
            }
            maxSum = windowSum;
            for (int i = k; i < arr.length; i++) {
                windowSum += arr[i] - arr[i - k];
                maxSum = Math.max(windowSum, maxSum);
            }
            return maxSum;
        }

        public static void main(String[] args) {
            int[] arr = {5, -10, 6, 90, 3};
            int s1 = naive(arr, 2);
            int s2 = slidingWindow(arr, 2);
            System.out.println(s1);
            System.out.println(s2);

        }
    }
