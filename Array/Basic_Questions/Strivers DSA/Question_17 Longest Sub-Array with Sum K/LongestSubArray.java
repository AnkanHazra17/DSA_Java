
// Question: Longest Subarray With Sum K
// Given an array containing N integers and an integer K.
// Your task is to find the length of the longest Sub-Array
// with the sum of the elements equal to the given value K.


public class LongestSubArray{

    // Function to find the length of the longest subarray with a given sum K
    static int findLongest(int[] A, int N, int K){
        int len = 0;   // Initialize variable to store the length of the longest subarray
        int sum = 0;   // Initialize variable to keep track of the current sum of elements
        int left = 0;  // Initialize the left pointer for the sliding window technique

        for(int right = 0; right < N; right++){

            // Extend the window by adding the current element to the sum
            sum = sum + A[right];

            // Check if the sum is equal to the target sum K
            if(sum == K){
                // If the sum is equal to K, update the length variable if the current subarray is longer
                len = Math.max(len, right - left + 1);
            }

            // If the sum exceeds K, contract the window from the left side
            while(sum > K){
                // Subtract the element at the left pointer from the sum and move the left pointer to the right
                sum = sum - A[left];
                left++;
            }
        }

        return len;
    }

    public static void main(String[] args) {
        int[] arr = {-13, 0, 6, 15, 16, 2, 15, -12, 17, -16, 0, -3, 19, -3, 2, -9, -6};
        int N = arr.length;
        int K = 15;
        System.out.println(findLongest(arr, N, K));
    }
}

