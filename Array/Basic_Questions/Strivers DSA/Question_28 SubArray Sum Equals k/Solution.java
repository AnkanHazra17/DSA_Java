
// Question: Subarray Sum Equals K

// Given an array of integers nums and an integer k,
// return the total number of subarrays whose sum equals to k.




public class Solution{

    // Method to find the count of subarrays whose sum equals 'k'
    public static int subarraySum(int[] nums, int k) {
        int sum = 0;    // Variable to store the current sum of elements in the subarray
        int cnt = 0;    // Counter variable to store the count of subarrays whose sum equals 'k'
        int left = 0;   // Left pointer for the sliding window
        int n = nums.length;   // Variable to store the length of the input array 'nums'

        // Loop through the input array 'nums'
        for(int i = 0; i < n; i++){
            sum = sum + nums[i];  // Add the current element 'nums[i]' to the 'sum'

            // Sliding window loop: Reduce the window size from the left side until 'sum' becomes less than or equal to 'k'
            while(sum > k){
                sum = sum - nums[left];  // Remove the leftmost element from the 'sum'
                left++;    // Move the left pointer one step to the right
            }

            // Check if the 'sum' becomes equal to 'k', which means a subarray with desired sum is found
            if(sum == k){
                cnt++;    // Increment the counter variable 'cnt' as we found a valid subarray
            }
        }

        return cnt;   // Return the final count of subarrays whose sum equals 'k'
    }

    public static void main(String[] args) {
        int[] arr = {3, 1, 2, 4};
        System.out.println(subarraySum(arr, 6));
    }
}