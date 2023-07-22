
// Question: Maximum Subarray
// Given an integer array nums, find the 
// subarray
//  with the largest sum, and return its sum.

// Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
// Output: 6
// Explanation: The subarray [4,-1,2,1] has the largest sum 6.

public class Solution{

    // Method to find the maximum sum of a subarray in the given array
    public static int maxSubArray(int[] arr){

        //   Initialize the variable 'maxi' to store the maximum sum found so far,
        // initially set to the smallest possible integer value
        int maxi = Integer.MIN_VALUE;

        // Initialize the variable 'sum' to keep track of the current sum of elements in the subarray being considered
        int sum = 0;

        // Iterate through the elements of the array
        for(int i = 0; i < arr.length; i++){
            // Add the current element to the current sum
            sum = sum + arr[i];

            // Update 'maxi' to store the maximum value between the current 'maxi' and the current sum
            maxi = Math.max(maxi, sum);

            // If the current sum becomes negative, reset it to zero
            // This step ensures that we consider only positive contributions from the subarray
            if(sum < 0){
                sum = 0;
            }
        }

        // Return the maximum sum found in any subarray
        return maxi;
    }

    public static void main(String[] args) {
        int[] arr = {-7, -8, -16, -4, -8, -5, -7, -11, -10, -12, -4, -6, -4, -16, -10};
        System.out.println(maxSubArray(arr));
    }
}

