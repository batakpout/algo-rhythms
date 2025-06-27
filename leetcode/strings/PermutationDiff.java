package leetcode.strings;

import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;
/**
 * LC: E: 3146. Permutation Difference between Two Strings
 * Example 1: Input: s = "abc", t = "bac",the permutation difference between s and t is equal to |0 - 1| + |1 - 0| + |2 - 2| = 2.
 * Example 2:Input: s = "abcde", t = "edbac" Output: 12, permutation difference between s and t is equal to |0 - 3| + |1 - 2| + |2 - 4| + |3 - 1| + |4 - 0| = 12.


 */
public class PermutationDiff {

    //TC: O(n), SC: O(n)
    public static int findPermutationDifference(String s, String t) {
        Map<Character, Integer> m = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            m.put(s.charAt(i), i);
        }
        int res=0;
        for (int i = 0; i < t.length(); i++) {
            res += Math.abs((m.get(t.charAt(i)) - i));
        }
     return res;
    }

    //TC: O(N^2)
    public static int method2(String s, String t) {
        int res = 0, index = 0;
        for(int i=0;i<s.length();i++) {
            index = t.indexOf(s.charAt(i)); // O(N)
            res += Math.abs(index - i);
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter s: ");
        String s = sc.nextLine();

        System.out.print("Enter t: ");
        String t = sc.nextLine();

        int result = findPermutationDifference(s, t);
        System.out.println("Result: " + result);

        sc.close();
    }
}