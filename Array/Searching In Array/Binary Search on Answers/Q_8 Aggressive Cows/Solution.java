
// Question: Aggressive Cows

// Problem Link: https://practice.geeksforgeeks.org/problems/aggressive-cows/1


import java.util.Arrays;

public class Solution{

    // Function to check if it's possible to place 'cows' number of cows with a minimum distance 'dist'
    public static boolean isPossible(int[] arr, int dist, int cows){
        int cntCows = 1;      // Initialize the count of placed cows as 1 (starting from the first stall)
        int last = arr[0];    // Initialize the position of the last placed cow as the first stall

        // Iterate through the stalls starting from the second stall
        for(int i = 1; i < arr.length; i++){

            // If the distance between the current stall and the last placed cow is at least 'dist'
            if(arr[i] - last >= dist){
                cntCows++;       // Increment the count of placed cows
                last = arr[i];   // Update the position of the last placed cow
            }
        }

        // Return true if the count of placed cows is greater than or equal to the required 'cows'
        return cntCows >= cows;
    }

    // Function to find the maximum minimum distance between cows that can be achieved by placing 'k' cows
    public static int aggressiveCows(int []stalls, int k) {
        Arrays.sort(stalls);       // Sort the array of stall positions in ascending order
        int n = stalls.length;     // Get the total number of stalls
        int low = 1;               // Initialize the lower bound of the binary search
        int high = stalls[n - 1] - stalls[0];   // Initialize the upper bound of the binary search

        // Perform binary search until the lower bound is less than or equal to the upper bound
        while(low <= high){
            int mid = low + (high - low) / 2;   // Calculate the middle value

            // If it's possible to place 'k' cows with a minimum distance 'mid'
            if(isPossible(stalls, mid, k)){
                low = mid + 1;    // Move the lower bound to search for larger distances
            }
            else{
                high = mid - 1;   // Move the upper bound to search for smaller distances
            }
        }

        // Return the maximum minimum distance achieved
        return high;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 8, 9};
        System.out.println(aggressiveCows(arr, 3));
    }
}

