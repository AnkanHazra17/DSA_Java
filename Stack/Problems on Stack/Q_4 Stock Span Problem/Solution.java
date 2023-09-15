

// Question: Stock Span problem


import java.util.Arrays;
import java.util.Stack;


public class Solution{

    // This method calculates the stock span for each day in the given stock prices.
    // The stock span is the number of consecutive days (including the current day)
    // for which the stock price is less than or equal to the current day's price.
    public static void stockSpan(int[] stocks, int[] span){

        // Create a stack to keep track of indices of stock prices.
        Stack<Integer> st = new Stack<>();

        // Initialize the stack by pushing the index of the first day and set its span to 1.
        st.push(0);
        span[0] = 1;

        // Iterate through the stock prices from the second day to the last day.
        for (int i = 1; i < stocks.length; i++){
            int currentPrice = stocks[i];
            
            // While the stack is not empty and the current price is greater than or equal to
            // the price at the index stored at the top of the stack, pop elements from the stack.
            while(!st.isEmpty() && currentPrice >= stocks[st.peek()]){
                st.pop();
            }

            // If the stack is empty after popping elements, it means there are no
            // previous prices greater than the current price, so the span is the current index + 1.
            if(st.isEmpty()){
                span[i] = i + 1;
            }

            // If the stack is not empty, calculate the difference between the current index
            // and the index stored at the top of the stack to determine the span.
            else{
                int privHigh = st.peek();
                span[i] = i - privHigh;
            }

            // Push the current index onto the stack for future comparisons.
            st.push(i);
        }
    }

    public static void main(String[] args) {
        int[] stocks = {100, 80, 60, 70, 60, 85, 100};
        int[] span = new int[stocks.length];

        stockSpan(stocks, span);

        System.out.println(Arrays.toString(span));
    }
}

