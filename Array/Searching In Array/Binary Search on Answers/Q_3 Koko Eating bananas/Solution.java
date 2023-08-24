
// Question: Koko Eating Bananas

//Problem link: https://leetcode.com/problems/koko-eating-bananas/description/


public class Solution{

    // Function to find the maximum value in an integer array
    static int findMax(int[] arr){
        int maxi = Integer.MIN_VALUE;
        
        // Iterate through the array to find the maximum value
        for(int i = 0; i < arr.length; i++){
            maxi = Math.max(maxi, arr[i]);
        }

        return maxi;  // Return the maximum value
    }


    // Function to calculate the total hours required to consume piles of food
    public static int calculateTotalHours(int[] v, int hourly) {
        int totalH = 0;
        int n = v.length;
        
        // Iterate through the array of piles
        for (int i = 0; i < n; i++) {
            // Calculate hours required to consume the current pile and add it to the total
            totalH += Math.ceil((double)(v[i]) / (double)(hourly));
        }
        return totalH;   // Return the total hours
    }

    // Function to find the minimum eating speed to consume piles within given hours
    public static int minEatingSpeed(int[] piles, int h){

        int start = 1;              // Starting speed
        int end = findMax(piles);   // Maximum speed possible based on the largest pile

        // Binary search loop to find the optimal eating speed
        while(start <= end){
            int mid = start + (end - start) / 2;   // Calculate mid-point speed

            int totalHor = calculateTotalHours(piles, mid);  // Calculate hours at current speed

            if(totalHor <= h){    // Reduce speed if hours are within the given limit
                end = mid - 1;
            }
            else{
                start = mid + 1;   // Increase speed if hours exceed the given limit
            }
        }

        return start;  // Return the minimum eating speed
    }

    public static void main(String[] args) {
        int[] arr = {3, 6, 7, 11};
        System.out.println(minEatingSpeed(arr, 8));
    }
}

