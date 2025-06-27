package leetcode.strings;
/**
 * LE: E: 242. Valid Anagram Given two leetcode.strings s and t, return true if t is an anagram of s, and false otherwise.
 Example 1: Input: s = "anagram", t = "nagaram" Output: true
 Example 2: Input: s = "rat", t = "car" Output: false
 Constraints:
 1 <= s.length, t.length <= 5 * 104
 s and t consist of lowercase English letters.

 Follow up: What if the inputs contain Unicode characters? How would you adapt your solution to such a case?
 we will create count arr of size 128 so it can accomodate uni-code characters also
 */

import java.util.Arrays;
import java.util.Scanner;

public class ValidAnagram {

    //O(n log n)
    public static boolean usingSorting(String s, String t) {
        if (s.length() != t.length()) return false;
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();
        Arrays.sort(sArr);
        Arrays.sort(tArr);
        return Arrays.equals(sArr, tArr);

    }

    //O(N)
    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        int [] count = new int[26];
        for(char ch: s.toCharArray()) count[ch-'a']++;
        for(char ch: t.toCharArray()) count[ch-'a']--;

        for(int i: count) {
            if(i != 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter string s: ");
        String s = scanner.nextLine();

        System.out.print("Enter string t: ");
        String t = scanner.nextLine();

        System.out.println("usingSorting (by outside_leetcode.sorting): " + usingSorting(s, t));
        System.out.println("isAnagram (by count):   " + isAnagram(s, t));

        scanner.close();
    }
}