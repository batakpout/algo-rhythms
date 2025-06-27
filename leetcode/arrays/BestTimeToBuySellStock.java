package leetcode.arrays;

/**
 * LC 121 : E:  Best Time to Buy and Sell Stock
 You are given an array prices where prices[i] is the price of a given stock on the ith day.

 You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.

 Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.



 Example 1:

 Input: prices = [7,1,5,3,6,4]
 Output: 5
 Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
 Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.

 Example 2:

 Input: prices = [7,6,4,3,1]
 Output: 0
 Explanation: In this case, no transactions are done and the max profit = 0.



 Constraints:

 1 <= prices.length <= 105
 0 <= prices[i] <= 104


 */

import java.util.Scanner;

public class BestTimeToBuySellStock {

    public static int bestTimeToSellAndBuyStock(int[] prices) {
        int maxProfit = Integer.MIN_VALUE;
        int cost;
        int mini = prices[0];
        for (int price : prices) { // start from i=0 so cost will get zero for input 7 6 5 4 else it will get -1
            cost = price - mini;
            maxProfit = Math.max(maxProfit, cost);
            mini = Math.min(mini, price);
        }
        return maxProfit;
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

        int res = bestTimeToSellAndBuyStock(arr);
        System.out.println("Max-Profit: " + res);
    }
}