package leetcode.arrays;

import java.util.*;
/*
LC: 1 : E: Two Sum
Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
You may assume that each input would have exactly one solution, and you may not use the same element twice.
You can return the answer in any order.
Example 1: Input: nums = [2,7,11,15], target = 9 Output: [0,1]
Example 2: Input: nums = [3,2,4], target = 6 Output: [1,2]
Example 3: Input: nums = [3,3], target = 6 Output: [0,1]

Constraints:

    2 <= nums.length <= 104
    -109 <= nums[i] <= 109
    -109 <= target <= 109
    Only one valid answer exists.

 */
public class TwoSum {

    /**
     TC: O(n²), for using two nested loops
     AS: O(1)
     */
    public static int[] usingNestedLoop(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{-1, -1};
    }

    public static boolean binarySearch(int[] arr, int low, int high, int target) {
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == target) return true;
            if (arr[mid] > target) high = mid - 1;
            else low = mid + 1;
        }
        return false;
    }

    /**
     TC: sort-> O(n log n), binary search -> O(Log N), arr traverse -> O(n)
     so, binary search + traverse -> O(N Log N)
     total: O(N log N) + O(N log N)
     AS: O(1)
     */
    public static boolean usingBinarySearch(int [] arr, int target) {
        Arrays.sort(arr);
        for(int i=0;i<arr.length;i++) {
            int complement = target - arr[i];
            if(binarySearch(arr, i + 1, arr.length, complement)) return true;
        }
        return false;
    }

    /**
     TC: sort -> O(N Log N), no traverse complexity becoz we don't traverse whole array
     AS: O(1)
     This approach is the best approach for a sorted array. But if array is not sorted, then we use hashing.
     */

    public static boolean usingTwoPointers(int [] arr, int target) {
        Arrays.sort(arr);
        int left = 0, right = arr.length-1;
        while(left < right) {
            int sum = arr[left] + arr[right];
            if(sum == target) return true;
            else if(sum > target) right--;
            else right++;
        }
        return false;
    }

    /*
     TC: O(n)
  AS: O(n)
     */
    public static List<Integer> usingMap(List<Integer> arr, int target) {
        Map<Integer, Integer> m = new HashMap<>();
        for(int i=0;i<arr.size();i++) {
            int complement = target - arr.get(i);
            if(m.containsKey(complement)) return Arrays.asList(m.get(complement), i);
            m.put(arr.get(i), i); // key value in arr, and value in map as index i
        }
        return Arrays.asList(-1,-1);
    }

    public static boolean usingHashSet(int [] arr, int target) {
        Set<Integer> s = new HashSet<>();
        for(int item: arr) {
            if(s.contains(target-item)) return true;
            s.add(item);
        }
        return false;
    }

    public static void main(String[] args) {

    }
}