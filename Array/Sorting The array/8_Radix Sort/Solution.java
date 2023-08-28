import java.util.Arrays;

public class Solution{

    // Function to perform Counting Sort on an array
    public static void countSort(int[] arr, int exp){

        // Step 1: Create an array to store the count of each element
        int[] count = new int[10];

        // Step 2: Count the occurrences of each element in the input array
        for(int i = 0; i < arr.length; i++){
            int ind = arr[i] / exp % 10;
            count[ind]++; 
        }

        // Step 3: Prefix Sum array
        for(int i = 1; i < count.length; i++){
            count[i] = count[i] + count[i - 1];
        }

        // Step 4: Reconstruct the sorted array using the count array
        int[] ans = new int[arr.length];
        for(int i = arr.length - 1; i >= 0; i--){
            int val = arr[i] / exp % 10;
            int pos = count[val];
            int ind = pos - 1;
            ans[ind] = arr[i];
            count[val]--;
        }

        // Step 5: Copy ans array to the original array
        for(int i = 0; i < ans.length; i++){
            arr[i] = ans[i];
        }
    }

    // Function to perform radix sort
    public static void radixSort(int[] arr){
        // Step 1: Find the maximum value in the array
        int maxi = Integer.MIN_VALUE;
        for(int i = 0; i < arr.length; i++){
            maxi = Math.max(maxi, arr[i]);
        }

        int exp = 1;
        while(exp <= maxi){
            // Step 2: Perform count sort for every digit
            countSort(arr, exp);
            exp = exp*10;
        }

    }

    public static void main(String[] args) {
        int[] arr = {1, 290, 34, 190};
        radixSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}