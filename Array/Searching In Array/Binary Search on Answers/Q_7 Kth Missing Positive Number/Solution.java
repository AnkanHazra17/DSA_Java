
// Question: Kth Missing Positive Number

// Problem Link: https://leetcode.com/problems/kth-missing-positive-number/description/



public class Solution{

    // Method to find the kth missing positive integer in a given array
    public static int findKthPositive(int[] arr, int k) {
        int low = 0;   //Initialize the lower bound
        int high = arr.length - 1;  // Initialize the higher bound

        // Perform a binary search within the range [low, high]
        while(low <= high){
            int mid = low + (high - low) / 2;    // Calculate the middle index
            int missing = arr[mid] - (mid + 1);  // Calculate the number of missing elements up to index 'mid'

            if(missing < k){
                // If there are less than 'k' missing elements up to index 'mid',
                // move the lower bound 'low' to 'mid + 1'
                low = mid + 1;
            }
            else{
                // If there are 'k' or more missing elements up to index 'mid',
                // move the higher bound 'high' to 'mid - 1'
                high = mid - 1;
            }
        }

        // The final result will be 'k' plus the number of missing elements up to index 'high + 1' (or 'low')
        return k + high + 1; // or k + low
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4};
        System.out.println(findKthPositive(arr, 4));
    }
}

