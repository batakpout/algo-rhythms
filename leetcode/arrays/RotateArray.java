package leetcode.arrays;

import java.util.Scanner;

import static utils.ArrayUtils.swap;

/**
 * LC: 189 : M
 * Given an integer array nums, rotate the array to the right by k steps, where k is non-negative.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,3,4,5,6,7], k = 3
 * Output: [5,6,7,1,2,3,4]
 * Explanation:
 * rotate 1 steps to the right: [7,1,2,3,4,5,6]
 * rotate 2 steps to the right: [6,7,1,2,3,4,5]
 * rotate 3 steps to the right: [5,6,7,1,2,3,4]
 *
 * Example 2:
 *
 * Input: nums = [-1,-100,3,99], k = 2
 * Output: [3,99,-1,-100]
 * Explanation:
 * rotate 1 steps to the right: [99,-1,-100,3]
 * rotate 2 steps to the right: [3,99,-1,-100]
 */
public class RotateArray {

    private static void reverse(int left, int right, int[] nums) {
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }

    public static void rotate(int[] nums, int k) {
        int n = nums.length;
        if (k > n) k = k % n;
        if (k < 0) k = k + n;
        reverse(0, n - k - 1, nums);
        reverse(n - k, n - 1, nums);
        reverse(0, n - 1, nums);
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

        System.out.println("Enter k:");
        int k = sc.nextInt();
         rotate(arr, k);
        System.out.println("Reversed array:");
        for (int j : arr) {
            System.out.print(j + " ");
        }
    }
}