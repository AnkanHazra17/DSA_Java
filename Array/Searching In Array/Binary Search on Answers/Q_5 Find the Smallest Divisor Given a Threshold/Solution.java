
// Question: Find the Smallest Divisor Given a Threshold

// Problem link: https://leetcode.com/problems/find-the-smallest-divisor-given-a-threshold/description/


public class Solution{

    // Function to find leargest value in the array
    static int findMax(int[] arr){
        int maxi = Integer.MIN_VALUE;

        for(int i = 0; i < arr.length; i++){
            maxi = Math.max(maxi, arr[i]);
        }

        return maxi;
    }

    // Function to sum the divisor
    static int findSumDivisor(int[] arr, int div){
        int sum = 0;

        for(int i = 0; i < arr.length; i++){
            sum += Math.ceil((double)(arr[i])/(double)(div));
        }

        return sum;
    }


    // Function to find Smallest divisor
    public static int smallestDivisor(int[] nums, int threshold) {
        int start = 1;           // Set start pointer as 1
        int end = findMax(nums); // Set end pointer as the leargest value of the array 
        int ans = -1;            // To keep track on answer which is lowest

        // Binary search Loop
        while(start <= end){
            int mid = start + (end - start) / 2;  // Calculate mid

            int sumDivisor = findSumDivisor(nums, mid); // Calculate sum of divisor

            // If sumDivisor less than or equal to the threshold keep it as ans 
            // ans ignoor upper value of mid 
            if(sumDivisor <= threshold){   
                ans = mid;
                end = mid - 1;
            }
            else{
                start = mid + 1;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {44,22,33,11,1};
        System.out.println(smallestDivisor(arr, 5));
    }
}