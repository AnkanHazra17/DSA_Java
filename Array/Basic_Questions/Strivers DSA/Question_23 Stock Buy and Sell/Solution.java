
// Question: Best Time to Buy and Sell Stock
// You are given an array prices where prices[i] is the price of a given stock on the ith day.

// You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.

// Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.



public class Solution{

    // Function to calculate maximum profit from buying and selling stocks
    static int maxProfit(int[] prices){

        // Initialize variables to keep track of maximum profit and minimum cost (buying price)
        int maxP = 0;
        int minCost = prices[0];
        
        // Loop through the prices array to calculate the profit for each day
        for(int i = 0; i < prices.length; i++){

            // Calculate the profit for the current day by subtracting the minimum buying price from the current price
            int profit = prices[i] - minCost;
            // Update the maximum profit if the current profit is greater than the existing maximum profit
            maxP = Math.max(maxP, profit);
            // Update the minimum buying price if the current price is smaller than the existing minimum buying price
            minCost = Math.min(prices[i], minCost);
        }

        return maxP;  // Return the maximum profit after the loop ends
    }

    public static void main(String[] args) {
        int[] arr = {7,1,5,3,6,4};
        System.out.println(maxProfit(arr));
    }
}

