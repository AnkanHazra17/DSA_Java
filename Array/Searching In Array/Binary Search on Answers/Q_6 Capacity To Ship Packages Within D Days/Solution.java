
// Question: Capacity to Ship Packages within D Days

// Problem link: https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/


public class Solution{

    // Function to find the maximum value in an array
    public static int findMaxi(int[] arr){
        int maxi = Integer.MIN_VALUE;

        for(int i = 0; i < arr.length; i++){
            maxi = Math.max(maxi, arr[i]);
        }

        return maxi;
    }

    // Function to calculate the sum of all elements in an array
    public static int findSum(int[] arr){
        int sumArr = 0;

        for(int i = 0; i < arr.length; i++){
            sumArr = sumArr + arr[i];
        }

        return sumArr;
    }

    // Function to simulate the shipping process and find the required days
    public static int findDays(int[] arr, int capacity){
        int days = 1;    // Initialize the day count
        int load = 0;    // Initialize the current load on the ship

        for(int i = 0; i < arr.length; i++){
            if(load + arr[i] > capacity){    // If adding the current item's weight exceeds capacity
                days = days + 1;             // Increment the day count
                load = arr[i];               // Reset the load to the current item's weight
            }
            else{
                load = load + arr[i];        // Add the current item's weight to the current load
            }
        }

        return days;      // Return the total days required to ship all items
    }

    // Binary search to find the minimum ship capacity required
    public static int shipWithinDays(int[] weights, int days) {
        int start = findMaxi(weights);    // Minimum possible capacity
        int end = findSum(weights);       // Maximum possible capacity
        int ans = 0;

        while(start <= end){
            int mid = start + (end - start)/2;   // Midpoint of the capacity range
            int day = findDays(weights, mid);    // Calculate days required at this capacity

            if(day <= days){
                ans = mid;       // Update answer to the current capacity
                end = mid - 1;   // Search for lower capacities in the left half
            }
            else{
                start = mid + 1;  // Search for higher capacities in the right half
            }
        }

        // Return the minimum ship capacity that meets the requirement
        return ans;  // or return start
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 1};
        System.out.println(shipWithinDays(arr, 2));
    }
}