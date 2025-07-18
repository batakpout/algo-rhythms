package outside_leetcode.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/*
Array insert at index
Difficulty: BasicAccuracy: 44.81%Submissions: 113K+Points: 1

You are given an array arr(0-based index) and two positive integer index and val. You need to insert an val at given index.

Examples:

Input: arr[] = [1, 2, 3, 4, 5], index = 5, val = 90
Output: 1 2 3 4 5 90
Explanation: 90 is inserted at index 5(0-based indexing). After inserting,array elements are like [1, 2, 3, 4, 5, 90].

Input: arr[] = [1, 2, 3, 4, 5], index = 2, val = 90
Output: [1, 2, 90, 3, 4, 5]
Explanation: 90 is inserted at index 2(0-based indexing). After inserting, array elements are like [1, 2, 90, 3, 4, 5].
 */
public class ArrayItemInsertAtIndex {

    //just using arrays
    public static int[] insertAtIndex(int[] arr, int index, int val) {
        int[] newArr = new int[arr.length + 1];

        // Copy elements before the index
        for (int i = 0; i < index; i++) {
            newArr[i] = arr[i];
        }

        // Insert the new value at the index
        newArr[index] = val;

        // Copy remaining elements after the index
        for (int i = index; i < arr.length; i++) {
            newArr[i + 1] = arr[i];
        }

        return newArr;
    }

    public static void insertAtIndex(ArrayList<Integer> arr, int index, int val) {
        arr.add(0);  // Add dummy value to increase size
        for (int i = arr.size() - 1; i > index; i--) {
            arr.set(i, arr.get(i - 1));  // Shift right
        }
        arr.set(index, val);  // Insert at index
    }

    public static void main(String[] args) {

        int item = 90;
        int index = 2;
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));

        insertAtIndex(list, index, item);
        for (int num : list) {
            System.out.print(num + " ");
        }
    }
}
