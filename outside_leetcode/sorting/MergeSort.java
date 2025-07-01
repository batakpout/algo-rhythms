package outside_leetcode.sorting;

import java.util.Scanner;

public class MergeSort {

    public static void merge(int[] arr, int low, int mid, int high) {
        int[] temp = new int[high - low + 1];
        int left = low;
        int right = mid+1;
        int index = 0;
        while (left <= mid && right <= high) {
            if (arr[left] < arr[right]) {
                temp[index++] = arr[left++];
            } else {
                temp[index++] = arr[right++];
            }
        }
        while (left <= mid) {
            temp[index++] = arr[left++];
        }
        while (right <= high) {
            temp[index++] = arr[right++];
        }

        for (int i = 0; i < temp.length; i++) {
            arr[low + i] = temp[i];
        }
    }
    //8 7 6 4 5 3 1 2
    public static void mergeSort(int[] arr, int low, int high) {
        if (low >= high) return;
        else {
            int mid = low + (high - low) / 2;
            mergeSort(arr, low, mid);
            mergeSort(arr, mid + 1, high);
            merge(arr, low, mid, high);
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
        System.out.println("Entered  array:");
        for (int j : arr) {
            System.out.print(j + " ");
        }
        System.out.println();
        mergeSort(arr, 0, arr.length-1);
        System.out.println("Sorted array:");
        for (int j : arr) {
            System.out.print(j + " ");
        }

    }
}
