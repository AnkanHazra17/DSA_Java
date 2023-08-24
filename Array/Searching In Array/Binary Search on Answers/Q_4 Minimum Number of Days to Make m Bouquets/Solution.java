

public class Solution{

    // Function to find the minimum value in an integer array
    public static int findMin(int[] arr){
        int mini = Integer.MAX_VALUE;         // Initialize 'mini' to the maximum possible integer value
        for(int i = 0; i < arr.length; i++){
            mini = Math.min(mini, arr[i]);    // Update 'mini' to the smaller of current element and 'mini'
        }
        return mini;    // Return the minimum value found
    }

    // Function to find the maximum value in an integer array
    public static int findMax(int[] arr){
        int maxi = Integer.MIN_VALUE;        // Initialize 'maxi' to the minimum possible integer value
        for(int i = 0; i < arr.length; i++){
            maxi = Math.max(maxi, arr[i]);   // Update 'maxi' to the larger of current element and 'maxi'
        }
        return maxi;     // Return the maximum value found
    }

    // Function to check if it's possible to create 'm' bouquets each with 'k' flowers using 'day' as the maximum bloom day
    public static int isPossible(int[] arr, int day, int m, int k){
        int cnt = 0;         // Initialize a counter for eligible flowers
        int cntBouquets = 0; // Initialize a counter for created bouquets

        for(int i = 0; i < arr.length; i++){
            if(arr[i] <= day){
                cnt++;    // Increment counter if the bloom day is within the limit
            }
            else{
                cntBouquets = cntBouquets + (cnt/k);  // Add created bouquets to counter
                cnt = 0;    // Reset flower counter since the current flower can't be used
            }
        }

        cntBouquets = cntBouquets + (cnt/k);   // Add any remaining bouquets after the loop

        if(cntBouquets >= m){
            return 1;    // If required bouquets are achievable, return 1
        }
        
        return 0;   // Otherwise, return 0
    }

    // Function to find the minimum number of days required to create 'm' bouquets each with 'k' flowers
    public static int minDays(int[] bloomDay, int m, int k) {

        if(bloomDay.length < m*k){
            return -1;     // If there aren't enough flowers to form required bouquets, return -1
        }

        int start = findMin(bloomDay);    // Find the minimum bloom day
        int end = findMax(bloomDay);      // Find the maximum bloom day

        while(start <= end){
            int day_Mid = start + (end - start) / 2;  // Calculate the middle bloom day

            // Check if it's possible to create bouquets using middle bloom day
            int possible = isPossible(bloomDay, day_Mid, m, k);

            if(possible == 0){
                start = day_Mid + 1;  // If not possible, move the start to the next day
            }
            else{
                end = day_Mid - 1;  // If possible, move the end to the previous day
            }
        }

        return start;  // Return the minimum number of days found
    }

    public static void main(String[] args) {
        int[] arr = {1,10,3,10,2};
        System.out.println(minDays(arr, 3, 2));
    }
}

