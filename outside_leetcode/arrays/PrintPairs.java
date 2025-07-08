package outside_leetcode.arrays;

public class PrintPairs {

    public static void printPairs(int [] arr) {
        int n = arr.length;
        for(int i=0;i<n;i++) {
            for(int j=i+1;j<n;j++) {
                System.out.println(arr[i] + ", " + arr[j]);
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int arr [] = {10,20,30,40,50,60};
        printPairs(arr);
    }
}
//ther eare leetcode questions on this like Leetcode - 1512 no of good pairs check
//codestorywithMIK series on hashset and hashmaps for this