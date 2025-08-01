package leetcode.arrays;

import java.util.Arrays;
import java.util.Scanner;

/**
 * LC 1913 : E
 * The product difference between two pairs (a, b) and (c, d) is defined as (a * b) - (c * d).
 *
 * For example, the product difference between (5, 6) and (2, 7) is (5 * 6) - (2 * 7) = 16.
 *
 * Given an integer array nums, choose four distinct indices w, x, y, and z such that the product difference between
 * pairs (nums[w], nums[x]) and (nums[y], nums[z]) is maximized.
 *
 * Return the maximum such product difference.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [5,6,2,7,4]
 * Output: 34
 * Explanation: We can choose indices 1 and 3 for the first pair (6, 7) and indices 2 and 4 for the second pair (2, 4).
 * The product difference is (6 * 7) - (2 * 4) = 34.
 *
 * Example 2:
 *
 * Input: nums = [4,2,5,9,7,4,8]
 * Output: 64
 * Explanation: We can choose indices 3 and 6 for the first pair (9, 8) and indices 1 and 5 for the second pair (2, 4).
 * The product difference is (9 * 8) - (2 * 4) = 64.
 *
 *
 *
 * Constraints:
 *
 *     4 <= nums.length <= 104
 *     1 <= nums[i] <= 104
 */
public class MaxProdDiffPairs {

    //O(n log n)
    public static int maxProductDifferenceUsingSorting(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        return nums[n - 1] * nums[n - 2] - nums[0] * nums[1];
    }

    public static int singlePass(int[] nums) {
        int largest = Integer.MIN_VALUE, secondLargest = Integer.MIN_VALUE;
        int smallest = Integer.MAX_VALUE, secondSmallest = Integer.MAX_VALUE;
        for (int num: nums) {
            if (num > largest) {
                secondLargest = largest;
                largest = num;
            } else secondLargest = Math.max(secondLargest, num);

            if (num < smallest) {
                secondSmallest = smallest;
                smallest = num;
            } else secondSmallest = Math.min(secondSmallest, num);
        }

        return largest * secondLargest - smallest * secondSmallest;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter integers separated by spaces:");
        String line = sc.nextLine();

        String[] parts = line.trim().split("[,\\s]+");
        int[] arr = new int[parts.length];
        for (int i = 0; i < parts.length; i++) {
            arr[i] = Integer.parseInt(parts[i]);
        }
        int res = singlePass(arr);
        System.out.println("res: " + res);
    }
}