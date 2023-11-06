// Question: Binary Subarrays With Sum
// Link: https://leetcode.com/problems/binary-subarrays-with-sum/description/

public class Solution {

    // This method calculates the number of subarrays with a sum at most 'goal'.
    public static int atmost(int[] nums, int goal) {
        int left = 0; // Initialize the left pointer
        int right = 0; // Initialize the right pointer
        int sum = 0; // Initialize the current sum to 0.
        int ans = 0; // Initialize the answer to 0.

        // If the 'goal' is less than 0, there cannot be any valid subarrays.
        if (goal < 0) {
            return 0;
        }

        while (right < nums.length) { // Iterate through the array using the right pointer.
            sum = sum + nums[right]; // Add the current element to the sum.

            // If the sum becomes greater than 'goal', move the left pointer to reduce the
            // sum.
            while (sum > goal) {
                sum = sum - nums[left]; // Subtract the element at the left pointer from the sum.
                left++; // Move the left pointer to the right.
            }

            // Calculate the number of subarrays ending at the right pointer with sum at
            // most 'goal'.
            ans = ans + (right - left + 1);

            right++; // Move the right pointer to the right.
        }

        return ans; // Return the total number of subarrays with sum at most 'goal'.
    }

    // This method calculates the number of subarrays with a sum equal to 'goal'.
    public static int numSubarraysWithSum(int[] nums, int goal) {
        int atmostTwo = atmost(nums, goal); // Calculate subarrays with sum at most 'goal'.
        int atmostOne = atmost(nums, goal - 1); // Calculate subarrays with sum at most 'goal - 1'.
        int exactTwo = atmostTwo - atmostOne; // Calculate the exact number of subarrays with sum 'goal'.

        return exactTwo; // Return the count of subarrays with sum equal to 'goal'.
    }

    public static void main(String[] args) {
        int[] arr = { 0, 0, 0, 0, 0 };
        System.out.println(numSubarraysWithSum(arr, 0));
    }
}
