package leetcode.arrays;

import java.util.*;

/**
 * LC: E: 136. Single Number
 * Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.
 * Example 1:Input: nums = [2,2,1] Output: 1
 * Example 2:Input: nums = [4,1,2,1,2] Output: 4
 * Example 3: Input: nums = [1] Output: 1

 */
public class SingleNumber {

    public static int singleNumberUsingMap(int[] nums) {
        Map<Integer, Integer> m = new HashMap<>();
        for (int num : nums) {
            m.put(num, m.getOrDefault(num, 0) + 1);
        }
        for (int num : nums) {
            if (m.get(num) == 1) return num;
        }
        return 0;
    }

    public static int usingXOR(int[] nums) {
        int xor = 0;
        for (int num : nums) {
            xor ^= num;
        }
        return xor;
    }

    public static void main(String[] args) {

    }
}