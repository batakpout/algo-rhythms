package outside_leetcode.arrays;

public class MaxSubArraySum {

    //O(N^365IO ) cubic complexity
    /*
       n*(n+1) / 2 pairs
     */
    public static void printSubArrays(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                for (int k = i; k <= j; k++) {
                    System.out.print(arr[k] + " ");
                }
                System.out.println();
            }
        }
    }

    //O(N^3) cubic complexity
    public static int maxSubArraySumBruteForce(int arr[]) {
        int maxSum = Integer.MIN_VALUE;
        int currSum;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                currSum = 0;
                for (int k = i; k <= j; k++) {
                    currSum += arr[k];
                }
                maxSum = Math.max(maxSum, currSum);
            }
        }
        return maxSum;
    }

    //O(N^2)
    public static int maxSubArraySumPrefixArray(int arr[]) {
        int[] prefixSum = new int[arr.length];
        prefixSum[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + arr[i];
        }

        int maxSum = Integer.MIN_VALUE;
        int currSum;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                currSum = (i == 0) ? prefixSum[j] : prefixSum[j] - prefixSum[i - 1];
                maxSum = Math.max(maxSum, currSum);
            }
        }
        return maxSum;
    }

    public static int kadanesAlgorithm(int [] nums) {
        int maxSum = Integer.MIN_VALUE;
        int cs = 0;
        int n = nums.length;
        for (int num : nums) {
            cs += num;
            if(cs > maxSum) {
                maxSum = cs;
            }
            if(cs < 0) {
                cs = 0;
            }
        }
        return maxSum;
    }

    public static void main(String[] args) {
        //int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int [] arr = {-7,-7,-7};
        //int[] arr = {1,2,3,4,5};
        printSubArrays(arr);
        int sum1 = maxSubArraySumBruteForce(arr);
        int sum2 = maxSubArraySumPrefixArray(arr);
        int sum3 = kadanesAlgorithm(arr);
        System.out.println("sum1: " + sum1);
        System.out.println("sum2: " + sum2);
        System.out.println("sum3: " + sum3);
    }
}
