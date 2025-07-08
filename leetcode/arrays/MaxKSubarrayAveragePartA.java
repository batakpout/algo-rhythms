package leetcode.arrays;

/**

 You are given an integer array nums consisting of n elements, and an integer k.
 Find a contiguous subarray whose length is equal to k that has the maximum average value and return this value. Any answer with a calculation error less than 10-5 will be accepted.

 Example 1:

 Input: nums = [1,12,-5,-6,50,3], k = 4
 Output: 12.75000
 Explanation: Maximum average is (12 - 5 - 6 + 50) / 4 = 51 / 4 = 12.75

 Example 2:

 Input: nums = [5], k = 1
 Output: 5.00000



 Constraints:

 n == nums.length
 1 <= k <= n <= 105
 -104 <= nums[i] <= 104

 */
public class MaxKSubarrayAveragePartA {

    /**
     * there are a few subtle performance differences that can impact runtime and memory usage, especially on LeetCode,
     * where micro-optimizations matter for ranking.
      1. use int only , and at last do casting [double operations are slower than int operations in Java]
      2. do divide only at last [Division is an expensive operation]
     */
    public static double slidingWindow(int[] arr, int k) {
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
        return (double) maxSum / k;
    }

    public static void main(String[] args) {
        int[] arr = {5};
        double s = slidingWindow(arr, 1);
        System.out.println(s);

    }
}
