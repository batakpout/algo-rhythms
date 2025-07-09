package leetcode.arrays;

public class FindPivotIndex {

    //O(N^2)
    public static int naive(int arr []) {
        int n  = arr.length;
        for(int i=0;i<n;i++) {
            int leftSum=0;
            for(int j=0;j<i;j++) {
               leftSum += arr[j];
            }
            int rightSum=0;
            for(int j=i+1;j<n;j++) {
                rightSum += arr[j];
            }
            if(leftSum == rightSum) return i;
        }
        return -1;
    }

    //O(N)
    //two pointer approach
    public static int pivotIndex(int[] nums) {
          int rs = 0;
          int n = nums.length;
          for(int num: nums)
              rs += num;
          int ls = 0;
          for(int i=0;i<n;i++) {
              rs -= nums[i];
              if(ls == rs) return i;
              ls += nums[i];
          }
          return -1;

    }
    public static void main(String[] args) {
        int [] arr = {11,7,3,6,5,6};
        int r = pivotIndex(arr);
        System.out.println(r);
    }
}
