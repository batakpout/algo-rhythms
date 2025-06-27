package leetcode.strings;

import java.util.Scanner;

/**
 * LC: E: 383. Ransom Note
 * Given two leetcode.strings ransomNote and magazine, return true if ransomNote can be constructed by using the letters from magazine and false otherwise.
 * Each letter in magazine can only be used once in ransomNote.
 * Example 1: Input: ransomNote = "a", magazine = "b" Output: false
 * Example 2: Input: ransomNote = "aa", magazine = "ab" Output: false
 * Example 3: Input: ransomNote = "aa", magazine = "aab" Output: true
 * <p>
 * Time Complexity:
 * First loop (over magazine):
 * Each character of magazine is visited once:
 * → O(m), where m is the length of magazine.
 * Second loop (over ransomNote):
 * Each character of ransomNote is visited once:
 * → O(n), where n is the length of ransomNote.
 * Total Time Complexity: O(m + n)
 * <p>
 * Space Complexity:
 * A vector<int> charCount(26) is used to count characters (assuming only lowercase English letters)
 * O(1) (constant space, since 26 is fixed and independent of input size)
 */

public class RansomNote {
    public static boolean canConstruct(String ransomNote, String magazine) {
        int[] charCount = new int[26];
        for (char ch : magazine.toCharArray()) {
            charCount[ch - 'a']++;
        }
        for (char ch : ransomNote.toCharArray()) {
            if (charCount[ch - 'a'] == 0) return false;
            charCount[ch - 'a']--;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter magazine: ");
        String magazine = scanner.nextLine();

        System.out.print("Enter ransom note: ");
        String ransomNote = scanner.nextLine();

        boolean result = canConstruct(ransomNote, magazine);
        System.out.println("Result: " + result);

        scanner.close();
    }
}