package outside_leetcode.bitwise;

public class XOR {
    public static void main(String[] args) {
        int a = 5;     // Binary: 0101
        int b = 3;     // Binary: 0011

        int result1 = a ^ b;  // 0101 ^ 0011 = 0110 = 6

        System.out.println("5 ^ 3 = " + result1);

        // XOR with same numbers cancels out
        int c = 7;
        int result2 = c ^ c;  // Always 0
        System.out.println("7 ^ 7 = " + result2);

        // XOR with zero returns same value
        int d = 42;
        int result3 = d ^ 0;
        System.out.println("42 ^ 0 = " + result3);
    }
}
