package leetcode.arrays.arrays2d;

import java.util.*;

/**
 LC: E: 867. Transpose Matrix

 Given a 2D integer array matrix, return the transpose of matrix.
 The transpose of a matrix is the matrix flipped over its main diagonal, switching the matrix's row and column indices.
 Example 1:
 Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
 Output: [[1,4,7],[2,5,8],[3,6,9]]

 Example 2:
 Input: matrix = [[1,2,3],[4,5,6]]
 Output: [[1,4],[2,5],[3,6]]

 */
public class Transpose {
    /**
     TC: O(n*m), SC: O(n*m) but since it is used for result so it is ignored and we say O(1)
     */
    public int[][] transpose(int[][] matrix) {
        int r = matrix.length;
        int c = matrix[0].length;
        int[][] arr = new int[c][r];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                arr[j][i] = matrix[i][j];
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Paste input in format like [[1,2,3],[4,5,6],[7,8,9]]:");
        String input = sc.nextLine();

        // Remove brackets and split into rows
        input = input.replaceAll("\\[\\[", "").replaceAll("\\]\\]", "");
        String[] rows = input.split("\\],\\[");

        int[][] matrix = new int[rows.length][];
        for (int i = 0; i < rows.length; i++) {
            String[] nums = rows[i].split(",");
            matrix[i] = new int[nums.length];
            for (int j = 0; j < nums.length; j++) {
                matrix[i][j] = Integer.parseInt(nums[j].trim());
            }
        }

        System.out.println("Original matrix:");
        printMatrix(matrix);

        Transpose t = new Transpose();
        int[][] transposed = t.transpose(matrix);

        System.out.println("Transposed matrix:");
        printMatrix(transposed);
    }

    private static void printMatrix(int[][] mat) {
        for (int[] row : mat) {
            System.out.println(Arrays.toString(row));
        }
    }
}
