package leetcode.strings;

import java.util.Scanner;

/**
 * LC: E: 2264. Largest 3-Same-Digit Number in String
 * a string num representing a large integer. An integer is good if it meets the following conditions:
 * It is a substring of num with length 3 and it consists of only one unique digit.
 * <p>
 * Return the maximum good integer as a string or an empty string "" if no such integer exists.
 * Example 1: Input: num = "6777133339" Output: "777"ˀExplanation: There are two distinct good integers: "777" and "333".
 * "777" is the largest, so we return "777".
 * Example 2: Input: num = "2300019" Output: "000" Explanation: "000" is the only good integer.
 * Example 3: Input: num = "42352338" Output: ""
 * Explanation: No substring of length 3 consists of only one unique digit. Therefore, there are no good integers.
 * <p>
 * Constraint: 3 <= num.length <= 1000
 * <p>
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
public class LargestGoodInteger {

    public static String largestGoodInteger(String num) {
        char maxChar = ' ';
        for (int i = 2; i < num.length(); i++) {
            if (num.charAt(i) == num.charAt(i - 1) && num.charAt(i) == num.charAt(i - 2)) {
                maxChar = (char) Math.max(maxChar, num.charAt(i));
            }
        }
        if (maxChar == ' ') return "";
        return "" + maxChar + maxChar + maxChar;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number string: ");
        String num = sc.nextLine();
        String result = largestGoodInteger(num);
        System.out.println("Result: " + result);
        sc.close();
    }
}