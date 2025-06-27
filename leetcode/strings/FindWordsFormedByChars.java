package leetcode.strings;
/**
 *  LC, E:  1160 Find Words That Can Be Formed by Characters
 * You are given an array of leetcode.strings words and a string chars. A string is good if it can be formed by characters from chars (each character can only be used once for each word in words).Return the sum of lengths of all good leetcode.strings in words.
 Example 1: Input: words = ["cat","bt","hat","tree", "cac"], chars = "atach" Output: 6
 Explanation: The leetcode.strings that can be formed are "cat" and "hat" so the answer is 3 + 3 = 6. No "cac" as chars have c only once

 Example 2: Input: words = ["hello","world","leetcode"], chars = "welldonehoneyr" Output: 10
 Explanation: The leetcode.strings that can be formed are "hello" and "world" so the answer is 5 + 5 = 10.

 * To form a string using characters from chars, the frequency of each character in chars must be greater than or equal the frequency of that character in the string to be formed.
 * whenever we have lower case english letters in context use 26 sized vector.
 * Time Complexity: O(m + n×k) where:
 m = length of chars
 n = number of words
 k = average length of words

 Space Complexity: O(1) - at most 26 characters in vector
 */
public class FindWordsFormedByChars {

    public static boolean canFormWord(int [] charCount, String word) {
        int [] wordCount = new int[26];
        for(char ch: word.toCharArray()) {
            wordCount[ch - 'a']++;
        }
        for(int i=0;i<26;i++) {
            if(wordCount[i] > charCount[i]) {
                return false;
            }
        }
        return true;
    }

    public static int countCharacters(String [] words, String chars) {
        int [] charCount = new int[26];
        for(char ch: chars.toCharArray()) {
            charCount[ch-'a']++;
        }
        int result = 0;
        for(String word: words) {
            if(canFormWord(charCount, word)) {
                result += word.length();
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String[] words = {"cat", "bt", "hat", "tree"};
        String chars = "atach";

        int result = countCharacters(words, chars);
        System.out.println("Result: " + result); // Expected output: 6
    }
}