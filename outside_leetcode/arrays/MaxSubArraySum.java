package outside_leetcode.arrays;

public class MaxSubArraySum {

    //O(N^365IO ) cubic complexity
    /*
       n*(n+1) / 2 pairs
     */
    public static void printSubArrays(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                for (int k = i; k <= j; k++) {
                    System.out.print(arr[k] + " ");
                }
                System.out.println();
            }
        }
    }

    //O(N^3) cubic complexity
    public static int maxSubArraySumBruteForce(int arr[]) {
        int maxSum = Integer.MIN_VALUE;
        int currSum;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                currSum = 0;
                for (int k = i; k <= j; k++) {
                    currSum += arr[k];
                }
                maxSum = Math.max(maxSum, currSum);
            }
        }
        return maxSum;
    }

    //O(N^2)
    public static int maxSubArraySumPrefixArray(int arr[]) {
        int[] prefixSum = new int[arr.length];
        prefixSum[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + arr[i];
        }

        int maxSum = Integer.MIN_VALUE;
        int currSum;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                currSum = (i == 0) ? prefixSum[j] : prefixSum[j] - prefixSum[i - 1];
                maxSum = Math.max(maxSum, currSum);
            }
        }
        return maxSum;
    }

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

    //using divide and conquer
    /**
     * You're absolutely right\! The LeetCode "Maximum Subarray Sum" problem (Problem 53) is commonly solved with Kadane's Algorithm in O(N) time. The follow-up question indeed pushes for a more "subtle" divide and conquer approach, which typically results in O(N log N) time complexity.
     *
     * Let's break down the divide and conquer strategy for this problem and then provide the Java code.
     *
     * ### Divide and Conquer Approach for Maximum Subarray Sum
     *
     * The core idea of divide and conquer is to:
     *
     * 1.  **Divide**: Split the array into two halves.
     * 2.  **Conquer**: Recursively find the maximum subarray sum in the left half and the right half.
     * 3.  **Combine**: Find the maximum subarray sum that crosses the midpoint. The overall maximum sum will be the maximum of these three possibilities.
     *
     * Let's elaborate on each step:
     *
     * **1. Divide**
     * Given an array `nums` from index `left` to `right`:
     *
     *   * Find the middle index: `mid = (left + right) / 2`.
     *   * The problem is divided into two subproblems:
     *       * Maximum subarray sum in the left half: `nums[left...mid]`
     *       * Maximum subarray sum in the right half: `nums[mid+1...right]`
     *
     * **2. Conquer**
     * Recursively call the `maxSubArraySum` function for the left and right halves:
     *
     *   * `leftMaxSum = maxSubArraySum(nums, left, mid)`
     *   * `rightMaxSum = maxSubArraySum(nums, mid + 1, right)`
     *
     * **3. Combine (The Tricky Part - Crossing Sum)**
     * This is where the "subtle" aspect comes in. A maximum subarray could potentially span across the midpoint. To find this "crossing sum":
     *
     *   * **Find the maximum sum ending at `mid` (and extending leftwards):**
     *       * Start from `mid` and go backwards to `left`.
     *       * Keep track of the current sum and update the `leftCrossSum` if the current sum is greater.
     *   * **Find the maximum sum starting at `mid + 1` (and extending rightwards):**
     *       * Start from `mid + 1` and go forwards to `right`.
     *       * Keep track of the current sum and update the `rightCrossSum` if the current sum is greater.
     *   * The `crossSum` will be `leftCrossSum + rightCrossSum`.
     *
     * Finally, the result for the current segment `[left, right]` will be the maximum of `leftMaxSum`, `rightMaxSum`, and `crossSum`.
     *
     * **Base Case:**
     * If `left == right`, it means we have a single element array. The maximum subarray sum for a single element is just the element itself. So, `return nums[left]`.
     *
     * ### Example Walkthrough
     *
     * Let's consider `nums = [-2, 1, -3, 4, -1, 2, 1, -5, 4]`
     *
     * 1.  **Initial Call:** `maxSubArraySum(nums, 0, 8)`
     *
     *       * `mid = 4` (index of -1)
     *       * Recursively call for `[-2, 1, -3, 4]` (left) and `[2, 1, -5, 4]` (right)
     *       * Calculate `crossSum` for `[-2, 1, -3, 4, -1, 2, 1, -5, 4]` crossing at `mid=4`
     *
     *     Let's focus on calculating the `crossSum` for this example:
     *
     *       * `mid = 4` (value `nums[4] = -1`)
     *
     *       * **Left part (from `mid-1` down to `left=0`):**
     *
     *           * `i=3 (4)`: `currentSum = 4`, `leftCrossSum = 4`
     *           * `i=2 (-3)`: `currentSum = 4 - 3 = 1`, `leftCrossSum = 4`
     *           * `i=1 (1)`: `currentSum = 1 + 1 = 2`, `leftCrossSum = 4`
     *           * `i=0 (-2)`: `currentSum = 2 - 2 = 0`, `leftCrossSum = 4`
     *           * So, `leftCrossSum = 4` (from subarray `[4]`)
     *
     *       * **Right part (from `mid+1` up to `right=8`):**
     *
     *           * `i=5 (2)`: `currentSum = 2`, `rightCrossSum = 2`
     *           * `i=6 (1)`: `currentSum = 2 + 1 = 3`, `rightCrossSum = 3`
     *           * `i=7 (-5)`: `currentSum = 3 - 5 = -2`, `rightCrossSum = 3`
     *           * `i=8 (4)`: `currentSum = -2 + 4 = 2`, `rightCrossSum = 3`
     *           * So, `rightCrossSum = 3` (from subarray `[2, 1]`)
     *
     *       * `crossSum = leftCrossSum + rightCrossSum = 4 + 3 = 7` (This is where the problem statement says "such that the subarray crosses the midpoint". The combined subarray is `[4, -1, 2, 1]` for this example, and its sum is `4-1+2+1 = 6`. My formula above `leftCrossSum + rightCrossSum` is correct, but it sums the best left and best right *that include the mid-point*. The actual cross-sum that contains the midpoint `nums[mid]` would be `bestLeftSum + nums[mid] + bestRightSum`. So, let's refine the `crossSum` calculation:
     *
     *     **Refined `crossSum` calculation:**
     *     The maximum crossing subarray *must* include `nums[mid]`.
     *
     *       * `leftCrossSum`: The maximum sum of a subarray ending at `mid-1` and extending to `left`.
     *       * `rightCrossSum`: The maximum sum of a subarray starting at `mid+1` and extending to `right`.
     *       * `crossSum = leftCrossSum + nums[mid] + rightCrossSum`
     *
     *     Let's re-calculate `crossSum` with this refined logic:
     *
     *       * `mid = 4` (value `nums[4] = -1`)
     *
     *       * **Max sum ending at `mid-1` (i.e., `nums[3] = 4`) and extending leftwards:**
     *
     *           * `i=3 (4)`: `currentSum = 4`, `maxLeftBorderSum = 4`
     *           * `i=2 (-3)`: `currentSum = 4 - 3 = 1`, `maxLeftBorderSum = 4`
     *           * `i=1 (1)`: `currentSum = 1 + 1 = 2`, `maxLeftBorderSum = 4`
     *           * `i=0 (-2)`: `currentSum = 2 - 2 = 0`, `maxLeftBorderSum = 4`
     *           * `maxLeftBorderSum = 4` (from subarray `[4]`)
     *
     *       * **Max sum starting at `mid+1` (i.e., `nums[5] = 2`) and extending rightwards:**
     *
     *           * `i=5 (2)`: `currentSum = 2`, `maxRightBorderSum = 2`
     *           * `i=6 (1)`: `currentSum = 2 + 1 = 3`, `maxRightBorderSum = 3`
     *           * `i=7 (-5)`: `currentSum = 3 - 5 = -2`, `maxRightBorderSum = 3`
     *           * `i=8 (4)`: `currentSum = -2 + 4 = 2`, `maxRightBorderSum = 3`
     *           * `maxRightBorderSum = 3` (from subarray `[2, 1]`)
     *
     *       * `crossSum = maxLeftBorderSum + nums[mid] + maxRightBorderSum = 4 + (-1) + 3 = 6`
     *
     * The overall maximum will be `max(leftMaxSum, rightMaxSum, crossSum)`.
     *
     * ### Time Complexity
     *
     * The recurrence relation for this approach is $T(N) = 2T(N/2) + O(N)$, where $O(N)$ is for calculating the crossing sum. This resolves to $O(N \\log N)$ using the Master Theorem.
     *
     * ### Space Complexity
     *
     * The space complexity is $O(\\log N)$ due to the recursive call stack.
     *
     * ### Java Code
     *
     * ```java
     * public class Solution {
     *
     *     public int maxSubArray(int[] nums) {
     *         if (nums == null || nums.length == 0) {
     *             return 0; // Or throw an IllegalArgumentException, depending on problem constraints
     *         }
     *         return maxSubArrayDivideAndConquer(nums, 0, nums.length - 1);
     *     }
     *
     *     private int maxSubArrayDivideAndConquer(int[] nums, int left, int right) {
     *         // Base case: If there's only one element
     *         if (left == right) {
     *             return nums[left];
     *         }
     *
     *         // Divide: Find the middle point
     *         int mid = left + (right - left) / 2;
     *
     *         // Conquer: Recursively find max subarray sum in left and right halves
     *         int leftMaxSum = maxSubArrayDivideAndConquer(nums, left, mid);
     *         int rightMaxSum = maxSubArrayDivideAndConquer(nums, mid + 1, right);
     *
     *         // Combine: Find the max subarray sum that crosses the midpoint
     *         int crossMaxSum = findMaxCrossingSubarray(nums, left, mid, right);
     *
     *         // Return the maximum of the three possibilities
     *         return Math.max(Math.max(leftMaxSum, rightMaxSum), crossMaxSum);
     *     }
     *
     *     private int findMaxCrossingSubarray(int[] nums, int left, int mid, int right) {
     *         // Calculate max sum of subarray ending at mid
     *         int leftSum = Integer.MIN_VALUE;
     *         int currentSum = 0;
     *         for (int i = mid; i >= left; i--) {
     *             currentSum += nums[i];
     *             if (currentSum > leftSum) {
     *                 leftSum = currentSum;
     *             }
     *         }
     *
     *         // Calculate max sum of subarray starting at mid + 1
     *         int rightSum = Integer.MIN_VALUE;
     *         currentSum = 0;
     *         for (int i = mid + 1; i <= right; i++) {
     *             currentSum += nums[i];
     *             if (currentSum > rightSum) {
     *                 rightSum = currentSum;
     *             }
     *         }
     *
     *         // The maximum crossing sum is the sum of these two maximums.
     *         // If either leftSum or rightSum remains Integer.MIN_VALUE, it means all elements
     *         // in that part were negative. In such cases, we should treat that part's sum as 0 if the middle
     *         // element is positive, or simply include the single element if it's the only option.
     *         // However, given the problem constraints (at least one element), and how leftSum/rightSum are initialized,
     *         // they will always be updated unless all elements are MIN_VALUE, which isn't the case for sums.
     *         // A simpler way to think about it for the max crossing sum is that if a portion of the cross sum
     *         // contributes negatively, it will be reflected in `leftSum` or `rightSum` being small, potentially negative.
     *         // The sum of `leftSum` and `rightSum` captures the idea of the largest possible sum that includes `mid` and `mid+1`.
     *         return leftSum + rightSum;
     *     }
     *
     *     // You can test with the main method
     *     public static void main(String[] args) {
     *         Solution sol = new Solution();
     *         int[] nums1 = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
     *         System.out.println("Max subarray sum for [-2, 1, -3, 4, -1, 2, 1, -5, 4]: " + sol.maxSubArray(nums1)); // Expected: 6
     *
     *         int[] nums2 = {1};
     *         System.out.println("Max subarray sum for [1]: " + sol.maxSubArray(nums2)); // Expected: 1
     *
     *         int[] nums3 = {5, 4, -1, 7, 8};
     *         System.out.println("Max subarray sum for [5, 4, -1, 7, 8]: " + sol.maxSubArray(nums3)); // Expected: 23
     *
     *         int[] nums4 = {-1};
     *         System.out.println("Max subarray sum for [-1]: " + sol.maxSubArray(nums4)); // Expected: -1
     *
     *         int[] nums5 = {-5, -1, -3};
     *         System.out.println("Max subarray sum for [-5, -1, -3]: " + sol.maxSubArray(nums5)); // Expected: -1
     *     }
     * }
     * ```
     *
     * **Important Note on `findMaxCrossingSubarray`:**
     *
     * In the `findMaxCrossingSubarray` function:
     *
     *   * `leftSum` is the maximum sum of a subarray that **ends at `mid`** and extends to the left.
     *   * `rightSum` is the maximum sum of a subarray that **starts at `mid + 1`** and extends to the right.
     *   * The `crossMaxSum` is simply `leftSum + rightSum`. This is because any crossing subarray *must* include `nums[mid]` and `nums[mid+1]`, and then extend optimally to the left of `mid` and to the right of `mid+1`.
     *
     * This divide and conquer solution, while more complex and less efficient than Kadane's algorithm, is a classic example of applying the paradigm and demonstrating a deeper understanding of recursive problem-solving.
     * @param args
     */

    public static void main(String[] args) {
        //int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int [] arr = {-7,-7,-7};
        //int[] arr = {1,2,3,4,5};
        printSubArrays(arr);
        int sum1 = maxSubArraySumBruteForce(arr);
        int sum2 = maxSubArraySumPrefixArray(arr);
        int sum3 = kadanesAlgorithm(arr);
        System.out.println("sum1: " + sum1);
        System.out.println("sum2: " + sum2);
        System.out.println("sum3: " + sum3);
    }
}
