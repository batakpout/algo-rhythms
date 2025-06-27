package outside_leetcode.sorting;

/**
 * - key idea: repeatedly find the minimum element from the unsorted part and putting it at the beginning.
 * - O(n^2) in all the cases.
 * - inner j loop runs maximum no of time so it runs: (n−1)+(n−2)+⋯+2+1= [n * (n−1)]/2
 * - The selection sort never makes more than O(N) swaps and can be useful when memory writing is costly.
 * - Does less memory writes compared to quick, merge, insertion sort etc but cycle-sort is optimal in terms of memory writes.
 * e.g in EEP ROM, writes are expensive
 * - gives basic idea for heap sort, it's just that heap sort uses heap DS to optimize selection sort.
 * - in-place [it does not require extra memory for sorting]
 * - Simple and easy to understand, Works well with small datasets.
 * - it is not stable [means the order of same elements change when we sort]
 * -  Does not work well on large datasets.
 */

import java.util.Scanner;

import static utils.ArrayUtils.*;

public class SelectionSort {


    public static void selectionSort(int[] arr) {
        int n = arr.length;
        int minIndex;
        for (int i = 0; i < n - 1; i++) {
            minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            if (i != minIndex) swap(arr, i, minIndex);
        }
    }

    /*
    - stable selection sort
    - replacing swaps with shifts
    - TC: O(n^2) but also performs shifts, which take O(n) in the worst case, so O(n^2) + O(n)
*/
    public static void selectionSortStable(int[] arr) {
        int n = arr.length;
        int minIndex;
        for (int i = 0; i < n - 1; i++) {
            minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            if (i != minIndex) {
                int minValue = arr[minIndex];
                for (int k = minIndex; k > i; k--) {
                    arr[k] = arr[k - 1];
                }
                arr[i] = minValue;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter integers separated by spaces:");
        String line = sc.nextLine();

        String[] parts = line.trim().split("[,\\s]+");
        int[] arr = new int[parts.length];
        for (int i = 0; i < parts.length; i++) {
            arr[i] = Integer.parseInt(parts[i]);
        }
        System.out.println("Entered unsorted array:");
        for (int j : arr) {
            System.out.print(j + " ");
        }
        System.out.println();
        selectionSort(arr);
        System.out.println("Sorted array:");
        for (int j : arr) {
            System.out.print(j + " ");
        }

    }
}
