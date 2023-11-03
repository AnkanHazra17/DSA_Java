// Question: Max Consecutive Ones III
// Link: https://leetcode.com/problems/max-consecutive-ones-iii/description/

public class Solution {

    public static int longestOnes(int[] nums, int k) {
        int left = 0; // Left pointer of the current subarray
        int right = 0; // Right pointer to iterate through the 'nums' array
        int len = 0; // Maximum length of subarray with at most 'k' zeros
        int zeroCount = 0; // Count of zeros in the current subarray

        // Loop through the 'nums' array from the beginning to the end.
        while (right < nums.length) {

            // If the current element at 'right' is 0, increment 'zeroCount'.
            if (nums[right] == 0) {
                zeroCount++;
            }

            // If 'zeroCount' exceeds the allowed 'k' zeros, move the 'left' pointer
            // and decrement 'zeroCount' until 'zeroCount' is less than or equal to 'k'.
            while (zeroCount > k) {
                if (nums[left] == 0) {
                    zeroCount--;
                }
                left++;
            }

            // Update 'len' with the maximum length between the current maximum and
            // the length of the current subarray (right - left + 1).
            len = Math.max(len, right - left + 1);

            // Move the 'right' pointer to process the next element in 'nums'.
            right++;
        }

        // Return the maximum length of a subarray with at most 'k' zeros.
        return len;
    }

    public static void main(String[] args) {
        int[] arr = { 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1 };
        System.out.println(longestOnes(arr, 3));
    }
}
