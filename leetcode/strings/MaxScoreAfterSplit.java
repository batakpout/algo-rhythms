package leetcode.strings;

import java.util.Scanner;

/**
 * LC: E: 1422. Maximum Score After Splitting a String
 * Given a string s of zeros and ones, return the maximum score after splitting the string into two non-empty
 * substrings (i.e. left substring and right substring).
 * The score after splitting a string is the number of zeros in the left substring plus the number of ones in the
 * right substring.
 * Example 1: Input: s = "011101" Output: 5
 * Explanation:
 * All possible ways of splitting s into two non-empty substrings are:
 * left = "0" and right = "11101", score = 1 + 4 = 5
 * left = "01" and right = "1101", score = 1 + 3 = 4
 * left = "011" and right = "101", score = 1 + 2 = 3
 * left = "0111" and right = "01", score = 1 + 1 = 2
 * left = "01110" and right = "1", score = 2 + 1 = 3
 * Example 2:
 * <p>
 * Input: s = "00111" Output: 5
 * Explanation: When left = "00" and right = "111", we get the maximum score = 2 + 3 = 5
 * Example 3: Input: s = "1111" Output: 3
 * <p>
 * Constraints:
 * 2 <= s.length <= 500
 * The string s consists of characters '0' and '1' only.
 */
public class MaxScoreAfterSplit {

    //TC: O(N^2)
    public static int bruteForce(String s) {
        int n = s.length();
        int maxScore = 0;
        for (int i = 0; i < n - 1; i++) {
            int zeros = 0;
            for (int j = 0; j <= i; j++) {
                if (s.charAt(j) == '0') zeros++;
            }
            int ones = 0;
            for (int j = i + 1; j < n; j++) {
                if (s.charAt(j) == '1') ones++;
            }
            maxScore = Math.max(maxScore, zeros + ones);
        }
        return maxScore;
    }

    //TC: O(N)
    public static int twoPasses(String s) {
        int totalOnes = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '1') totalOnes++;
        }

        int maxScore = 0, zeros = 0, leftOnes = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '0') zeros++;
            else leftOnes++;
            int rightOnes = totalOnes - leftOnes;
            maxScore = Math.max(maxScore, rightOnes + zeros);
        }
        return maxScore;
    }

    //O(N) (1 Pass            - Use equation)

    /**
     * no of 1's = 1 (left) + 1(right)
     * no of 0's = Z(left) + Z(right)
     * score = max of Z(left) + 1(right)
     * 1(right) = total_ones - 1(left)
     * so,
     * score = Z(left) + total_one - 1(left)
     * or score = max(Z(left) -1(left)) + total_ones
     */
    public static int singlePass(String s) {
        int n = s.length();
        int zeros = 0, ones = 0;
        int score = Integer.MIN_VALUE;

        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == '1') ones++;
            else zeros++;
            score = Math.max(score, zeros - ones);
        }

        if (s.charAt(n - 1) == '1') ones++;
        return ones + score;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string");
        String s = sc.nextLine();
        System.out.println("Brute Force: " + bruteForce(s));
        //System.out.println("Two Passes: " + sol.maxScoreTwoPasses(s));
        // System.out.println("Single Pass: " + sol.maxScore(s));
    }
}