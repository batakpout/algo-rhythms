package outside_leetcode.sorting;

import java.util.Scanner;

public class MergeTwoArrays {
    public static int[] merge(int[] arr1, int[] arr2) {
        int n = arr1.length;
        int m = arr2.length;
        int[] merged = new int[n + m];
        int i = 0, j = 0, k = 0;
        while (i < n && j < m) {
            if (arr1[i] < arr2[j]) {
                merged[k++] = arr1[i++];
            } else {
                merged[k++] = arr2[j++];
            }
        }

        while (i < n) {
            merged[k++] = arr1[i++];
        }
        while (j < m) {
            merged[k++] = arr2[j++];
        }
        return merged;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter sorted arr1:");
        String line = sc.nextLine();

        String[] parts = line.trim().split("[,\\s]+");
        int[] arr1 = new int[parts.length];
        for (int i = 0; i < parts.length; i++) {
            arr1[i] = Integer.parseInt(parts[i]);
        }

        System.out.println("Enter sorted arr2:");
        line = sc.nextLine();

        parts = line.trim().split("[,\\s]+");
        int[] arr2 = new int[parts.length];
        for (int i = 0; i < parts.length; i++) {
            arr2[i] = Integer.parseInt(parts[i]);
        }

        System.out.println();
        int[] res = merge(arr1, arr2);
        System.out.println("merged array:");
        for (int j : res) {
            System.out.print(j + " ");
        }

    }
}