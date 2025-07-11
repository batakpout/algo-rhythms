package outside_leetcode.arrays;

/*
 Given a sorted array and a number x, find a pair in array whose sum is closest to x.

Input Format

In the function an integer vector and number x is passed.

Output Format

Return a pair of integers.
Sample Input

    {10, 22, 28, 29, 30, 40}, x = 54

Sample Output

    22 and 30
 */
public class SortedPairSumClosest {

    public static int[] findSortedPair(int[] arr, int k) {
        int cs = 0;
        int left = 0;
        int diff = Integer.MAX_VALUE;
        int right = arr.length - 1;
        int leftIndex = -1, rightIndex = -1; // must initialize else compiler throws error
        while (left < right) {
            cs = arr[left] + arr[right];
            int currDiff = Math.abs(cs - k);
            if (currDiff < diff) {
                diff = currDiff;
                leftIndex = left;
                rightIndex = right;
            }
            if (cs > k) {
                right--;
            } else {
                left++;
            }
        }
        return new int[]{arr[leftIndex], arr[rightIndex]};
    }

    public static void main(String[] args) {
        int[] arr = {10, 22, 28, 29, 30, 40};
        int k = 54;
        int[] res = findSortedPair(arr, k);
        for (int num : res) {
            System.out.print(num + ", ");
        }

    }
}