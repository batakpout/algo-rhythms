package leetcode.arrays.medium;

/**
 * LC: M: 53. Maximum Subarray
 * Solved
 * Medium
 * Topics
 * premium lock iconCompanies
 *
 * Given an integer array nums, find the
 *
 * with the largest sum, and return its sum.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
 * Output: 6
 * Explanation: The subarray [4,-1,2,1] has the largest sum 6.
 *
 * Example 2:
 *
 * Input: nums = [1]
 * Output: 1
 * Explanation: The subarray [1] has the largest sum 1.
 *
 * Example 3:
 *
 * Input: nums = [5,4,-1,7,8]
 * Output: 23
 * Explanation: The subarray [5,4,-1,7,8] has the largest sum 23.
 *
 * Example 4:
 * input: nums: [-1,-1,-1,-1]
 * output: -1
 *
 *  * Example 5:
 *  * input: nums: [-7]
 *  * output: -7
 *
 *
 *
 * Constraints:
 *
 *     1 <= nums.length <= 105
 *     -104 <= nums[i] <= 104
 *
 *
 *
 * Follow up: If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
 */
public class MaxSubArraySum {

    public static int kadanesAlgorithm(int [] nums) {
        int maxSum = Integer.MIN_VALUE;
        int cs = 0;
        int n = nums.length;
        for (int num : nums) {
            cs += num;
            if(cs > maxSum) {
                maxSum = cs;
            }
            if(cs < 0) {
                cs = 0;
            }
        }
        return maxSum;
    }
    public static void main(String[] args) {
        //int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int [] arr = {-7,-7,-7};
        //int[] arr = {1,2,3,4,5};

        int sum = kadanesAlgorithm(arr);
        System.out.println("sum1: " + sum);
    }

}
