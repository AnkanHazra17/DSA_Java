// Question: Count Number of Nice Subarrays
// Link: https://leetcode.com/problems/count-number-of-nice-subarrays/description/

public class Solution {

    // Function to check if a number is odd
    public static boolean isOdd(int num) {
        return num % 2 == 1;
    }

    // Function to calculate the total number of subarrays with at least 'k' odd
    // elements
    public static int totalNumbers(int[] nums, int k) {
        int left = 0; // Initialize the left pointer
        int right = 0; // Initialize the right pointer
        int count = 0; // Initialize a counter for the number of odd elements in the current subarray
        int total = 0; // Initialize the total count of subarrays

        if (k < 0) {
            return 0; // If 'k' is negative, return 0 as there can't be any subarrays
        }

        // Iterate through the array using the right pointer
        while (right < nums.length) {
            if (isOdd(nums[right])) {
                count++; // If the current element is odd, increment the count of odd elements
            }

            // If the count of odd elements exceeds 'k', adjust the left pointer
            while (count > k) {
                if (isOdd(nums[left])) {
                    count--; // If the element at the left pointer is odd, decrement the count
                }
                left++; // Move the left pointer to the right
            }

            // Calculate the number of subarrays that satisfy the condition
            total = total + (right - left + 1);

            right++; // Move the right pointer to the right
        }

        return total; // Return the total count of subarrays
    }

    // Function to calculate the total number of subarrays with exactly 'k' odd
    // elements
    public static int numberOfSubarrays(int[] nums, int k) {
        int atleast = totalNumbers(nums, k); // Calculate the count of subarrays with at least 'k' odd elements
        int atmost = totalNumbers(nums, k - 1); // Calculate the count of subarrays with at most 'k-1' odd elements

        int exact = atleast - atmost; // Calculate the count of subarrays with exactly 'k' odd elements

        return exact; // Return the count of subarrays with exactly 'k' odd elements
    }

    public static void main(String[] args) {
        int[] arr = { 1, 1, 2, 1, 1 };
        System.out.println(numberOfSubarrays(arr, 3));
        int[] arr1 = { 2, 4, 6 };
        System.out.println(numberOfSubarrays(arr1, 1));
        int[] arr2 = { 2, 2, 2, 1, 2, 2, 1, 2, 2, 2 };
        System.out.println(numberOfSubarrays(arr2, 2));
    }
}
