package leetcode.strings;

import java.util.Scanner;

/**
 * LC: M: 1903. Largest Odd Number in String
 * <p>
 * You are given a string num, representing a large integer. Return the largest-valued odd integer (as a string) that is a non-empty substring of num, or an empty string "" if no odd integer exists.
 * A substring is a contiguous sequence of characters within a string.
 * Example 1: Input: num = "52" Output: "5"
 * Explanation: The only non-empty substrings are "5", "2", and "52". "5" is the only odd number.
 * <p>
 * Example 2:Input: num = "4206" Output: ""
 * Explanation: There are no odd numbers in "4206".
 * <p>
 * Example 3: Input: num = "35427" Output: "35427"
 * Explanation: "35427" is already an odd number.
 * <p>
 * This solution for it is called a greedy solution because it makes a locally optimal choice at each step without considering all possible alternatives,
 * and this local optimization leads to the globally optimal solution.
 * <p>
 * A non-greedy approach might generate all possible substrings, check which ones are odd, and then find the maximum - much more complex and unnecessary.
 * So it's greedy because it picks the first valid solution that maximizes what we want — the largest odd-valued substring — without backtracking or considering alternatives.
 */
public class LargestOddNoInString {

    //TC: O(N)
    public static String largestOddNumber(String num) {
        for (int i = num.length() - 1; i >= 0; i--) {
            if ((num.charAt(i) - '0') % 2 != 0) {
                return num.substring(0, i + 1);
            }
        }
        return "";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string");
        String s = sc.nextLine();
        String res = largestOddNumber(s);
        System.out.println("Result: " +res);
    }
}