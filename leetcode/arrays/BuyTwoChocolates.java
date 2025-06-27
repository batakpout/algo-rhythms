package leetcode.arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * LC: E: 2706. Buy Two Chocolates
 * You are given an integer array prices representing the prices of various chocolates in a store. You are also given a single integer money,
 * which represents your initial amount of money.
 * You must buy exactly two chocolates in such a way that you still have some non-negative leftover money.
 * You would like to minimize the sum of the prices of the two chocolates you buy.
 * Return the amount of money you will have leftover after buying the two chocolates. If there is no way for you to buy two chocolates without ending up in debt,
 * return money. Note that the leftover must be non-negative.
 * <p>
 * Example 1: Input: prices = [1,2,2], money = 3 Output: 0
 * Explanation: Purchase the chocolates priced at 1 and 2 units respectively. You will have 3 - 3 = 0 units of money afterwards. Thus, we return 0.
 * Example 2: bInput: prices = [3,2,3], money = 3 Output: 3
 * Explanation: You cannot buy 2 chocolates without going in debt, so we return 3.
 * its greedy
 */
public class BuyTwoChocolates {

    //TC: O(n log n)
    public static int usingSorting(List<Integer> list, int money) {
        Collections.sort(list);
        int sum = list.get(0) + list.get(1);
        if (sum > money) return money;
        else return money - sum;
    }

    //O(N)
    public static int buyChoco(int[] prices, int money) {
        int smallest = Integer.MAX_VALUE, secondSmallest = Integer.MAX_VALUE;
        for (int price : prices) {
            if (price < smallest) {
                secondSmallest = smallest;
                smallest = price;
            } else {
                secondSmallest = Math.min(secondSmallest, price);
            }
        }
        int sum = smallest + secondSmallest;
        if(sum > money) return money;
        else return money - sum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter prices (space-separated): ");
        String line = scanner.nextLine();
        String[] parts = line.trim().split("\\s+");

        int[] prices = new int[parts.length];
        for (int i = 0; i < parts.length; i++) {
            prices[i] = Integer.parseInt(parts[i]);
        }

        System.out.print("Enter money: ");
        int money = scanner.nextInt();

        int res1 = buyChoco(prices, money);

        System.out.println("res1: " + res1);
    }
}