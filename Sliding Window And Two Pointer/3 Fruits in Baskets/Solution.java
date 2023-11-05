// Question: Fruit Into Baskets
// Link: https://leetcode.com/problems/fruit-into-baskets/description/

import java.util.HashMap;

public class Solution {

    public static int totalFruit(int[] fruits) {

        // Create a HashMap to keep track of the indices and counts of fruits in the
        // subarray
        HashMap<Integer, Integer> mpp = new HashMap<>();

        int left = 0; // Initialize the left pointer for the subarray
        int right = 0; // Initialize the right pointer for the subarray
        int maxFruit = 0; // Initialize the variable to store the maximum subarray length
        int basket = 0; // Initialize the count of distinct fruits in the subarray

        // Start a loop to process the fruits in the array
        while (right < fruits.length) {

            // Check if the fruit at the 'right' pointer is not in the current subarray
            if (!mpp.containsValue(fruits[right])) {
                basket++; // If not, increment the count of distinct fruits
            }
            mpp.put(right, fruits[right]); // Add the fruit to the HashMap 'mpp' with its index

            // Check if there are more than two distinct fruits in the subarray
            while (basket > 2) {
                mpp.remove(left); // Remove the fruit at the 'left' pointer from the HashMap

                // If the removed fruit is not in the current subarray, decrement the count
                if (!mpp.containsValue(fruits[left])) {
                    basket--;
                }

                left++; // Move the 'left' pointer to shrink the subarray
            }

            // Update 'maxFruit' with the maximum subarray length
            maxFruit = Math.max(maxFruit, right - left + 1);
            right++; // Move the 'right' pointer to expand the subarray
        }

        return maxFruit; // Return the maximum subarray length
    }

    public static void main(String[] args) {
        int[] arr = { 0, 0, 0, 0, 0, 0, 0, 1, 2, 3 };
        System.out.println(totalFruit(arr));
    }
}
