package outside_leetcode.sorting;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Comparison-based sorting algorithm[just like selection sort].
 * Bubble Sort swaps adjacent elements, so the largest unsorted element "bubbles up".
 * Selection Sort minimizes swaps by selecting the right element in each pass.
 * <p>
 * Time Complexity:
 * - Worst: O(n^2)
 * - Average: O(n^2)
 * - Best: O(n) if array is already sorted
 * <p>
 * Stable, in-place sorting algorithm.
 * Cocktail sort is a better version that traverses from both ends.
 */
public class BubbleSort {

    static boolean compareF(int a, int b) {
        return a > b; // For ascending sort; use a < b for descending
    }

    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    //if(compareF(arr[j], arr[j+1])) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter array elements (space-separated):");
        String[] input = scanner.nextLine().trim().split("\\s+");
        scanner.close();

        int[] arr = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }

        bubbleSort(arr);

        System.out.println("Sorted array:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
