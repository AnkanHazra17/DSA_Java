
// Count Sort


import java.util.Arrays;

public class Solution{

    // Function to perform Counting Sort on an array
    public static void countSort(int[] arr){

        // Step 1: Find the maximum value in the array
        int maxi = Integer.MIN_VALUE;
        for(int i = 0; i < arr.length; i++){
            maxi = Math.max(maxi, arr[i]);
        }

        // Step 2: Find min value of the array
        int mini = Integer.MAX_VALUE;
        for(int i = 0; i < arr.length; i++){
            mini = Math.min(mini, arr[i]);
        }

        // Step 3: Create an array to store the count of each element
        int[] count = new int[maxi - mini + 1];

        // Step 3: Count the occurrences of each element in the input array
        for(int i = 0; i < arr.length; i++){
            int ind = arr[i] - mini;
            count[ind]++; 
        }

        // Step 4: Prefix Sum array
        for(int i = 1; i < count.length; i++){
            count[i] = count[i] + count[i - 1];
        }

        // Step 5: Reconstruct the sorted array using the count array
        int[] ans = new int[arr.length];
        for(int i = arr.length - 1; i >= 0; i--){
            int val = arr[i];
            int pos = count[val - mini];
            int ind = pos - 1;
            ans[ind] = val;
            count[val - mini]--;
        }

        // Step 6: Copy ans array to the original array
        for(int i = 0; i < ans.length; i++){
            arr[i] = ans[i];
        }
    }

    public static void main(String[] args) {
        int[] arr = {3, 1, 5, 3, 7};
        countSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}

