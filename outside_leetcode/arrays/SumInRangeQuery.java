package outside_leetcode.arrays;

/*
 To compute the weighted sum:

    getWSum(2,4) = 1 * arr[2] + 2*arr[3] + 3 * arr[4];
                 = 1 * arr[l] + 2*arr[l+1] + ... + (r-l+1) * arr[r]
                 = ∑ from i=l to r of (i−l+1)⋅arr[i]
                 = ∑ from i=l to r of i⋅arr[i] − (l−1)⋅∑ from i=l to r of arr[i]

1⋅arr[0]+2⋅arr[1]+3⋅arr[2]=1⋅2+2⋅3+3⋅5=2+6+15=23

To do this efficiently:
1. Build two prefix sum arrays:
   - preSum[i] = arr[0] + arr[1] + ... + arr[i]
   - preWSum[i] = 0⋅arr[0] + 1⋅arr[1] + ... + (i)⋅arr[i]

2. Then we can compute:
    getWSum(l, r) = (preWSum[r] − preWSum[l−1]) − (l−1)⋅(preSum[r] − preSum[l−1])

This reduces each query to O(1) time after O(n) preprocessing.
 */
public class SumInRangeQuery {

    //O(N)
    public static int linearSolution(int[] arr, int l, int r) {
        int res = 0;
        for (int i = l; i <= r; i++) {
            res += arr[i];
        }
        return res;
    }

    //for O(1) solution build prefix-sum array
    public static int prefixSum(int[] arr, int l, int r) {
        int[] prefix = new int[arr.length];
        prefix[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            prefix[i] = prefix[i - 1] + arr[i];
        }
        if (l == 0) return prefix[r];
        else return prefix[r] - prefix[l - 1];
    }
    /*
      Weighted prefix sum
      arr = [2,3,5,4,6,1]
     l=0, r=2 == 1*arr[0] + 2*arr[1] == 23
     l=2, r=3 == 1*arr[2] + 2*arr[3]
     */

    private static int[] buildPrefixSumArr(int[] arr) {
        int[] prefix = new int[arr.length];
        prefix[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            prefix[i] = prefix[i - 1] + arr[i];
        }
        return prefix;
    }

    private static int[] buildWeightedPrefixSumArr(int[] arr) {
        int[] prefix = new int[arr.length];
        prefix[0] = 0; //0* arr[i] = 0
        for (int i = 1; i < arr.length; i++) {
            prefix[i] = prefix[i - 1] + i * arr[i];
        }
        return prefix;
    }

    public static int getWeightedSum(int[] arr, int l, int r) {
        int[] prefixSumArr = buildPrefixSumArr(arr);
        int[] weightedPrefixSumArr = buildWeightedPrefixSumArr(arr);

        int weightedSum = weightedPrefixSumArr[r] - ((l > 0) ? weightedPrefixSumArr[l - 1] : 0);
        int prefixSum = prefixSumArr[r] - ((l > 0) ? prefixSumArr[l - 1] : 0);

        return weightedSum - (l - 1) * prefixSum;
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 5, 4, 6, 1};
        int res = getWeightedSum(arr, 0, 2);
        System.out.println(res);
    }
}
