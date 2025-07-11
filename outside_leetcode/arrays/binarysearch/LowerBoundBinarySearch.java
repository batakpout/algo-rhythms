package outside_leetcode.arrays.binarysearch;

import java.util.Scanner;

public class LowerBoundBinarySearch {

    //todo: implement in same way ceiling of an array
    public static int lowerBound(int[] arr, int VAL) {
        int low = 0;
        int high = arr.length - 1;
        int mid;
        int floor = -1;
        while (low <= high) {
            mid = low + (high - low) / 2;
            if (VAL > arr[mid]) {
                floor = arr[mid];
                low = mid + 1;
            } else if (VAL < arr[mid]) {
                high = mid - 1;
            } else {
                floor = arr[mid];
                break;
            }
        }
        return floor;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter arr: ");
        String[] elements = sc.nextLine().trim().split("\\s+");
        int[] arr = new int[elements.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(elements[i]);
        }
        System.out.println("Enter VAL");
        int VAL = sc.nextInt();
        int floor = lowerBound(arr, VAL);
        System.out.println("floor: " + floor);
    }
}
